package ru.hits.lecturehosting.hall.util;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import ru.hits.lecturehosting.hall.entity.User;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Data
public class UserPrincipal implements OAuth2User {

    private final UUID id;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Map<String, Object> attributes;

    public static UserPrincipal create(User user, OAuth2User oAuth2User) {
        return new UserPrincipal(
                user.getId(),
                oAuth2User.getAuthorities(),
                oAuth2User.getAttributes()
        );
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }
}
