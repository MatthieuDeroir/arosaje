package fr.madeit.arosaje.controller;

import fr.madeit.arosaje.BO.Announce;
import fr.madeit.arosaje.SRV.AnnounceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AnnounceController {
    private final AnnounceService announceService;

    public AnnounceController(AnnounceService announceService) {this.announceService = announceService;}

    @GetMapping("/announces")
    public List<Announce> getAllAnnounces() {
        return announceService.getAllAnnounces();
    }
}

