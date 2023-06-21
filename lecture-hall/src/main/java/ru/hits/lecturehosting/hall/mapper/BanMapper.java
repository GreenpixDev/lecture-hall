package ru.hits.lecturehosting.hall.mapper;

import ru.hits.lecturehosting.hall.dto.BanDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.entity.Ban;
import ru.hits.lecturehosting.hall.entity.Member;

public interface BanMapper {

    BanDto toDto(Ban ban);

}
