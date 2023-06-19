package ru.hits.lecturehosting.hall.mapper;

import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.create.CreationGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Invitation;

public interface GroupMapper {

    GroupDto toDto(Group group);

    Group toEntity(CreationGroupDto dto);

    Group partialUpdate(UpdateGroupDto dto, Group group);

}
