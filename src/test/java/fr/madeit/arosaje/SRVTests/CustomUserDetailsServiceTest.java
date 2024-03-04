package fr.madeit.arosaje.SRVTests;

import fr.madeit.arosaje.BO.Login;
import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DAL.LoginRepository;
import fr.madeit.arosaje.DAL.UserRepository;
import fr.madeit.arosaje.SRV.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    @Mock
    private LoginRepository loginRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Test
    void testLoadUserByUsername_UserExists() {
        String email = "test@example.com";
        String hashedPassword = "$2a$10$123456789012345678901u63Op2IulOM0e5HCCOzWi";
        Login mockLogin = new Login();
        mockLogin.setEmail(email);
        mockLogin.setHashedPassword(hashedPassword);
        mockLogin.setUserId(1);

        when(loginRepository.findByEmail(email)).thenReturn(mockLogin);
        when(userRepository.findById(1)).thenReturn(Optional.of(new User()));

        UserDetails result = customUserDetailsService.loadUserByUsername(email);

        assertNotNull(result);
        assertEquals(email, result.getUsername());
        assertEquals(hashedPassword, result.getPassword());
        assertEquals(1, result.getAuthorities().size());
        assertTrue(result.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    void testLoadUserByUsername_UserDoesNotExist() {
        String email = "test@example.com";

        when(loginRepository.findByEmail(email)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.loadUserByUsername(email));
    }

    @Test
    void testGetUserByEmail_UserExists() {
        String email = "test@example.com";
        Login mockLogin = new Login();
        mockLogin.setEmail(email);
        mockLogin.setUserId(1);

        when(loginRepository.findByEmail(email)).thenReturn(mockLogin);
        when(userRepository.findById(1)).thenReturn(Optional.of(new User()));

        User result = customUserDetailsService.getUserByEmail(email);

        assertNotNull(result);
    }

    @Test
    void testGetUserByEmail_UserDoesNotExist() {
        String email = "test@example.com";

        when(loginRepository.findByEmail(email)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.getUserByEmail(email));
    }

    @Test
    void testGetUserById_UserExists() {
        int userId = 1;

        when(userRepository.findById(userId)).thenReturn(Optional.of(new User()));

        User result = customUserDetailsService.getUserById(userId);

        assertNotNull(result);
    }

    @Test
    void testGetUserById_UserDoesNotExist() {
        int userId = 1;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> customUserDetailsService.getUserById(userId));
    }

    @Test
    void testGetAllUsers() {
        List<User> mockUsers = List.of(new User(), new User());

        when(userRepository.findAll()).thenReturn(mockUsers);

        List<User> result = customUserDetailsService.getAllUsers();

        assertNotNull(result);
        assertEquals(mockUsers.size(), result.size());
    }

    @Test
    void testAddUser() {
        User mockUser = new User();

        customUserDetailsService.addUser(mockUser);

        verify(userRepository).save(mockUser);
    }

    @Test
    void testUpdateUser() {
        User mockUser = new User();

        customUserDetailsService.updateUser(mockUser);

        verify(userRepository).save(mockUser);
    }
}
