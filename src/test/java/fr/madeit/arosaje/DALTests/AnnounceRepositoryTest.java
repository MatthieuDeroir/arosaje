package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.AnnounceRepository;
import fr.madeit.arosaje.BO.Announce;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AnnounceRepositoryTest {

    @Mock
    private AnnounceRepository announceRepository;

    @Test
    void testFindByAnnouncerId() {
        when(announceRepository.findByAnnouncerId(anyInt())).thenReturn(List.of(new Announce()));

        Iterable<Announce> result = announceRepository.findByAnnouncerId(1);
        assertNotNull(result);
        verify(announceRepository).findByAnnouncerId(1);
    }

    @Test
    void testFindByPlantId() {
        when(announceRepository.findByPlantId(anyInt())).thenReturn(List.of(new Announce()));

        Iterable<Announce> result = announceRepository.findByPlantId(1);
        assertNotNull(result);
        verify(announceRepository).findByPlantId(1);
    }

    @Test
    void testFindByTitle() {
        when(announceRepository.findByTitle(anyString())).thenReturn(List.of(new Announce()));

        Iterable<Announce> result = announceRepository.findByTitle("title");
        assertNotNull(result);
        verify(announceRepository).findByTitle("title");
    }

    @Test
    void testFindByStartDate() {
        when(announceRepository.findByStartDate(anyString())).thenReturn(List.of(new Announce()));

        Iterable<Announce> result = announceRepository.findByStartDate("startDate");
        assertNotNull(result);
        verify(announceRepository).findByStartDate("startDate");
    }

    @Test
    void testFindByEndDate() {
        when(announceRepository.findByEndDate(anyString())).thenReturn(List.of(new Announce()));

        Iterable<Announce> result = announceRepository.findByEndDate("endDate");
        assertNotNull(result);
        verify(announceRepository).findByEndDate("endDate");
    }

    @Test
    void testFindAll() {
        when(announceRepository.findAll()).thenReturn(List.of(new Announce()));

        Iterable<Announce> result = announceRepository.findAll();
        assertNotNull(result);
        verify(announceRepository).findAll();
    }

    @Test
    void testFindById() {
        when(announceRepository.findById(anyInt())).thenReturn(java.util.Optional.of(new Announce()));

        java.util.Optional<Announce> result = announceRepository.findById(1);
        assertNotNull(result);
        verify(announceRepository).findById(1);
    }

    @Test
    void testSave() {
        Announce announce = new Announce();
        when(announceRepository.save(any(Announce.class))).thenReturn(announce);

        Announce result = announceRepository.save(new Announce());
        assertNotNull(result);
        verify(announceRepository).save(any(Announce.class));
    }

    @Test
    void testUpdate() {
        Announce announce = new Announce();
        when(announceRepository.save(any(Announce.class))).thenReturn(announce);

        Announce result = announceRepository.save(new Announce());
        assertNotNull(result);
        verify(announceRepository).save(any(Announce.class));
    }

    @Test
    void testDelete() {
        doNothing().when(announceRepository).deleteById(anyInt());

        announceRepository.deleteById(1);
        verify(announceRepository).deleteById(1);
    }

    @Test
    void testDeleteAll() {
        doNothing().when(announceRepository).deleteAll();

        announceRepository.deleteAll();
        verify(announceRepository).deleteAll();
    }

    @Test
    void testCount() {
        when(announceRepository.count()).thenReturn(1L);

        long result = announceRepository.count();
        assertEquals(1L, result);
        verify(announceRepository).count();
    }
}
