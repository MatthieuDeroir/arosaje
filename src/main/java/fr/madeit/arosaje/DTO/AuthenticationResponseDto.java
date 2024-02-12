package fr.madeit.arosaje.DTO;

public class AuthenticationResponseDto {
    private final String jwtToken;
    private final String message;

    public AuthenticationResponseDto(String jwtToken, String message) {
        this.jwtToken = jwtToken;
        this.message = message;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getMessage() {
        return message;
    }
}
