package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DTO.AuthenticationResponseDto;
import fr.madeit.arosaje.DTO.SignUpDto;
import fr.madeit.arosaje.SRV.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import fr.madeit.arosaje.Utils.JwtUtil;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDto signUpDto) {
        authService.registerUser(signUpDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/api/auth/signin")
    public ResponseEntity<?> signIn(@RequestBody SignUpDto signUpDto) {
        if (authService.logUser(signUpDto.getEmail(), signUpDto.getPassword()) == null) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
        final String jwt = this.jwtUtil.generateToken(signUpDto.getUsername());

        return ResponseEntity.ok(new AuthenticationResponseDto(jwt, "User signed in successfully")); // Make sure to return the token here
    }

}
