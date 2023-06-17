package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.dto.GroupDto;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.service.GroupService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<GroupDto> getGroups(OAuth2User user) {
        // TODO проверить производительность
        return memberRepository.findAllByUserVkId(user.getAttribute("id"))
                .stream()
                .map(Member::getGroup)
                .map(g -> new GroupDto(g.getId(), g.getName())) // TODO mapper
                .toList();
    }
}
