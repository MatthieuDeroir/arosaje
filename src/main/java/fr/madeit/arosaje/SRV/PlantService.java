package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Plant;
import fr.madeit.arosaje.DAL.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlantService {

    @Autowired
    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    public Plant getById(Integer id) {
        return plantRepository.getById(id);
    }

    public Iterable<Plant> getAllByOwnerId(Integer ownerId) {
        return plantRepository.findByOwnerId(ownerId);
    }

    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deletePlant(Integer id) {
        plantRepository.deleteById(id);
    }

    public Plant updatePlant(Plant plant) {
        return plantRepository.save(plant);
    }
}
