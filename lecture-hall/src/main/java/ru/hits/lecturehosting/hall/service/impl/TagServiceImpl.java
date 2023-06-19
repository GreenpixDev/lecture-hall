package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.search.SearchTagDto;
import ru.hits.lecturehosting.hall.service.TagService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    @Override
    public PageDto<TagDto> getGroupTags(UserPrincipal principal, UUID groupId, int page, int size, SearchTagDto dto) {
        return null;
    }
}
