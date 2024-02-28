package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.BO.Plant;
import fr.madeit.arosaje.Controller.PlantController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import fr.madeit.arosaje.SRV.PlantService;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class PlantControllerTest {

    @Mock
    private PlantService plantService;

    @InjectMocks
    private PlantController plantController;

    @Test
    public void testGetAllPlants() throws Exception {
        List<Plant> mockPlants = Arrays.asList(new Plant(), new Plant());
        when(plantService.getAllPlants()).thenReturn(mockPlants);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plant")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockPlants.size()));
    }

    @Test
    public void testGetById() throws Exception {
        Integer mockPlantId = 1;
        Plant mockPlant = new Plant();
        mockPlant.setId(mockPlantId);
        when(plantService.getById(mockPlantId)).thenReturn((mockPlant));

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plant/{id}", mockPlantId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(mockPlantId));
    }

    @Test
    public void testGetAllByOwnerId() throws Exception {
        Integer mockOwnerId = 1;
        List<Plant> mockPlants = Arrays.asList(new Plant(), new Plant());
        when(plantService.getAllByOwnerId(mockOwnerId)).thenReturn(mockPlants);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plant/findByOwnerId/{ownerId}", mockOwnerId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockPlants.size()));
    }

    @Test
    public void testAddPlant() throws Exception {
        Plant mockPlant = new Plant();
        when(plantService.addPlant(mockPlant)).thenReturn(mockPlant);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plant/add")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()); // Adjust the assertion according to your response
    }

    @Test
    public void testDeletePlant() throws Exception {
        Integer mockPlantId = 1;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plant/delete/{id}", mockPlantId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdatePlant() throws Exception {
        Plant mockPlant = new Plant();
        when(plantService.updatePlant(mockPlant)).thenReturn(mockPlant);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/plant/update")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()); // Adjust the assertion according to your response
    }
}
