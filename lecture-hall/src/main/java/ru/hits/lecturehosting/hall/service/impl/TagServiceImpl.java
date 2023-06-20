package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.search.SearchTagDto;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.mapper.TagMapper;
import ru.hits.lecturehosting.hall.repository.TagRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.TagService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    private final PageMapper pageMapper;
    private final TagMapper tagMapper;

    private final GroupPermissionService groupPermissionService;

    @Override
    public PageDto<TagDto> getGroupTags(UserPrincipal principal, UUID groupId, int page, int size, SearchTagDto dto) {
        groupPermissionService.checkPermission(principal, groupId);
        return pageMapper.toDto(tagRepository.searchAll(
                groupId,
                "%" + (dto.getNameFilter() == null ? "" : dto.getNameFilter()) + "%",
                PageRequest.of(page, size)
        ).map(tagMapper::toDto));
    }
}
