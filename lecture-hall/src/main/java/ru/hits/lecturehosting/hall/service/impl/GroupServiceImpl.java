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
import ru.hits.lecturehosting.hall.mapper.GroupMapper;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.repository.UserRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
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
    private final GroupMapper groupMapper;

    private final GroupPermissionService groupPermissionService;

    @Override
    public PageDto<GroupDto> getGroups(UserPrincipal principal, int page, int size, SearchGroupDto dto) {
        return pageMapper.toDto(groupRepository.searchAll(
                principal.getId(),
                "%" + dto.getNameFilter() + "%",
                PageRequest.of(page, size)
        ).map(groupMapper::toDto));
    }

    @Transactional
    @Override
    public void createGroup(UserPrincipal principal, CreationGroupDto dto) {
        User owner = userRepository.findById(principal.getId())
                .orElseThrow(UnauthorizedException::new);

        Group group = groupMapper.toEntity(dto);
        group.setOwner(owner);
        group.setMembers(Set.of(Member.builder()
                .user(owner)
                .group(group)
                .administrator(true)
                .build()
        ));

        groupRepository.save(group);

        // TODO create VK group
    }

    @Transactional
    @Override
    public void updateGroup(UserPrincipal principal, UUID groupId, UpdateGroupDto dto) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);

        groupPermissionService.checkAdminPermission(principal, group);

        groupRepository.save(groupMapper.partialUpdate(dto, group));
    }

    @Transactional
    @Override
    public void deleteGroup(UserPrincipal principal, UUID groupId) {
        groupPermissionService.checkAdminPermission(principal, groupId);

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
}
