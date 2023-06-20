package ru.hits.lecturehosting.hall.mapper.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.VideoDto;
import ru.hits.lecturehosting.hall.dto.create.CreationVideoDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateVideoDto;
import ru.hits.lecturehosting.hall.entity.Video;
import ru.hits.lecturehosting.hall.mapper.SubjectMapper;
import ru.hits.lecturehosting.hall.mapper.VideoMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VideoMapperImpl implements VideoMapper {

    private final SubjectMapper subjectMapper;

    @Override
    public VideoDto toDto(Video video) {
        Map<UUID, TagInfo> tagValuesMap = new HashMap<>();
        video.getLabels().forEach(e -> {
            TagInfo info;
            if (tagValuesMap.containsKey(e.getKey().getId())) {
                info = tagValuesMap.get(e.getKey().getId());
            }
            else {
                info = new TagInfo(e.getKey().getName());
                tagValuesMap.put(e.getKey().getId(), info);
            }
            info.getValues().add(e.getValue());
        });

        return new VideoDto(
                video.getId(),
                video.getTitle(),
                video.getDescription(),
                subjectMapper.toDto(video.getSubject()),
                video.getCreationDateTime(),
                video.getRecordingDateTime(),
                tagValuesMap.entrySet().stream()
                        .map(e -> new TagDto(e.getKey(), e.getValue().getName(), e.getValue().getValues()))
                        .collect(Collectors.toList()),
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

    @Data
    public static class TagInfo {

        private final String name;
        private final List<String> values = new ArrayList<>();

    }
}
