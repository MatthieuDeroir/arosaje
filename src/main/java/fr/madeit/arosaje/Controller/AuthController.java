package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DTO.AuthenticationResponseDto;
import fr.madeit.arosaje.DTO.SignUpDto;
import fr.madeit.arosaje.SRV.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fr.madeit.arosaje.Utils.JwtUtil;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> signUp(@RequestBody SignUpDto signUpDto) {
        authService.registerUser(signUpDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/signin")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> signIn(@RequestBody SignUpDto signUpDto) {
        final User user = authService.logUser(signUpDto.getEmail(), signUpDto.getPassword());
        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
        final String jwt = this.jwtUtil.generateToken(signUpDto.getUsername());

        return ResponseEntity.ok(new AuthenticationResponseDto(jwt, "User signed in successfully", user)); // Make sure to return the token here
    }

}
