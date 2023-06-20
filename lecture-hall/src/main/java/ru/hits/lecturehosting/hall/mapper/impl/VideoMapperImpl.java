package ru.hits.lecturehosting.hall.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.VideoDto;
import ru.hits.lecturehosting.hall.dto.create.CreationVideoDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateVideoDto;
import ru.hits.lecturehosting.hall.entity.Video;
import ru.hits.lecturehosting.hall.mapper.VideoMapper;

import java.util.List;
import java.util.Map;

@Component
public class VideoMapperImpl implements VideoMapper {

    @Override
    public VideoDto toDto(Video video) {
        return new VideoDto(
                video.getId(),
                video.getTitle(),
                video.getDescription(),
                video.getSubject().getId(),
                video.getCreationDateTime(),
                video.getRecordingDateTime(),
                List.of(), // TODO
                video.getPlayerUrl()
        );
    }

    @Override
    public Video toEntity(CreationVideoDto dto) {
        return Video.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .recordingDateTime(dto.getRecordingDateTime())
                // TODO .labels()
                .build();
    }

    @Override
    public Video partialUpdate(UpdateVideoDto dto, Video video) {
        if (dto.getTitle() != null) {
            video.setTitle(dto.getTitle());
        }
        if (dto.getDescription() != null) {
            video.setDescription(dto.getDescription());
        }
        if (dto.getTags() != null) {
            // TODO
        }
        return video;
    }
}
