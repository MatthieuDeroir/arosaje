package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.BO.Announce;
import fr.madeit.arosaje.SRV.AnnounceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/announces")
public class AnnounceController {
    private final AnnounceService announceService;


    public AnnounceController(AnnounceService announceService) {
        this.announceService = announceService;
    }

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Announce> getAllAnnounces() {
        return announceService.getAllAnnounces();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Announce getById(@PathVariable Integer id) {
        return announceService.getById(id);
    }

    // get by announcer id
    @GetMapping("/findByAnnouncerId/{announcerId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Announce> getAllByAnnouncerId(@PathVariable Integer announcerId) {
        return announceService.getAllByAnnouncerId(announcerId);
    }

    @GetMapping("/findByPlantId/{plantId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Announce> getAllByPlantId(@PathVariable Integer plantId) {
        return announceService.getAllByPlantId(plantId);
    }

    @GetMapping("/findByStartDate/{startDate}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Announce> getAllByStartDate(@PathVariable String startDate) {
        return announceService.getAllByStartDate(startDate);
    }

    @GetMapping("/findByEndDate/{endDate}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Announce> getAllByEndDate(@PathVariable String endDate) {
        return announceService.getAllByEndDate(endDate);
    }

    @GetMapping("/findByTitle/{title}")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Announce> getAllByTitle(@PathVariable String title) {
        return announceService.getAllByTitle(title);
    }



    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public Announce addAnnounce(@RequestBody Announce announce) {
        return announceService.addAnnounce(announce);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteAnnounce(@PathVariable Integer id) {
        announceService.deleteAnnounce(id);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public Announce updateAnnounce(@RequestBody Announce announce) {
        return announceService.updateAnnounce(announce);
    }



}

