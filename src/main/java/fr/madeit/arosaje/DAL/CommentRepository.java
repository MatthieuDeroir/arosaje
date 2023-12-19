package fr.madeit.arosaje.DAL;

import fr.madeit.arosaje.BO.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Iterable<Comment> findByEntityTypeAndEntityId(String entityType, Integer entityId);

    Iterable<Comment> findByUserId(Integer userId);

}
