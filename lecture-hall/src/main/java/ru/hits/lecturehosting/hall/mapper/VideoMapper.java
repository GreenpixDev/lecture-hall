package ru.hits.lecturehosting.hall.mapper;

import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.VideoDto;
import ru.hits.lecturehosting.hall.dto.create.CreationVideoDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateVideoDto;
import ru.hits.lecturehosting.hall.entity.Subject;
import ru.hits.lecturehosting.hall.entity.Tag;
import ru.hits.lecturehosting.hall.entity.Video;

public interface VideoMapper {

    VideoDto toDto(Video video);

    Video toEntity(CreationVideoDto dto);

    Video partialUpdate(UpdateVideoDto dto, Video video);

}
