package fr.madeit.arosaje.SRVTests;

import fr.madeit.arosaje.BO.Login;
import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DAL.LoginRepository;
import fr.madeit.arosaje.DAL.UserRepository;
import fr.madeit.arosaje.DTO.SignUpDto;
import fr.madeit.arosaje.SRV.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private LoginRepository loginRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @Test
    void testRegisterUser() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setFirstName("John");
        signUpDto.setLastName("Doe");
        signUpDto.setUsername("johndoe");
        signUpDto.setCountry("USA");
        signUpDto.setCity("New York");
        signUpDto.setZipCode("10001");
        signUpDto.setStreetName("Broadway");
        signUpDto.setStreetNumber("123");
        signUpDto.setEmail("johndoe@example.com");
        signUpDto.setPassword("password");

        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setFirstName("John");
        mockUser.setLastName("Doe");
        mockUser.setUsername("johndoe");
        mockUser.setCountry("USA");
        mockUser.setCity("New York");
        mockUser.setZipCode("10001");
        mockUser.setStreetName("Broadway");
        mockUser.setStreetNumber("123");

        when(userRepository.save(any(User.class))).thenReturn(mockUser);
        when(passwordEncoder.encode("password")).thenReturn("hashedPassword");

        authService.registerUser(signUpDto);

        verify(userRepository).save(any(User.class));
        verify(passwordEncoder).encode("password");
        verify(loginRepository).save(any(Login.class));
    }

    @Test
    void testLogUser_SuccessfulLogin() {
        String email = "johndoe@example.com";
        String password = "password";

        Login mockLogin = new Login();
        mockLogin.setEmail(email);
        mockLogin.setHashedPassword("hashedPassword");
        mockLogin.setUserId(1);

        User mockUser = new User();
        mockUser.setId(1);

        when(loginRepository.findByEmail(email)).thenReturn(mockLogin);
        when(passwordEncoder.matches(password, "hashedPassword")).thenReturn(true);
        when(userRepository.findById(1)).thenReturn(java.util.Optional.of(mockUser));

        User result = authService.logUser(email, password);

        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    void testLogUser_UserNotFound() {
        String email = "nonexistent@example.com";
        String password = "password";

        when(loginRepository.findByEmail(email)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> authService.logUser(email, password));
    }

    @Test
    void testLogUser_IncorrectPassword() {
        String email = "johndoe@example.com";
        String password = "incorrectPassword";

        Login mockLogin = new Login();
        mockLogin.setEmail(email);
        mockLogin.setHashedPassword("hashedPassword");

        when(loginRepository.findByEmail(email)).thenReturn(mockLogin);
        when(passwordEncoder.matches(password, "hashedPassword")).thenReturn(false);

        assertThrows(BadCredentialsException.class, () -> authService.logUser(email, password));
    }
}