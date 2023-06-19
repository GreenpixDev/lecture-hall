package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.search.SearchMemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.service.MemberService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    @Override
    public PageDto<MemberDto> getGroupMembers(UserPrincipal principal, UUID groupId, int page, int size, SearchMemberDto dto) {
        return null;
    }

    @Override
    public void updateGroupMember(UserPrincipal principal, UUID groupId, UUID userId, UpdateMemberDto dto) {

    }

    @Override
    public void kickGroupMember(UserPrincipal principal, UUID groupId, UUID userId) {

    }
}
