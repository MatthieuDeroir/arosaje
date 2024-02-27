package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/api/conversations")
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    Iterable<Conversation> findByUser1Id(Integer userId);

    Iterable<Conversation> findByUser2Id(Integer userId);

    Iterable<Conversation> findByUser1IdAndUser2Id(Integer user1Id, Integer user2Id);


}
