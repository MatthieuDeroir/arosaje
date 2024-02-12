package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.BO.User;
import fr.madeit.arosaje.SRV.CustomUserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final CustomUserDetailsService userService;

    public UserController(CustomUserDetailsService userService) {this.userService = userService;}


    @GetMapping("/{userIdentifier}")
    public User getById(@PathVariable Integer userIdentifier) {
        return userService.getUserById(userIdentifier);
    }
}

