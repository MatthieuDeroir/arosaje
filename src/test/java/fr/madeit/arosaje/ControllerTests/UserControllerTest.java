package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.Config.JwtRequestFilter;
import fr.madeit.arosaje.Controller.UserController;
import fr.madeit.arosaje.SRV.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private CustomUserDetailsService userService;

    @MockBean
     private JwtRequestFilter jwtRequestFilter;

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
    @BeforeEach
    public void init() {
            userService.addUser(new User());
    }

    /*@Test
    @WithMockUser(value = "say", roles = {"ADMIN"})
    public void testAddUser() throws Exception {
        mockMvc.perform(post("http://localhost:8080/api/user/")
                        .content(userJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/

    @Test
    @WithMockUser(value = "say")
    public void testGetById() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/user/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(value = "say")
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/user"))
                .andExpect(status().isOk());
    }
}