//package fr.madeit.arosaje.Controller;
//
//
//import fr.madeit.arosaje.BO.Plant;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import fr.madeit.arosaje.DAL.PlantRepository;
//
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/plant")
//public class PlantController {
//
//    private final PlantRepository plantRepository;
//
//    public PlantController(PlantRepository plantRepository) {
//        this.plantRepository = plantRepository;
//    }
//
//    @GetMapping("")
//    public List<Plant> getAllPlants() {
//        return plantRepository.findAll();
//    }
//
//    @GetMapping("/add")
//    public List<Plant> addPlant(@RequestBody Plant plant) {
//       return plantRepository.save(plant);
//    }
//
//    @GetMapping("/delete")
//    public ResponseEntity<String> deletePlant(@RequestBody Plant plant) {
//        return null;
//    }
//
//    @GetMapping("/update")
//    public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) {
//        return null;
//    }
//}
