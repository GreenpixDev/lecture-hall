package ru.hits.lecturehosting.hall.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.BanDto;
import ru.hits.lecturehosting.hall.entity.Ban;
import ru.hits.lecturehosting.hall.mapper.BanMapper;
import ru.hits.lecturehosting.hall.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class BanMapperImpl implements BanMapper {

    private final UserMapper userMapper;

    @Override
    public BanDto toDto(Ban ban) {
        return new BanDto(
                userMapper.toDto(ban.getUser()),
                ban.getCreationDateTime()
        );
    }
}
