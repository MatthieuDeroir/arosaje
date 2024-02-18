package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.Enum.EntityType;
import fr.madeit.arosaje.SRV.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import fr.madeit.arosaje.DTO.FileDto;

@RestController
@RequestMapping("/api/media")
public class FileUploadController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload/plant")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadPlantFile(@RequestParam("file") MultipartFile file, @RequestBody FileDto fileDtO) {
        fileDtO.setEntityType(EntityType.PLANT);
        return uploadFileWithEntityType(file, fileDtO);
    }

    @PostMapping("/upload/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadUserFile(@RequestParam("file") MultipartFile file, @RequestBody FileDto fileDtO) {
        fileDtO.setEntityType(EntityType.USER);
        return uploadFileWithEntityType(file, fileDtO);
    }

    @PostMapping("/upload/announcement")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadAnnouncementFile(@RequestParam("file") MultipartFile file, @RequestBody FileDto fileDtO) {
        fileDtO.setEntityType(EntityType.ANNOUNCE);
        return uploadFileWithEntityType(file, fileDtO);
    }

    @PostMapping("/upload/message")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadMessageFile(@RequestParam("file") MultipartFile file, @RequestBody FileDto fileDtO) {
        fileDtO.setEntityType(EntityType.MESSAGE);
        return uploadFileWithEntityType(file, fileDtO);
    }

    @PostMapping("/upload/upkeep")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> uploadUpkeepFile(@RequestParam("file") MultipartFile file, @RequestBody FileDto fileDtO) {
        fileDtO.setEntityType(EntityType.UPKEEP);
        return uploadFileWithEntityType(file, fileDtO);
    }

    private ResponseEntity<String> uploadFileWithEntityType(MultipartFile file, FileDto fileDtO) {
        String fileName = fileStorageService.storeFile(file, fileDtO);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(fileName)
                .toUriString();

        return ResponseEntity.ok(fileDownloadUri);
    }
}
