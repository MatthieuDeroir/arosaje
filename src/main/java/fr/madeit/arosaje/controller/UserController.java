package fr.madeit.arosaje.controller;

import fr.madeit.arosaje.BO.Announce;
import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.SRV.AnnounceService;
import fr.madeit.arosaje.SRV.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}


    @GetMapping("/{userIdentifier}")
    public List<User> getAllByIdentifier(@PathVariable String userIdentifier) {
        return userService.getAllByIdentifier(userIdentifier);
    }
}

