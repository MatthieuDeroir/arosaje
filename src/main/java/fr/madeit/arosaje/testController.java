package fr.madeit.arosaje;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class testController {
    @GetMapping("/caca")
    public Map<String, String> test(){
        return Map.of("caca","caca");
    }
}