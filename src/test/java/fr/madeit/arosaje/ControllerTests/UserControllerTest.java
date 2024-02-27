package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.Config.JwtRequestFilter;
import fr.madeit.arosaje.Controller.UserController;
import fr.madeit.arosaje.SRV.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/user"))
                .andExpect(status().isOk());
    }
}