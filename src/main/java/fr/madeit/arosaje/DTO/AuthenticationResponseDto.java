package fr.madeit.arosaje.DTO;

import fr.madeit.arosaje.BO.User;

public class AuthenticationResponseDto {
    private final String jwtToken;
    private final String message;

    private final User user;

    public AuthenticationResponseDto(String jwtToken, String message, User user) {
        this.jwtToken = jwtToken;
        this.message = message;
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
