package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.ConversationRepository;
import fr.madeit.arosaje.BO.Conversation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConversationRepositoryTest {

    @Mock
    private ConversationRepository conversationRepository;

    @Test
    void testFindByUser1Id() {
        when(conversationRepository.findByUser1Id(anyInt())).thenReturn(List.of(new Conversation()));

        Iterable<Conversation> result = conversationRepository.findByUser1Id(1);
        assertNotNull(result);
        verify(conversationRepository).findByUser1Id(1);
    }

    @Test
    void testFindByUser2Id() {
        when(conversationRepository.findByUser2Id(anyInt())).thenReturn(List.of(new Conversation()));

        Iterable<Conversation> result = conversationRepository.findByUser2Id(1);
        assertNotNull(result);
        verify(conversationRepository).findByUser2Id(1);
    }

    @Test
    void testFindByUser1IdAndUser2Id() {
        when(conversationRepository.findByUser1IdAndUser2Id(anyInt(), anyInt())).thenReturn(List.of(new Conversation()));

        Iterable<Conversation> result = conversationRepository.findByUser1IdAndUser2Id(1, 2);
        assertNotNull(result);
        verify(conversationRepository).findByUser1IdAndUser2Id(1, 2);
    }
}