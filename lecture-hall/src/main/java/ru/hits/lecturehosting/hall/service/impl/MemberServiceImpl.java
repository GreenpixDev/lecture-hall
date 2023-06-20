package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.search.SearchMemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.id.MemberId;
import ru.hits.lecturehosting.hall.exception.MemberNotFoundException;
import ru.hits.lecturehosting.hall.exception.OperationForbiddenException;
import ru.hits.lecturehosting.hall.exception.OwnerForbiddenException;
import ru.hits.lecturehosting.hall.mapper.MemberMapper;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.MemberService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final PageMapper pageMapper;
    private final MemberMapper memberMapper;

    private final GroupPermissionService groupPermissionService;

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
}
