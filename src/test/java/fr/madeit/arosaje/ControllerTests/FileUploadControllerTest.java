//package fr.madeit.arosaje.ControllerTests;
//
//import fr.madeit.arosaje.Controller.FileUploadController;
//import fr.madeit.arosaje.SRV.FileStorageService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.util.Objects;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith({MockitoExtension.class, SpringExtension.class})
//@AutoConfigureMockMvc
//@SpringBootTest
//public class FileUploadControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @Mock
//    private FileStorageService fileStorageService;
//
//    @InjectMocks
//    private FileUploadController fileUploadController;
//
//    @Test
//    public void testUploadPlantFile() throws Exception {
//        testUploadFile("/api/medias/upload/plant");
//    }
//
//    @Test
//    public void testUploadUserFile() throws Exception {
//        testUploadFile("/api/medias/upload/user");
//    }
//
//    @Test
//    public void testUploadAnnouncementFile() throws Exception {
//        testUploadFile("/api/medias/upload/announcement");
//    }
//
//    @Test
//    public void testUploadMessageFile() throws Exception {
//        testUploadFile("/api/medias/upload/message");
//    }
//
//    @Test
//    public void testUploadUpkeepFile() throws Exception {
//        testUploadFile("/api/medias/upload/upkeep");
//    }
//
//    private void testUploadFile(String endpoint) throws Exception {
//        int entityId = 1;
//        int userId = 1;
//
//        MockMultipartFile file = new MockMultipartFile("file", "test.txt", MediaType.TEXT_PLAIN_VALUE, "Hello, World!".getBytes());
//
//        when(fileStorageService.storeFile(any(), any())).thenReturn("test.txt");
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.multipart(endpoint)
//                        .file(file)
//                        .param("entityId", Integer.toString(entityId))
//                        .param("userId", Integer.toString(userId))
//                        .contentType(MediaType.MULTIPART_FORM_DATA))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        String fileDownloadUri = Objects.requireNonNull(result.getResponse().getContentAsString());
//
//        String expectedUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/download/")
//                .path("test.txt")
//                .toUriString();
//
//        assert fileDownloadUri.equals(expectedUri);
//    }
//}
//
