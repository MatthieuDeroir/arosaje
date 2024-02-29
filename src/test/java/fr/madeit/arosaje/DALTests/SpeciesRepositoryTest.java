package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.SpeciesRepository;
import fr.madeit.arosaje.BO.Species;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SpeciesRepositoryTest {

    @Mock
    private SpeciesRepository speciesRepository;

    @Test
    void testFindByName() {
        when(speciesRepository.findByName(anyString())).thenReturn(List.of(new Species()));

        Iterable<Species> result = speciesRepository.findByName("testSpecies");
        assertNotNull(result);
        verify(speciesRepository).findByName("testSpecies");
    }
}