package fr.madeit.arosaje.Controller;


import fr.madeit.arosaje.BO.Species;
import fr.madeit.arosaje.SRV.SpeciesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/species")
public class SpeciesController {
    private final SpeciesService speciesService;

    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Species> findAll() {
        return speciesService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Species findById(Integer id) {
        return speciesService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Species findByName(String name) {
        return speciesService.findByName(name);
    }

    @GetMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public Species addSpecies(Species species) {
        return speciesService.addSpecies(species);
    }

    @GetMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteSpecies(Integer id) {
        speciesService.deleteSpecies(id);
    }

    @GetMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public Species updateSpecies(Species species) {
        return speciesService.updateSpecies(species);
    }


}
