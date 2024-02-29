package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.BO.Announce;
import fr.madeit.arosaje.Controller.AnnounceController;
import fr.madeit.arosaje.SRV.AnnounceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AnnounceControllerTest {

    @Mock
    private AnnounceService announceService;

    @InjectMocks
    private AnnounceController announceController;

    @Test
    public void testGetAllAnnounces() throws Exception {
        List<Announce> mockAnnounces = Arrays.asList(new Announce(), new Announce());
        when(announceService.getAllAnnounces()).thenReturn(mockAnnounces);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/announces")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockAnnounces.size()));
    }

    @Test
    public void testGetById() throws Exception {
        Announce mockAnnounce = new Announce();
        mockAnnounce.setId(1);

        when(announceService.getById(1)).thenReturn(mockAnnounce);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/announces/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
    }

    @Test
    public void testGetAllByAnnouncerId() throws Exception {
        List<Announce> mockAnnounces = Arrays.asList(new Announce(), new Announce());

        when(announceService.getAllByAnnouncerId(1)).thenReturn(mockAnnounces);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/announces/findByAnnouncerId/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockAnnounces.size()));

    }

    @Test
    public void testGetAllByPlantId() throws Exception {
        Integer mockPlantId = 2;

        List<Announce> mockAnnounces = Arrays.asList(new Announce(), new Announce());
        when(announceService.getAllByPlantId(mockPlantId)).thenReturn(mockAnnounces);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/announces/findByPlantId/{plantId}", mockPlantId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockAnnounces.size()));
    }

    @Test
    public void testGetAllByTitle() throws Exception {
        String mockTitle = "Test Title";

        List<Announce> mockAnnounces = Arrays.asList(new Announce(), new Announce());
        when(announceService.getAllByTitle(mockTitle)).thenReturn(mockAnnounces);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/announces/findByTitle/{title}", mockTitle)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockAnnounces.size()));
    }

    @Test
    public void testGetAllByStartDate() throws Exception {
        String mockStartDate = "2024-03-01";

        List<Announce> mockAnnounces = Arrays.asList(new Announce(), new Announce());
        when(announceService.getAllByStartDate(mockStartDate)).thenReturn(mockAnnounces);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/announces/findByStartDate/{startDate}", mockStartDate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockAnnounces.size()));
    }

    @Test
    public void testGetAllByEndDate() throws Exception {
        String mockEndDate = "2024-03-31";

        List<Announce> mockAnnounces = Arrays.asList(new Announce(), new Announce());
        when(announceService.getAllByEndDate(mockEndDate)).thenReturn(mockAnnounces);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/announces/findByEndDate/{endDate}", mockEndDate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockAnnounces.size()));
    }

    @Test
    public void testAddAnnounce() throws Exception {
        Announce mockAnnounce = new Announce();
        doReturn(mockAnnounce).when(announceService).addAnnounce(any());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/announces/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        // You may need to adjust assertions based on your actual response structure
        assert responseContent.contains("\"id\":") && responseContent.contains("\"createdAt\":");
    }

    @Test
    public void testDeleteAnnounce() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/announces/delete/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Mockito.verify(announceService, Mockito.times(1)).deleteAnnounce(1);
    }

    @Test
    public void testUpdateAnnounce() throws Exception {
        Announce mockAnnounce = new Announce();
        doReturn(mockAnnounce).when(announceService).updateAnnounce(any());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(announceController).build();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/api/announces/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        // You may need to adjust assertions based on your actual response structure
        assert responseContent.contains("\"id\":") && responseContent.contains("\"createdAt\":");
    }
}