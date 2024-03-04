package fr.madeit.arosaje.SRVTests;

import fr.madeit.arosaje.BO.Conversation;
import fr.madeit.arosaje.BO.Message;
import fr.madeit.arosaje.DAL.ConversationRepository;
import fr.madeit.arosaje.DAL.MessageRepository;
import fr.madeit.arosaje.SRV.ConversationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConversationServiceTest {

    @Mock
    private ConversationRepository conversationRepository;

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private ConversationService conversationService;

    @Test
    void testGetParticipantIds_ConversationExists() {
        Integer conversationId = 1;
        Conversation mockConversation = new Conversation();
        mockConversation.setId(conversationId);
        mockConversation.setUser1Id(10);
        mockConversation.setUser2Id(20);

        when(conversationRepository.findById(conversationId)).thenReturn(Optional.of(mockConversation));

        List<Integer> result = conversationService.getParticipantIds(conversationId);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(10));
        assertTrue(result.contains(20));
    }

    @Test
    void testGetParticipantIds_ConversationDoesNotExist() {
        Integer conversationId = 1;

        when(conversationRepository.findById(conversationId)).thenReturn(Optional.empty());

        List<Integer> result = conversationService.getParticipantIds(conversationId);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetConversationById_ConversationExists() {
        Integer conversationId = 1;
        Conversation mockConversation = new Conversation();
        mockConversation.setId(conversationId);

        when(conversationRepository.findById(conversationId)).thenReturn(Optional.of(mockConversation));

        Conversation result = conversationService.getConversationById(conversationId);

        assertNotNull(result);
        assertEquals(conversationId, result.getId());
    }

    @Test
    void testGetConversationById_ConversationDoesNotExist() {
        Integer conversationId = 1;

        when(conversationRepository.findById(conversationId)).thenReturn(Optional.empty());

        Conversation result = conversationService.getConversationById(conversationId);

        assertNull(result);
    }

    @Test
    void testGetAllConversations() {
        List<Conversation> mockConversations = new ArrayList<>();
        mockConversations.add(new Conversation());
        mockConversations.add(new Conversation());

        when(conversationRepository.findAll()).thenReturn(mockConversations);

        List<Conversation> result = conversationService.getAllConversations();

        assertNotNull(result);
        assertEquals(mockConversations.size(), result.size());
    }

    @Test
    void testGetById_ConversationExists() {
        Integer conversationId = 1;
        Conversation mockConversation = new Conversation();
        mockConversation.setId(conversationId);

        when(conversationRepository.findById(conversationId)).thenReturn(Optional.of(mockConversation));

        Conversation result = conversationService.getById(conversationId);

        assertNotNull(result);
        assertEquals(conversationId, result.getId());
    }

    @Test
    void testGetById_ConversationDoesNotExist() {
        Integer conversationId = 1;

        when(conversationRepository.findById(conversationId)).thenReturn(Optional.empty());

        Conversation result = conversationService.getById(conversationId);

        assertNull(result);
    }

    @Test
    void testGetAllByUserId() {
        Integer userId = 1;
        List<Conversation> mockConversations1 = new ArrayList<>();
        mockConversations1.add(new Conversation());

        List<Conversation> mockConversations2 = new ArrayList<>();
        mockConversations2.add(new Conversation());

        when(conversationRepository.findByUser1Id(userId)).thenReturn(mockConversations1);
        when(conversationRepository.findByUser2Id(userId)).thenReturn(mockConversations2);

        Iterable<Conversation> result = conversationService.getAllByUserId(userId);

        assertNotNull(result);
        List<Conversation> resultList = new ArrayList<>();
        result.forEach(resultList::add);
        assertEquals(2, resultList.size());
    }

    @Test
    void testAddConversation() {
        Conversation mockConversation = new Conversation();

        conversationService.addConversation(mockConversation);

        verify(conversationRepository).save(mockConversation);
    }

    @Test
    void testGetConversationWithMessagesByUsers() {
        Integer user1Id = 1;
        Integer user2Id = 2;

        Conversation mockConversation = new Conversation();
        mockConversation.setId(1);

        List<Conversation> mockConversations = new ArrayList<>();
        mockConversations.add(mockConversation);

        when(conversationRepository.findByUser1IdAndUser2Id(user1Id, user2Id)).thenReturn(mockConversations);

        conversationService.getConversationWithMessagesByUsers(user1Id, user2Id);

        verify(messageRepository).findByConversationId(1);
    }

    @Test
    void testGetMessagesByConversationId() {
        Integer conversationId = 1;
        List<Message> mockMessages = new ArrayList<>();
        mockMessages.add(new Message());
        mockMessages.add(new Message());

        when(messageRepository.findByConversationId(conversationId)).thenReturn(mockMessages);

        Iterable<Message> result = conversationService.getMessagesByConversationId(conversationId);

        assertNotNull(result);
        List<Message> resultList = new ArrayList<>();
        result.forEach(resultList::add);
        assertEquals(mockMessages.size(), resultList.size());
    }
}