package ru.hits.lecturehosting.hall.service;

import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.dto.InvitationDto;
import ru.hits.lecturehosting.hall.dto.PageDto;
import ru.hits.lecturehosting.hall.dto.SubjectDto;
import ru.hits.lecturehosting.hall.dto.create.CreationInvitationDto;
import ru.hits.lecturehosting.hall.dto.create.CreationSubjectDto;
import ru.hits.lecturehosting.hall.dto.search.SearchGroupDto;
import ru.hits.lecturehosting.hall.dto.search.SearchSubjectDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateInvitationDto;
import ru.hits.lecturehosting.hall.dto.update.UpdateSubjectDto;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

public interface SubjectService {

    PageDto<SubjectDto> getGroupSubjects(UserPrincipal principal, UUID groupId, int page, int size, SearchSubjectDto dto);

    SubjectDto getSubject(UserPrincipal principal, UUID subjectId);

    void createGroupSubject(UserPrincipal principal, UUID groupId, CreationSubjectDto dto);

    void updateSubject(UserPrincipal principal, UUID subjectId, UpdateSubjectDto dto);

    void deleteSubject(UserPrincipal principal, UUID subjectId);


}
