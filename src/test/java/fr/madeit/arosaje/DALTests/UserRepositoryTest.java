package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.DAL.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    void testFindAllByUsernameOrFirstNameOrLastName() {
        User user1 = new User("testUser1", "John", "Doe");
        User user2 = new User("anotherUser", "Jane", "Test");
        when(userRepository.findAllByUsernameOrFirstNameOrLastName(any(), any(), any()))
                .thenReturn(Arrays.asList(user1, user2));

        List<User> result = userRepository.findAllByUsernameOrFirstNameOrLastName("test", "test", "test");

        assertEquals(2, result.size());
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
    }

    @Test
    void testFindByUsername() {
        when(userRepository.findByUsername(anyString())).thenReturn(List.of(new User()));

        Iterable<User> result = userRepository.findByUsername("johndoe");

        assertNotNull(result);
        verify(userRepository).findByUsername("johndoe");
    }

    @Test
    void testFindByFirstName() {
        User user = new User("testUser", "John", "Doe");
        when(userRepository.findByFirstName(anyString())).thenReturn(Arrays.asList(user));

        List<User> result = (List<User>) userRepository.findByFirstName("John");

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(user, result.get(0));
    }

    @Test
    void testFindByLastName() {
        User user = new User("testUser", "John", "Doe");
        when(userRepository.findByLastName(anyString())).thenReturn(Arrays.asList(user));

        List<User> result = (List<User>) userRepository.findByLastName("Doe");

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(user, result.get(0));
    }

    @Test
    void testFindByStreetName() {
        User user1 = new User("testUser1", "John", "Doe");
        User user2 = new User("anotherUser", "Jane", "Test");
        when(userRepository.findByStreetName(any())).thenReturn(Arrays.asList(user1, user2));

        List<User> result = (List<User>) userRepository.findByStreetName("Main Street");

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }

    @Test
    void testFindByZipCode() {
        User user1 = new User("testUser1", "John", "Doe");
        User user2 = new User("anotherUser", "Jane", "Test");
        when(userRepository.findByZipCode(any())).thenReturn(Arrays.asList(user1, user2));

        List<User> result = (List<User>) userRepository.findByZipCode("12345");

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }

    @Test
    void testFindByCity() {
        User user1 = new User("testUser1", "John", "Doe");
        User user2 = new User("anotherUser", "Jane", "Test");
        when(userRepository.findByCity(any())).thenReturn(Arrays.asList(user1, user2));

        List<User> result = (List<User>) userRepository.findByCity("Springfield");

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }

    @Test
    void testFindByCountry() {
        User user1 = new User("testUser1", "John", "Doe");
        User user2 = new User("anotherUser", "Jane", "Test");
        when(userRepository.findByCountry(any())).thenReturn(Arrays.asList(user1, user2));

        List<User> result = (List<User>) userRepository.findByCountry("USA");

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }


    @Test
    void testFindByRoleId() {
        User user1 = new User("testUser1", "John", "Doe");
        User user2 = new User("anotherUser", "Jane", "Test");
        when(userRepository.findByRoleId(any())).thenReturn(Arrays.asList(user1, user2));

        List<User> result = (List<User>) userRepository.findByRoleId(1);

        assertNotNull(result);
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
    }
}