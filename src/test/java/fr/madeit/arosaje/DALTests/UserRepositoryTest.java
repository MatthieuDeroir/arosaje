package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.UserRepository;
import fr.madeit.arosaje.BO.User;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void testFindByUsername() {
        when(userRepository.findByUsername(anyString())).thenReturn(List.of(new User()));

        Iterable<User> result = userRepository.findByUsername("johndoe");
        assertNotNull(result);
        verify(userRepository).findByUsername("johndoe");
    }





}
