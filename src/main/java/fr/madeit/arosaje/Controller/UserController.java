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


    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public User getById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}

