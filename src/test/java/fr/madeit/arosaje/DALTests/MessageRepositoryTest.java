package fr.madeit.arosaje.DALTests;

import fr.madeit.arosaje.DAL.MessageRepository;
import fr.madeit.arosaje.BO.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageRepositoryTest {

    @Mock
    private MessageRepository messageRepository;

    @Test
    void testFindByConversationId() {
        when(messageRepository.findByConversationId(anyInt())).thenReturn(List.of(new Message()));

        Iterable<Message> result = messageRepository.findByConversationId(1);
        assertNotNull(result);
        verify(messageRepository).findByConversationId(1);
    }

    @Test
    void testFindBySenderId() {
        when(messageRepository.findBySenderId(anyInt())).thenReturn(List.of(new Message()));

        Iterable<Message> result = messageRepository.findBySenderId(1);
        assertNotNull(result);
        verify(messageRepository).findBySenderId(1);
    }}