package ru.hits.lecturehosting.hall.service;

import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.UploadVideoDto;
import ru.hits.lecturehosting.hall.dto.VideoDto;
import ru.hits.lecturehosting.hall.dto.create.CreationVideoDto;
import ru.hits.lecturehosting.hall.dto.search.SearchVideoDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateVideoDto;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

public interface VideoService {

    PageDto<VideoDto> getGroupVideos(UserPrincipal principal, UUID groupId, int page, int size, SearchVideoDto dto);

    VideoDto getVideo(UserPrincipal principal, UUID videoId);

    UploadVideoDto createGroupVideo(UserPrincipal principal, UUID groupId, CreationVideoDto dto);

    void updateVideo(UserPrincipal principal, UUID videoId, UpdateVideoDto dto);

    void deleteVideo(UserPrincipal principal, UUID videoId);

}
