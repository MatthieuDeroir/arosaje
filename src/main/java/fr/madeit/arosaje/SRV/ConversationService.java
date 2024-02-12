package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Conversation;
import fr.madeit.arosaje.DAL.ConversationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public List<Integer> getParticipantIds(Integer conversationId) {
        // Retrieve the conversation by ID
        Optional<Conversation> conversationOptional = conversationRepository.findById(conversationId);

        List<Integer> participantIds = new ArrayList<>();
        if (conversationOptional.isPresent()) {
            // Assuming Conversation entity has user1Id and user2Id fields
            Conversation conversation = conversationOptional.get();
            participantIds.add(conversation.getUser1Id());
            participantIds.add(conversation.getUser2Id());
        }

        return participantIds;
    }

    public Conversation getConversationById(Integer conversationId) {
        // Retrieve the conversation by ID
        Optional<Conversation> conversationOptional = conversationRepository.findById(conversationId);

        return conversationOptional.orElse(null);
    }
}


