package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer>{
    public abstract Iterable<Message> findByConversationId(Integer conversationId);
    public abstract Iterable<Message> findBySenderId(Integer senderId);

}
