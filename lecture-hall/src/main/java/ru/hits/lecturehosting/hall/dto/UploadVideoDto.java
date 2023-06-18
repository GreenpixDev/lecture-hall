package ru.hits.lecturehosting.hall.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UploadVideoDto implements Serializable {

    private final String uploadUrl;

}
