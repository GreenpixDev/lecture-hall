package ru.hits.lecturehosting.hall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "group not found")
public class GroupNotFoundException extends RuntimeException {
}
