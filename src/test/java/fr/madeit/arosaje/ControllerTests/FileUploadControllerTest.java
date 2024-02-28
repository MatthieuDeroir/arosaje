package fr.madeit.arosaje.ControllerTests;

/*
import fr.madeit.arosaje.Controller.FileUploadController;
import fr.madeit.arosaje.SRV.FileStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class FileUploadControllerTest {

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private FileUploadController fileUploadController;

    @Test
    public void testUploadPlantFile() throws Exception {
        testUploadFile("/api/medias/upload/plant");
    }

    @Test
    public void testUploadUserFile() throws Exception {
        testUploadFile("/api/medias/upload/user");
    }

    @Test
    public void testUploadAnnouncementFile() throws Exception {
        testUploadFile("/api/medias/upload/announcement");
    }

    @Test
    public void testUploadMessageFile() throws Exception {
        testUploadFile("/api/medias/upload/message");
    }

    @Test
    public void testUploadUpkeepFile() throws Exception {
        testUploadFile("/api/medias/upload/upkeep");
    }

    private void testUploadFile(String endpoint) throws Exception {
        Integer entityId = 1;
        Integer userId = 1;

        MockMultipartFile file = new MockMultipartFile("file", "test.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());

        when(fileStorageService.storeFile(any(), any())).thenReturn("test.txt");

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(fileUploadController).build();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart(endpoint)
                        .file(file)
                        .param("entityId", entityId.toString())
                        .param("userId", userId.toString())
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andReturn();

        String fileDownloadUri = Objects.requireNonNull(result.getResponse().getContentAsString());

        String expectedUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path("test.txt")
                .toUriString();

        assert fileDownloadUri.equals(expectedUri);
    }
}
*/
