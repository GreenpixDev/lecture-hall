package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.id.MemberId;
import ru.hits.lecturehosting.hall.exception.GroupForbiddenException;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.GroupService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupPermissionServiceImpl implements GroupPermissionService {

    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;

    @Override
    public void checkOwnerPermission(UserPrincipal principal, UUID groupId) {
        groupRepository.findById(groupId)
                .filter(e -> e.getOwner().getId().equals(principal.getId()))
                .orElseThrow(GroupForbiddenException::new);
    }

    @Override
    public void checkAdminPermission(UserPrincipal principal, UUID groupId) {
        memberRepository.findById(new MemberId(principal.getId(), groupId))
                .filter(Member::isAdministrator)
                .orElseThrow(GroupForbiddenException::new);
    }

    @Override
    public void checkPermission(UserPrincipal principal, UUID groupId) {
        memberRepository.findById(new MemberId(principal.getId(), groupId))
                .orElseThrow(GroupForbiddenException::new);
    }
}
