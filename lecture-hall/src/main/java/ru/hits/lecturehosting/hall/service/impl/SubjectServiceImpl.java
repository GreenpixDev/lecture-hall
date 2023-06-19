package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.create.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.search.SearchSubjectDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateSubjectDto;
import ru.hits.lecturehosting.hall.entity.*;
import ru.hits.lecturehosting.hall.exception.GroupNotFoundException;
import ru.hits.lecturehosting.hall.exception.SubjectNotFoundException;
import ru.hits.lecturehosting.hall.mapper.PageMapper;
import ru.hits.lecturehosting.hall.mapper.SubjectMapper;
import ru.hits.lecturehosting.hall.repository.GroupRepository;
import ru.hits.lecturehosting.hall.repository.MemberRepository;
import ru.hits.lecturehosting.hall.repository.SubjectRepository;
import ru.hits.lecturehosting.hall.service.GroupPermissionService;
import ru.hits.lecturehosting.hall.service.SubjectService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final GroupRepository groupRepository;

    private final PageMapper pageMapper;
    private final SubjectMapper subjectMapper;

    private final GroupPermissionService groupPermissionService;

    @Override
    public PageDto<SubjectDto> getGroupSubjects(UserPrincipal principal, UUID groupId, int page, int size, SearchSubjectDto dto) {
        groupPermissionService.checkPermission(principal, groupId);
        return pageMapper.toDto(subjectRepository.searchAll(
                principal.getId(),
                "%" + dto.getNameFilter() + "%",
                PageRequest.of(page, size)
        ).map(subjectMapper::toDto));
    }

    @Transactional
    @Override
    public void createGroupSubject(UserPrincipal principal, UUID groupId, CreationSubjectDto dto) {
        groupPermissionService.checkPermission(principal, groupId);

        Group group = groupRepository.findById(groupId)
                .orElseThrow(GroupNotFoundException::new);

        Subject subject = subjectMapper.toEntity(dto);
        subject.setGroup(group);
        subjectRepository.save(subject);
    }

    @Transactional
    @Override
    public void updateSubject(UserPrincipal principal, UUID subjectId, UpdateSubjectDto dto) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(SubjectNotFoundException::new);

        groupPermissionService.checkPermission(principal, subject.getGroup());

        subjectRepository.save(subjectMapper.partialUpdate(dto, subject));
    }

    @Transactional
    @Override
    public void deleteSubject(UserPrincipal principal, UUID subjectId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(SubjectNotFoundException::new);

        groupPermissionService.checkPermission(principal, subject.getGroup());

        subjectRepository.delete(subject);
    }
}
