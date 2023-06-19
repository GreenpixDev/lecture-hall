package ru.hits.lecturehosting.hall.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.dto.MemberDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateMemberDto;
import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.mapper.GroupMapper;
import ru.hits.lecturehosting.hall.mapper.MemberMapper;
import ru.hits.lecturehosting.hall.mapper.UserMapper;

@Component
@RequiredArgsConstructor
public class MemberMapperImpl implements MemberMapper {

    private final UserMapper userMapper;

    @Override
    public MemberDto toDto(Member member) {
        return new MemberDto(
                userMapper.toDto(member.getUser()),
                member.getJoiningDateTime(),
                member.isAdministrator()
        );
    }

    @Override
    public Member partialUpdate(UpdateMemberDto dto, Member member) {
        if (dto.getAdministration() != null) {
            member.setAdministrator(dto.getAdministration());
        }
        return null;
    }
}
