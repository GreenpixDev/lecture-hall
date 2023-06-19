package ru.hits.lecturehosting.hall.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.create.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.search.SearchSubjectDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateSubjectDto;
import ru.hits.lecturehosting.hall.service.SubjectService;
import ru.hits.lecturehosting.hall.service.VideoService;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    @Override
    public PageDto<SubjectDto> getGroupSubjects(UserPrincipal principal, UUID groupId, int page, int size, SearchSubjectDto dto) {
        return null;
    }

    @Override
    public void createGroupSubject(UserPrincipal principal, UUID groupId, CreationSubjectDto dto) {

    }

    @Override
    public void updateSubject(UserPrincipal principal, UUID subjectId, UpdateSubjectDto dto) {

    }

    @Override
    public void deleteSubject(UserPrincipal principal, UUID subjectId) {

    }
}
