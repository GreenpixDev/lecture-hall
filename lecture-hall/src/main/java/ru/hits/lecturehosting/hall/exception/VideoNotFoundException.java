package ru.hits.lecturehosting.hall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "video not found")
public class VideoNotFoundException extends RuntimeException {
}
