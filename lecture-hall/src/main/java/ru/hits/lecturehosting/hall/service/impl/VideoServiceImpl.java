package ru.hits.lecturehosting.hall.service.impl;

import com.vk.api.sdk.objects.responses.VideoUploadResponse;
import com.vk.api.sdk.objects.video.VideoFull;
import com.vk.api.sdk.objects.video.responses.SaveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.UploadVideoDto;
import ru.hits.lecturehosting.hall.dto.VideoDto;
import ru.hits.lecturehosting.hall.dto.amqp.AmqpVideoUpdateDto;
import ru.hits.lecturehosting.hall.dto.create.CreationVideoDto;
import ru.hits.lecturehosting.hall.dto.search.SearchVideoDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateVideoDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.entity.Video;
import ru.hits.lecturehosting.hall.exception.GroupNotFoundException;
import ru.hits.lecturehosting.hall.exception.SubjectNotFoundException;
import ru.hits.lecturehosting.hall.exception.VideoNotFoundException;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.mapper.VideoMapper;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.SubjectRepository;
import ru.hits.lecturehosting.hall.repository.VideoRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.HostingService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.service.VkApiService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final GroupRepository groupRepository;
    private final SubjectRepository subjectRepository;

    private final PageMapper pageMapper;
    private final VideoMapper videoMapper;

    private final GroupPermissionService groupPermissionService;
    private final VkApiService vkApiService;
    private final HostingService hostingService;

    @Override
    public PageDto<VideoDto> getGroupVideos(UserPrincipal principal, UUID groupId, int page, int size, SearchVideoDto dto) {
        groupPermissionService.checkPermission(principal, groupId);
        return pageMapper.toDto(videoRepository.searchAll(
                principal.getId(),
                // TODO query
                "%" + dto.getTextFilter() + "%",
                PageRequest.of(page, size)
        ).map(videoMapper::toDto));
    }

    @Override
    public VideoDto getVideo(UserPrincipal principal, UUID videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(VideoNotFoundException::new);

        groupPermissionService.checkPermission(principal, video.getGroup());

        return videoMapper.toDto(video);
    }

    @Transactional
    @Override
    public UploadVideoDto createGroupVideo(UserPrincipal principal, UUID groupId, CreationVideoDto dto) {
        groupPermissionService.checkPermission(principal, groupId);

        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);

        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .filter(e -> e.getGroup().getId().equals(groupId))
                .orElseThrow(SubjectNotFoundException::new);

        SaveResponse response = vkApiService.createVideo(dto.getTitle(), dto.getDescription());
        String uploadUrl = hostingService.generateVideoUploadUrl(response.getUploadUrl().toString());

        Video video = videoMapper.toEntity(dto);
        // TODO check mapper
        video.setSubject(subject);
        video.setGroup(group);
        video.setVkId(response.getVideoId());
        videoRepository.save(video);

        return new UploadVideoDto(uploadUrl);
    }

    @Transactional
    @Override
    public void updateVideo(UserPrincipal principal, UUID videoId, UpdateVideoDto dto) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(VideoNotFoundException::new);

        groupPermissionService.checkPermission(principal, video.getGroup());

        Video updatedVideo = videoMapper.partialUpdate(dto, video);
        if (dto.getSubjectId() != null) {
            Subject subject = subjectRepository.findById(dto.getSubjectId())
                    .filter(e -> e.getGroup().getId().equals(updatedVideo.getGroup().getId()))
                    .orElseThrow(SubjectNotFoundException::new);
            updatedVideo.setSubject(subject);
        }
        // TODO check mapper
        videoRepository.save(updatedVideo);
    }

    @Transactional
    @Override
    public void deleteVideo(UserPrincipal principal, UUID videoId) {
        Video video = videoRepository.findById(videoId)
                .orElseThrow(VideoNotFoundException::new);

        groupPermissionService.checkPermission(principal, video.getGroup());

        videoRepository.delete(video);
    }

    @Override
    public void updateVideoStatus(VideoUploadResponse response) {
        Video video = videoRepository.findByVkId(response.getVideoId()).orElse(null);
        if (video == null) return;

        VideoFull videoFull = vkApiService.getVideo(response.getVideoId()).orElse(null);
        if (videoFull == null) return;

        video.setPlayerUrl(videoFull.getPlayer().toString());
        videoRepository.save(video);
    }
}
