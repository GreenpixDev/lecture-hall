package ru.hits.lecturehosting.hall.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.mapper.GroupMapper;
import ru.hits.lecturehosting.hall.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class GroupMapperImpl implements GroupMapper {

    private final UserMapper userMapper;

    @Override
    public GroupDto toDto(Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                userMapper.toDto(group.getOwner())
        );
    }

    @Override
    public Group toEntity(CreationGroupDto dto) {
        return Group.builder()
                .name(dto.getName())
                .build();
    }

    @Override
    public Group partialUpdate(UpdateGroupDto dto, Group group) {
        if (dto.getName() != null) {
            group.setName(dto.getName());
        }
        return group;
    }
}
