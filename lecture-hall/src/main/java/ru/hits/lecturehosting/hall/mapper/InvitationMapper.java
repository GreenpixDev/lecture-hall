package ru.hits.lecturehosting.hall.mapper;

import org.springframework.data.domain.Page;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateGroupDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Invitation;

public interface InvitationMapper {

    InvitationDto toDto(Invitation invitation);

    Invitation toEntity(CreationInvitationDto dto);

    Invitation partialUpdate(UpdateInvitationDto dto, Invitation invitation);

}
