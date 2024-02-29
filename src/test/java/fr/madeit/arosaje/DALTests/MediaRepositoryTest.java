package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.MediaRepository;
import fr.madeit.arosaje.BO.Media;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MediaRepositoryTest {

    @Mock
    private MediaRepository mediaRepository;

    @Test
    void testFindByUserId() {
        when(mediaRepository.findByUserId(anyInt())).thenReturn(List.of(new Media()));

        Iterable<Media> result = mediaRepository.findByUserId(1);
        assertNotNull(result);
        verify(mediaRepository).findByUserId(1);
    }

    @Test
    void testFindByEntityTypeAndEntityId() {
        when(mediaRepository.findByEntityTypeAndEntityId(anyString(), anyInt())).thenReturn(List.of(new Media()));

        Iterable<Media> result = mediaRepository.findByEntityTypeAndEntityId("type", 1);
        assertNotNull(result);
        verify(mediaRepository).findByEntityTypeAndEntityId("type", 1);
    }
}