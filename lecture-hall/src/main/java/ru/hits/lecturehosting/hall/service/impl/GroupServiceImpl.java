package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.JoiningGroupDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.search.SearchGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.User;
import ru.hits.lecturehosting.hall.entity.id.MemberId;
import ru.hits.lecturehosting.hall.exception.GroupForbiddenException;
import ru.hits.lecturehosting.hall.exception.GroupNotFoundException;
import ru.hits.lecturehosting.hall.exception.UnauthorizedException;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.repository.UserRepository;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final UserRepository userRepository;

    private final PageMapper pageMapper;

    @Override
    public PageDto<GroupDto> getGroups(UserPrincipal principal, int page, int size, SearchGroupDto dto) {
        // TODO query
        return pageMapper.toDto(groupRepository.findAll(PageRequest.of(page, size))
                .map(g -> new GroupDto(g.getId(), g.getName()))
        );
    }

    @Transactional
    @Override
    public void createGroup(UserPrincipal principal, CreationGroupDto dto) {
        User user = userRepository.findById(principal.getId())
                .orElseThrow(UnauthorizedException::new);
        Member member = Member.builder()
                .user(user)
                .administrator(true)
                .build();
        Group group = Group.builder()
                .owner(user)
                .name(dto.getName())
                .members(Set.of(member))
                .build();
        member.setGroup(group);
        groupRepository.save(group);
    }

    @Transactional
    @Override
    public void updateGroup(UserPrincipal principal, UUID groupId, UpdateGroupDto dto) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);

        checkAdminPermission(principal, groupId);

        group.setName(dto.getName());
        groupRepository.save(group);
    }

    @Transactional
    @Override
    public void deleteGroup(UserPrincipal principal, UUID groupId) {
        checkAdminPermission(principal, groupId);

        groupRepository.deleteById(groupId);
    }

    @Override
    public void joinToGroup(UserPrincipal principal, JoiningGroupDto dto) {

    }

    @Override
    public void quitFromGroup(UserPrincipal principal, UUID groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);
        if (principal.getId().equals(group.getOwner().getId())) {
            throw new GroupForbiddenException();
        }
        memberRepository.deleteById(new MemberId(principal.getId(), groupId));
    }

    private void checkAdminPermission(UserPrincipal principal, UUID groupId) {
        memberRepository.findById(new MemberId(principal.getId(), groupId))
                .filter(Member::isAdministrator)
                .orElseThrow(GroupForbiddenException::new);
    }
}
