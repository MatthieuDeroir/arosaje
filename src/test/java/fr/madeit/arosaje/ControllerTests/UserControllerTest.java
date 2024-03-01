/*private String userJson = "{" +
            "id:1," +
            "username:johndoe," +
            "firstname:john," +
            "lastname:doe," +
            "streetNumber:1," +
            "streetName:LA," +
            "zipCode:44300" +
            "city:Nantes," +
            "country:France" +
            "birthdate:13-11-2003," +
            "lastGpsLocation:tr," +
            "lastGpsLocationDate:13-03-2020," +
            "lastLoginDate:13-03-2020," +
            "roleId:1" +
            "createdAt:tr" +
            "updatedAt:tr}";*/
package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.Controller.UserController;
import fr.madeit.arosaje.SRV.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private CustomUserDetailsService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetById() throws Exception {
        Integer mockUserId = 1;
        User mockUser = new User();
        mockUser.setId(mockUserId);
        when(userService.getUserById(mockUserId)).thenReturn(mockUser);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/{id}", mockUserId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(mockUserId));
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> mockUserList = Arrays.asList(new User(), new User());
        when(userService.getAllUsers()).thenReturn(mockUserList);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockUserList.size()));
    }

    @Test
    public void testAddUser() throws Exception {
        User mockUser = new User();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))  // Add your user JSON content here
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User mockUser = new User();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(MockMvcRequestBuilders.put("/api/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))  // Add your user JSON content here
                .andExpect(status().isOk());
    }
}
