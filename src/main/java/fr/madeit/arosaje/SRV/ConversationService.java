package fr.madeit.arosaje.SRV;

import fr.madeit.arosaje.BO.Conversation;
import fr.madeit.arosaje.BO.Message;
import fr.madeit.arosaje.DAL.ConversationRepository;
import fr.madeit.arosaje.DAL.MessageRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    private final ConversationRepository conversationRepository;

    private final MessageRepository messageRepository;

    public ConversationService(ConversationRepository conversationRepository, MessageRepository messageRepository) {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
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

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    public Conversation getById(Integer id) {
        return conversationRepository.findById(id).orElse(null);
    }

    public Iterable<Conversation> getAllByUserId(Integer userId) {
        Iterable<Conversation> conversations1 = conversationRepository.findByUser1Id(userId);
        Iterable<Conversation> conversations2 = conversationRepository.findByUser2Id(userId);

        List<Conversation> conversations = new ArrayList<>();
        conversations1.forEach(conversations::add);
        conversations2.forEach(conversations::add);

        return conversations;
    }

    public void addConversation(Conversation conversation) {
        conversationRepository.save(conversation);
    }

    public void getConversationWithMessagesByUsers(Integer user1Id, Integer user2Id) {
        Iterable<Conversation> conversations = conversationRepository.findByUser1IdAndUser2Id(user1Id, user2Id);
        // Must look in the messages table to retrieve the messages with the conversation ID
        Iterable<Message> messages = messageRepository.findByConversationId(conversations.iterator().next().getId());
    }

    public Iterable<Message> getMessagesByConversationId(Integer conversationId) {
        return messageRepository.findByConversationId(conversationId);
    }
}


