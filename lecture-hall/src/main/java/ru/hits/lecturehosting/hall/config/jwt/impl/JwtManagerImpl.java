package ru.hits.lecturehosting.hall.config.jwt.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.jetbrains.annotations.NotNull;
import ru.hits.lecturehosting.hall.config.jwt.JwtManager;
import ru.hits.lecturehosting.hall.config.jwt.JwtUser;

import javax.crypto.SecretKey;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

public class JwtManagerImpl implements JwtManager {

    private final long expirationMinutes;
    private final Clock clock;
    private final SecretKey secretKey;

    public JwtManagerImpl(String secretKey, long expirationMinutes, Clock clock) {
        this.expirationMinutes = expirationMinutes;
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        this.clock = Clock.systemDefaultZone();
    }

    public JwtManagerImpl(String secretKey, long expirationMinutes) {
        this(secretKey, expirationMinutes, Clock.systemDefaultZone());
    }

    @Override
    public @NotNull String generateToken(@NotNull JwtUser user) {
        LocalDateTime now = LocalDateTime.now(clock);
        Instant accessExpirationInstant = now.plusMinutes(expirationMinutes)
                .atZone(ZoneId.systemDefault()).toInstant();
        Date expiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getId().toString())
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public boolean validateToken(@NotNull String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException ignored) {
            return false;
        }
    }

    @Override
    public @NotNull JwtUser parseUser(@NotNull String token) {
        Claims claims = getClaims(token);
        return new JwtUser(
                UUID.fromString(claims.getSubject())
        );
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
