package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.SRV.CustomUserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final CustomUserDetailsService userService;

    public UserController(CustomUserDetailsService userService) {this.userService = userService;}


    @GetMapping("/{userIdentifier}")
    @CrossOrigin(origins = "http://localhost:3000")
    public User getById(@PathVariable Integer userIdentifier) {
        return userService.getUserById(userIdentifier);
    }
}

