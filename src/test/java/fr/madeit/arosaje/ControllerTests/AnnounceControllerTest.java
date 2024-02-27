package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.Controller.AnnounceController;
import fr.madeit.arosaje.SRV.AnnounceService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = AnnounceController.class)
public class AnnounceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnnounceService announceService;

    @Test
    public void testGetAllAnnounces() throws Exception {
        mockMvc.perform(get("/api/announces"))
                .andExpect(status().isOk());
    }
}
