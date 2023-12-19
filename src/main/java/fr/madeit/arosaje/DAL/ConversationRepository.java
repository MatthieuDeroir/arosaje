package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    Iterable<Conversation> findByUser1Id(Integer userId);

    Iterable<Conversation> findByUser2Id(Integer userId);

    Iterable<Conversation> findByUser1IdAndUser2Id(Integer user1Id, Integer user2Id);
}
