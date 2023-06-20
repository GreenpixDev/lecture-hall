package ru.hits.lecturehosting.hall.config.jwt;

import lombok.Data;
import ru.hits.lecturehosting.hall.util.UserPrincipal;

import java.util.UUID;

@Data
public class JwtUser implements UserPrincipal {

    private final UUID id;

    @Override
    public String getName() {
        return id.toString();
    }
}
