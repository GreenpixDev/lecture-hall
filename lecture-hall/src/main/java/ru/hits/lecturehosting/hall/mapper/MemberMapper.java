package ru.hits.lecturehosting.hall.mapper;

import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.entity.Invitation;
import ru.hits.lecturehosting.hall.entity.Member;

public interface MemberMapper {

    MemberDto toDto(Member member);

    Member partialUpdate(UpdateMemberDto dto, Member member);

}
