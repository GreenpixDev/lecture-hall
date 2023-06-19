package ru.hits.lecturehosting.hall.mapper;

import ru.hits.lecturehosting.hall.dto.TagDto;
import ru.hits.lecturehosting.hall.dto.UserDto;
import ru.hits.lecturehosting.hall.entity.Tag;
import ru.hits.lecturehosting.hall.entity.User;

public interface UserMapper {

    UserDto toDto(User user);

}
