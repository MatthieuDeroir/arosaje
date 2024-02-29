package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.PlantRepository;
import fr.madeit.arosaje.BO.Plant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlantRepositoryTest {

    @Mock
    private PlantRepository plantRepository;

    @Test
    void testGetById() {
        when(plantRepository.getById(anyInt())).thenReturn(new Plant());

        Plant result = plantRepository.getById(1);
        assertNotNull(result);
        verify(plantRepository).getById(1);
    }

    @Test
    void testFindByOwnerId() {
        when(plantRepository.findByOwnerId(anyInt())).thenReturn(List.of(new Plant()));

        Iterable<Plant> result = plantRepository.findByOwnerId(1);
        assertNotNull(result);
        verify(plantRepository).findByOwnerId(1);
    }

    @Test
    void testFindBySpeciesId() {
        when(plantRepository.findBySpeciesId(anyInt())).thenReturn(List.of(new Plant()));

        Iterable<Plant> result = plantRepository.findBySpeciesId(1);
        assertNotNull(result);
        verify(plantRepository).findBySpeciesId(1);
    }

    @Test
    void testFindByCurrentState() {
        when(plantRepository.findByCurrentState(anyString())).thenReturn(List.of(new Plant()));

        Iterable<Plant> result = plantRepository.findByCurrentState("state");
        assertNotNull(result);
        verify(plantRepository).findByCurrentState("state");
    }
}