package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.UpkeepRepository;
import fr.madeit.arosaje.BO.Upkeep;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpkeepRepositoryTest {

    @Mock
    private UpkeepRepository upkeepRepository;

    @Test
    void testFindByPlantId() {
        when(upkeepRepository.findByPlantId(anyInt())).thenReturn(List.of(new Upkeep()));

        Iterable<Upkeep> result = upkeepRepository.findByPlantId(1);
        assertNotNull(result);
        verify(upkeepRepository).findByPlantId(1);
    }

    @Test
    void testFindByStatus() {
        when(upkeepRepository.findByStatus(anyString())).thenReturn(List.of(new Upkeep()));

        Iterable<Upkeep> result = upkeepRepository.findByStatus("inProgress");
        assertNotNull(result);
        verify(upkeepRepository).findByStatus("inProgress");
    }

    @Test
    void testFindByCaretakerId() {
        when(upkeepRepository.findByCaretakerId(anyInt())).thenReturn(List.of(new Upkeep()));

        Iterable<Upkeep> result = upkeepRepository.findByCaretakerId(1);
        assertNotNull(result);
        verify(upkeepRepository).findByCaretakerId(1);
    }}