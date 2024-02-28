package fr.madeit.arosaje.ControllerTests;

import fr.madeit.arosaje.BO.Species;
import fr.madeit.arosaje.Controller.SpeciesController;
import fr.madeit.arosaje.SRV.SpeciesService;
import org.junit.Test;
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
public class SpeciesControllerTest {

    @Mock
    private SpeciesService speciesService;

    @InjectMocks
    private SpeciesController speciesController;

    @Test
    public void testFindAll() throws Exception {
        List<Species> mockSpeciesList = Arrays.asList(new Species(), new Species());
        when(speciesService.findAll()).thenReturn(mockSpeciesList);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(speciesController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/species")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockSpeciesList.size()));
    }

    @Test
    public void testFindById() throws Exception {
        Integer mockSpeciesId = 1;
        Species mockSpecies = new Species();
        mockSpecies.setId(mockSpeciesId);
        when(speciesService.findById(mockSpeciesId)).thenReturn((mockSpecies));

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(speciesController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/species/{id}", mockSpeciesId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(mockSpeciesId));
    }

    @Test
    public void testFindByName() throws Exception {
        String mockSpeciesName = "TestSpecies";
        Species mockSpecies = new Species();
        mockSpecies.setName(mockSpeciesName);
        when(speciesService.findByName(mockSpeciesName)).thenReturn((mockSpecies));

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(speciesController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/species/findByName/{name}", mockSpeciesName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(mockSpeciesName));
    }

    @Test
    public void testAddSpecies() throws Exception {
        Species mockSpecies = new Species();
        when(speciesService.addSpecies(mockSpecies)).thenReturn(mockSpecies);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(speciesController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/species/add")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void testDeleteSpecies() throws Exception {
        Integer mockSpeciesId = 1;

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(speciesController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/species/delete/{id}", mockSpeciesId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateSpecies() throws Exception {
        Species mockSpecies = new Species();
        when(speciesService.updateSpecies(mockSpecies)).thenReturn(mockSpecies);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(speciesController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/species/update")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()); // Adjust the assertion according to your response
    }
}