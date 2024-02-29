package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.Controller.AuthController;
import fr.madeit.arosaje.DTO.SignUpDto;
import fr.madeit.arosaje.SRV.AuthService;
import fr.madeit.arosaje.Utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private AuthController authController;

    @Test
    public void testSignUp() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"testuser\",\"email\":\"test@example.com\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("User registered successfully"));

        // You may need to adjust the content and assertions based on your actual requirements
    }

    @Test
    public void testSignIn() throws Exception {
        SignUpDto signUpDto = new SignUpDto("test@example.com", "password123", "testuser");
        User mockUser = new User();
        String mockJwtToken = "your_mocked_jwt_token";

        doReturn(mockUser).when(authService).logUser(signUpDto.getEmail(), signUpDto.getPassword());
        when(jwtUtil.generateToken(Mockito.any())).thenReturn("your_mocked_jwt_token");

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController).build();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@example.com\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        assert responseContent.contains(mockJwtToken) && responseContent.contains("User signed in successfully");
    }
}

