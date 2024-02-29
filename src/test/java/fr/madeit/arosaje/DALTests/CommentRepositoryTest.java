package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.CommentRepository;
import fr.madeit.arosaje.BO.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentRepositoryTest {

    @Mock
    private CommentRepository commentRepository;

    @Test
    void testFindByEntityTypeAndEntityId() {
        when(commentRepository.findByEntityTypeAndEntityId(anyString(), anyInt())).thenReturn(List.of(new Comment()));

        Iterable<Comment> result = commentRepository.findByEntityTypeAndEntityId("type", 1);
        assertNotNull(result);
        verify(commentRepository).findByEntityTypeAndEntityId("type", 1);
    }

    @Test
    void testFindByUserId() {
        when(commentRepository.findByUserId(anyInt())).thenReturn(List.of(new Comment()));

        Iterable<Comment> result = commentRepository.findByUserId(1);
        assertNotNull(result);
        verify(commentRepository).findByUserId(1);
    }
}