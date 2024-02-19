package fr.madeit.arosaje.Controller;


import fr.madeit.arosaje.BO.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.madeit.arosaje.SRV.PlantService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/plant")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Plant getById(Integer id) {
        return plantService.getById(id);
    }

    @GetMapping("/findByOwnerId/{ownerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Plant> getAllByOwnerId(Integer ownerId) {
        return plantService.getAllByOwnerId(ownerId);
    }

    @GetMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public Plant addPlant(Plant plant) {
        return plantService.addPlant(plant);
    }

    @GetMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deletePlant(Integer id) {
        plantService.deletePlant(id);
    }

    @GetMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public Plant updatePlant(Plant plant) {
        return plantService.updatePlant(plant);
    }

}
