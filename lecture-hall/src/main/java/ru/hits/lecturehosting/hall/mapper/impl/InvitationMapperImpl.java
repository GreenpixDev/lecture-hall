package ru.hits.lecturehosting.hall.mapper.impl;

import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Invitation;
import ru.hits.lecturehosting.hall.mapper.GroupMapper;
import ru.hits.lecturehosting.hall.mapper.InvitationMapper;

@Component
public class InvitationMapperImpl implements InvitationMapper {

    @Override
    public InvitationDto toDto(Invitation invitation) {
        return new InvitationDto(
            invitation.getId(),
            invitation.getCode(),
            invitation.getUsages(),
            invitation.getUsageLimit(),
            invitation.getExpirationDateTime()
        );
    }

    @Override
    public Invitation toEntity(CreationInvitationDto dto) {
        return Invitation.builder()
                .usageLimit(dto.getUsageLimit())
                .expirationDateTime(dto.getExpirationDateTime())
                .build();
    }

    @Override
    public Invitation partialUpdate(UpdateInvitationDto dto, Invitation invitation) {
        if (dto.getUsageLimit() != null) {
            invitation.setUsageLimit(dto.getUsageLimit());
        }
        if (dto.getExpirationDateTime() != null) {
            invitation.setExpirationDateTime(dto.getExpirationDateTime());
        }
        return invitation;
    }
}
