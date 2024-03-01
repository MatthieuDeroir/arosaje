package fr.madeit.arosaje.WS;

import fr.madeit.arosaje.BO.Conversation;
import fr.madeit.arosaje.BO.Message;
import fr.madeit.arosaje.SRV.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ConversationService conversationService;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate, ConversationService conversationService) {
        this.messagingTemplate = messagingTemplate;
        this.conversationService = conversationService;
    }

    @MessageMapping("/private-message")
    public void sendPrivateMessage(Message message) {
        // Fetch the conversation using the conversationService
        Conversation conversation = conversationService.getConversationById(message.getConversationId());

        // Get both participant IDs from the conversation
        Integer user1Id = conversation.getUser1Id();
        Integer user2Id = conversation.getUser2Id();

        // Assuming the sender's ID is available in the message
        // Determine the recipient based on the sender's ID
        Integer recipientId = message.getSenderId().equals(user1Id) ? user2Id : user1Id;

        // Send the message to the recipient
        messagingTemplate.convertAndSendToUser(
                recipientId.toString(),
                "/queue/private",
                message
        );
    }
}
