package fr.madeit.arosaje.Controller;

import fr.madeit.arosaje.BO.Conversation;
import fr.madeit.arosaje.SRV.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/conversations")
public class ConversationController {


    @Autowired
    private final ConversationService conversationService;


    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }

    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public void addConversation(@RequestBody Conversation conversation) {
        conversationService.addConversation(conversation);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Conversation getById(@PathVariable Integer id) {
        return conversationService.getById(id);
    }

    @GetMapping("/findByUserId/{userId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Conversation> getAllByUserId(@PathVariable Integer userId) {
        return conversationService.getAllByUserId(userId);
    }

    @GetMapping("{conversationId}/messages")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<fr.madeit.arosaje.BO.Message> getMessagesByConversationId(@PathVariable Integer conversationId) {
        return conversationService.getMessagesByConversationId(conversationId);
    }


}
