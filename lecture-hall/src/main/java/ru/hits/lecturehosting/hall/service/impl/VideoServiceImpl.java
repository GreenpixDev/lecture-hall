package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.UploadVideoDto;
import ru.hits.lecturehosting.hall.dto.VideoDto;
import ru.hits.lecturehosting.hall.dto.create.CreationVideoDto;
import ru.hits.lecturehosting.hall.dto.search.SearchVideoDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateVideoDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.entity.Video;
import ru.hits.lecturehosting.hall.exception.GroupNotFoundException;
import ru.hits.lecturehosting.hall.exception.InvitationNotFoundException;
import ru.hits.lecturehosting.hall.exception.SubjectNotFoundException;
import ru.hits.lecturehosting.hall.exception.VideoNotFoundException;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.mapper.SubjectMapper;
import ru.hits.lecturehosting.hall.mapper.VideoMapper;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.SubjectRepository;
import ru.hits.lecturehosting.hall.repository.VideoRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final GroupRepository groupRepository;

    private final PageMapper pageMapper;
    private final VideoMapper videoMapper;

    private final GroupPermissionService groupPermissionService;

    @Override
    public PageDto<VideoDto> getGroupVideos(UserPrincipal principal, UUID groupId, int page, int size, SearchVideoDto dto) {
        groupPermissionService.checkPermission(principal, groupId);
        // TODO query
        return pageMapper.toDto(videoRepository.findAll(PageRequest.of(page, size))
                .map(videoMapper::toDto)
        );
    }

    @Override
    public VideoDto getVideo(UserPrincipal principal, UUID videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(VideoNotFoundException::new);

        groupPermissionService.checkPermission(principal, video.getGroup());

        return videoMapper.toDto(video);
    }

    @Override
    public UploadVideoDto createGroupVideo(UserPrincipal principal, UUID groupId, CreationVideoDto dto) {
        groupPermissionService.checkPermission(principal, groupId);

        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);

        // TODO create video resource (upload url)
        String playerUrl = "http://mock";
        String uploadUrl = "http://mock";

        Video video = videoMapper.toEntity(dto);
        // TODO check mapper
        video.setGroup(group);
        video.setPlayerUrl(playerUrl);
        videoRepository.save(video);

        return new UploadVideoDto(uploadUrl);
    }

    @Override
    public void updateVideo(UserPrincipal principal, UUID videoId, UpdateVideoDto dto) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(VideoNotFoundException::new);

        groupPermissionService.checkPermission(principal, video.getGroup());

        // TODO check mapper
        videoRepository.save(videoMapper.partialUpdate(dto, video));
    }

    @Override
    public void deleteVideo(UserPrincipal principal, UUID videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(VideoNotFoundException::new);

        groupPermissionService.checkPermission(principal, video.getGroup());

        videoRepository.delete(video);
    }
}
