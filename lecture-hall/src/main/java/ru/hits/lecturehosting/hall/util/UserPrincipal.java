package ru.hits.lecturehosting.hall.util;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.entity.User;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface UserPrincipal extends Principal {

    UUID getId();

}
