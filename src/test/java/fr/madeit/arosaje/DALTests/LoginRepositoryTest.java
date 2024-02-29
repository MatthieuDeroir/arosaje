package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.LoginRepository;
import fr.madeit.arosaje.BO.Login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginRepositoryTest {

    @Mock
    private LoginRepository loginRepository;

    @Test
    void testFindByEmail() {
        when(loginRepository.findByEmail(anyString())).thenReturn(new Login());

        Login result = loginRepository.findByEmail("test@example.com");
        assertNotNull(result);
        verify(loginRepository).findByEmail("test@example.com");
    }
}
