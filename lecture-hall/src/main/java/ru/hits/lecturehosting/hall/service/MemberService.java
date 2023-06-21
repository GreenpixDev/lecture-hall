package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.BanDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.search.SearchMemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

public interface MemberService {

    PageDto<MemberDto> getGroupMembers(UserPrincipal principal, UUID groupId, int page, int size, SearchMemberDto dto);

    void updateGroupMember(UserPrincipal principal, UUID groupId, UUID userId, UpdateMemberDto dto);

    void kickGroupMember(UserPrincipal principal, UUID groupId, UUID userId);

    PageDto<BanDto> getGroupBannedMembers(UserPrincipal principal, UUID groupId, int page, int size);

    void banGroupMember(UserPrincipal principal, UUID groupId, UUID userId);

    void unbanGroupMember(UserPrincipal principal, UUID groupId, UUID userId);

}
