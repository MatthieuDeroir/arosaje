package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Media;
import fr.madeit.arosaje.DAL.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private Path fileStorageLocation;

    @Autowired
    private MediaRepository mediaRepository;

    @PostConstruct
    public void init() {
        this.fileStorageLocation = Paths.get(uploadDir).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }

    public String storeFile(MultipartFile file, String entityType) {
        // Generate a unique filename to avoid conflicts
        String fileName = StringUtils.cleanPath(UUID.randomUUID().toString() + "-" + file.getOriginalFilename());

        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);


            //TODO: fill the remaining fields of the media object
            // get the user id from the security context
            Media media = new Media();
            media.setFileName(fileName);
            media.setType(file.getContentType());
            media.setSize((int) file.getSize());
            media.setEntityType(entityType);


            mediaRepository.save(media);

            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
}

