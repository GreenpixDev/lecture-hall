package ru.hits.lecturehosting.hall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "group forbidden")
public class GroupForbiddenException extends RuntimeException {
}
