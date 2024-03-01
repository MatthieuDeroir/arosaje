package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Species;
import fr.madeit.arosaje.DAL.SpeciesRepository;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService {
    private final SpeciesRepository speciesRepository;

    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Iterable<Species> findAll() {
        return speciesRepository.findAll();
    }

    public Species findById(Integer id) {
        return speciesRepository.findById(id).orElse(null);
    }

    public Species findByName(String name) {
        return (Species) speciesRepository.findByName(name);
    }

    public Species addSpecies(Species species) {
        return speciesRepository.save(species);
    }

    public void deleteSpecies(Integer id) {
        speciesRepository.deleteById(id);
    }

    public Species updateSpecies(Species species) {
        return speciesRepository.save(species);
    }

}
