package ru.hits.lecturehosting.hall.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.UserDto;
import ru.hits.lecturehosting.hall.entity.User;
import ru.hits.lecturehosting.hall.mapper.UserMapper;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getVkId()
        );
    }
}
