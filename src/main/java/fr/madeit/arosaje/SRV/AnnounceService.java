package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Announce;
import fr.madeit.arosaje.DAL.AnnounceRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter

@Service
public class AnnounceService {
    private final AnnounceRepository announceRepository;


    public AnnounceService(AnnounceRepository announceRepository) {this.announceRepository = announceRepository;}

    public List<Announce> getAllAnnounces() {
        return announceRepository.findAll();
    }

    public List<Announce> getAllByIdentifier(String identifier) {
        return announceRepository.findAllByTitleIgnoreCaseOrBodyContainingIgnoreCase(identifier, identifier);
    }
}
