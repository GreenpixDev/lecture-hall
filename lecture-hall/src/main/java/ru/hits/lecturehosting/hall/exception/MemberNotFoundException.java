package ru.hits.lecturehosting.hall.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "member not found")
public class MemberNotFoundException extends RuntimeException {
}
