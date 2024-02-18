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


    public AnnounceService(AnnounceRepository announceRepository) {
        this.announceRepository = announceRepository;
    }

    public List<Announce> getAllAnnounces() {
        return announceRepository.findAll();
    }

    public List<Announce> getAllByIdentifier(String identifier) {
        return announceRepository.findAllByTitleIgnoreCaseOrBodyContainingIgnoreCase(identifier, identifier);
    }

    public Iterable<Announce> getAllByAnnouncerId(Integer announcerId) {
        return announceRepository.findByAnnouncerId(announcerId);
    }

    public Announce addAnnounce(Announce announce) {
        return announceRepository.save(announce);
    }

    public void deleteAnnounce(Integer id) {
        announceRepository.deleteById(id);
    }

    public Announce updateAnnounce(Announce announce) {
        return announceRepository.save(announce);
    }

    public Announce getById(Integer id) {
        return announceRepository.findById(id).orElse(null);
    }
}
