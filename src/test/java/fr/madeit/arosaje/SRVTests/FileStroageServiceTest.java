package fr.madeit.arosaje.SRVTests;

import fr.madeit.arosaje.BO.Media;
import fr.madeit.arosaje.DAL.MediaRepository;
import fr.madeit.arosaje.DTO.FileDto;
import fr.madeit.arosaje.Enum.EntityType;
import fr.madeit.arosaje.SRV.FileStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileStorageServiceTest {

    @Mock
    private MediaRepository mediaRepository;

    @InjectMocks
    private FileStorageService fileStorageService;

    @Test
    void testInit() {
        assertDoesNotThrow(() -> fileStorageService.init());
    }

    @Test
    void testStoreFile_Success() throws IOException {
        MultipartFile mockMultipartFile = new MockMultipartFile("file", "test.txt", "text/plain", "Hello, World!".getBytes());
        FileDto fileDto = new FileDto();
        fileDto.setEntityType(any(EntityType.class));
        fileDto.setEntityId(1);
        fileDto.setUserId(1);

        String result = fileStorageService.storeFile(mockMultipartFile, fileDto);

        assertNotNull(result);
        assertTrue(StringUtils.hasText(result));
        verify(mediaRepository, times(1)).save(any(Media.class));
    }

    @Test
    void testStoreFile_Failure() throws IOException {
        MultipartFile mockMultipartFile = new MockMultipartFile("file", "test.txt", "text/plain", "Hello, World!".getBytes());
        FileDto fileDto = new FileDto();
        fileDto.setEntityType(any(EntityType.class));
        fileDto.setEntityId(1);
        fileDto.setUserId(1);

        when(mediaRepository.save(Mockito.any())).thenThrow(RuntimeException.class);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> fileStorageService.storeFile(mockMultipartFile, fileDto));

        assertTrue(exception.getMessage().contains("Could not store file"));
        verify(mediaRepository, times(1)).save(any(Media.class));
    }
}
