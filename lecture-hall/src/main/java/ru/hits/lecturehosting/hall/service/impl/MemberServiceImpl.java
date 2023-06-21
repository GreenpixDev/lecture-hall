package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.dto.BanDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.search.SearchMemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.entity.Ban;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.User;
import ru.hits.lecturehosting.hall.entity.id.BanId;
import ru.hits.lecturehosting.hall.entity.id.MemberId;
import ru.hits.lecturehosting.hall.exception.GroupNotFoundException;
import ru.hits.lecturehosting.hall.exception.MemberNotFoundException;
import ru.hits.lecturehosting.hall.exception.OperationForbiddenException;
import ru.hits.lecturehosting.hall.exception.OwnerForbiddenException;
import ru.hits.lecturehosting.hall.exception.UnauthorizedException;
import ru.hits.lecturehosting.hall.mapper.BanMapper;
import ru.hits.lecturehosting.hall.mapper.MemberMapper;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.repository.BanRepository;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.repository.UserRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.MemberService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final BanRepository banRepository;

    private final PageMapper pageMapper;
    private final MemberMapper memberMapper;
    private final BanMapper banMapper;

    private final GroupPermissionService groupPermissionService;

    @Transactional
    @Override
    public PageDto<MemberDto> getGroupMembers(UserPrincipal principal, UUID groupId, int page, int size, SearchMemberDto dto) {
        groupPermissionService.checkPermission(principal, groupId);
        return pageMapper.toDto(memberRepository.searchAll(
                groupId,
                PageRequest.of(page, size)
        ).map(memberMapper::toDto));
    }

    @Transactional
    @Override
    public void updateGroupMember(UserPrincipal principal, UUID groupId, UUID userId, UpdateMemberDto dto) {
        groupPermissionService.checkAdminPermission(principal, groupId);

        Member member = memberRepository.findById(new MemberId(userId, groupId))
                .orElseThrow(MemberNotFoundException::new);

        if (member.getUser().getId().equals(member.getGroup().getOwner().getId())) {
            throw new OwnerForbiddenException();
        }

        if (member.isAdministrator() && !member.getGroup().getOwner().getId().equals(principal.getId())) {
            throw new OperationForbiddenException();
        }

        memberRepository.save(memberMapper.partialUpdate(dto, member));
    }

    @Transactional
    @Override
    public void kickGroupMember(UserPrincipal principal, UUID groupId, UUID userId) {
        groupPermissionService.checkAdminPermission(principal, groupId);

        Member member = memberRepository.findById(new MemberId(userId, groupId))
                .orElseThrow(MemberNotFoundException::new);

        if (member.getUser().getId().equals(member.getGroup().getOwner().getId())) {
            throw new OwnerForbiddenException();
        }

        if (member.isAdministrator() && !member.getGroup().getOwner().getId().equals(principal.getId())) {
            throw new OperationForbiddenException();
        }

        memberRepository.delete(member);
    }

    @Transactional
    @Override
    public PageDto<BanDto> getGroupBannedMembers(UserPrincipal principal, UUID groupId, int page, int size) {
        groupPermissionService.checkAdminPermission(principal, groupId);
        return pageMapper.toDto(banRepository.searchAll(
                groupId,
                PageRequest.of(page, size)
        ).map(banMapper::toDto));
    }

    @Transactional
    @Override
    public void banGroupMember(UserPrincipal principal, UUID groupId, UUID userId) {
        groupPermissionService.checkAdminPermission(principal, groupId);

        kickGroupMember(principal, groupId, userId);

        User user = userRepository.findById(principal.getId())
                .orElseThrow(UnauthorizedException::new);
        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);

        banRepository.save(Ban.builder()
                .user(user)
                .group(group)
                .build()
        );
    }

    @Transactional
    @Override
    public void unbanGroupMember(UserPrincipal principal, UUID groupId, UUID userId) {
        groupPermissionService.checkAdminPermission(principal, groupId);

        banRepository.deleteById(new BanId(userId, groupId));
    }
}
