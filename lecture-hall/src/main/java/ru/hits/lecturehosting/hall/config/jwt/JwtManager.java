package ru.hits.lecturehosting.hall.config.jwt;

import org.jetbrains.annotations.NotNull;

public interface JwtManager {

    /**
     * Метод генерации JWT токена
     * @param user JWT токен в формате объекта {@link JwtUser}
     * @return JWT токен в формате строки
     */
    @NotNull
    String generateToken(@NotNull JwtUser user);

    /**
     * Метод проверки JWT токена
     * @param token JWT токен в формате строки
     * @return true, если JWT токен валидный (и он не истёк)
     */
    boolean validateToken(@NotNull String token);

    /**
     * Метод парсинга JWT токена
     * @param token JWT токен в формате строки
     * @return JWT токен в формате объекта {@link JwtUser}
     */
    @NotNull
    JwtUser parseUser(@NotNull String token);

}
