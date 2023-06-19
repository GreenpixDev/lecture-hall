package ru.hits.lecturehosting.hall.service;

import ru.hits.lecturehosting.hall.entity.Group;
import ru.hits.lecturehosting.hall.entity.Member;
import ru.hits.lecturehosting.hall.entity.id.MemberId;
import ru.hits.lecturehosting.hall.exception.GroupForbiddenException;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

public interface GroupPermissionService {

    default void checkAdminPermission(UserPrincipal principal, Group group) {
        checkAdminPermission(principal, group.getId());
    }

    void checkAdminPermission(UserPrincipal principal, UUID groupId);

    default void checkPermission(UserPrincipal principal, Group group) {
        checkAdminPermission(principal, group.getId());
    }

    void checkPermission(UserPrincipal principal, UUID groupId);

}
