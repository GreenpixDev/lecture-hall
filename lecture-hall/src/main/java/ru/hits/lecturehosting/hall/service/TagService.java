package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.search.SearchTagDto;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

public interface TagService {

    PageDto<TagDto> getGroupTags(UserPrincipal principal, UUID groupId, int page, int size, SearchTagDto dto);

}
