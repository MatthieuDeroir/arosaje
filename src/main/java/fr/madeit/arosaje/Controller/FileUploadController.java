package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.SRV.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/media")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload/plant")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadPlantFile(@RequestParam("file") MultipartFile file, @RequestParam("plantId") Integer plantId) {
        return uploadFileWithEntityType(file, "plant");
    }

    @PostMapping("/upload/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadUserFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") Integer userId) {
        return uploadFileWithEntityType(file, "user");
    }

    @PostMapping("/upload/announcement")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadAnnouncementFile(@RequestParam("file") MultipartFile file, @RequestParam("announcementId") Integer announcementId) {
        return uploadFileWithEntityType(file, "announcement");
    }

    @PostMapping("/upload/message")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadMessageFile(@RequestParam("file") MultipartFile file, @RequestParam("messageId") Integer messageId) {
        return uploadFileWithEntityType(file, "message");
    }

    private ResponseEntity<String> uploadFileWithEntityType(MultipartFile file, String entityType) {
        String fileName = fileStorageService.storeFile(file, entityType);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileName)
                .toUriString();

        return ResponseEntity.ok(fileDownloadUri);
    }
}
