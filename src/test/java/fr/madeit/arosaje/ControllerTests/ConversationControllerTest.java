package fr.madeit.arosaje.ControllerTests;

    import fr.madeit.arosaje.BO.Conversation;
    import fr.madeit.arosaje.BO.Message;
    import fr.madeit.arosaje.Controller.ConversationController;
    import fr.madeit.arosaje.SRV.ConversationService;
    import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
    import org.springframework.test.web.servlet.setup.MockMvcBuilders;

    import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @ExtendWith(MockitoExtension.class)
    public class ConversationControllerTest {

        @Mock
        private ConversationService conversationService;

        @InjectMocks
        private ConversationController conversationController;

        @Test
        public void testGetAllConversations() throws Exception {
            List<Conversation> mockConversations = Arrays.asList(new Conversation(), new Conversation());
            when(conversationService.getAllConversations()).thenReturn(mockConversations);

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(conversationController).build();

            mockMvc.perform(MockMvcRequestBuilders.get("/api/conversations")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockConversations.size()));
        }

        @Test
        public void testAddConversation() throws Exception {
            Conversation mockConversation = new Conversation();

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(conversationController).build();

            mockMvc.perform(MockMvcRequestBuilders.post("/api/conversations")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"id\":1,\"name\":\"Test Conversation\"}"))
                    .andExpect(status().isOk());

            // You may need to adjust the content and assertions based on your actual requirements
        }

        @Test
        public void testGetById() throws Exception {
            Integer mockConversationId = 1;
            Conversation mockConversation = new Conversation();
            mockConversation.setId(mockConversationId);
            when(conversationService.getById(mockConversationId)).thenReturn(mockConversation);

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(conversationController).build();

            mockMvc.perform(MockMvcRequestBuilders.get("/api/conversations/{id}", mockConversationId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(mockConversationId));
        }

        @Test
        public void testGetAllByUserId() throws Exception {
            Integer mockUserId = 1;
            List<Conversation> mockConversations = Arrays.asList(new Conversation(), new Conversation());
            when(conversationService.getAllByUserId(mockUserId)).thenReturn(mockConversations);

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(conversationController).build();

            mockMvc.perform(MockMvcRequestBuilders.get("/api/conversations/findByUserId/{userId}", mockUserId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockConversations.size()));
        }

        @Test
        public void testGetMessagesByConversationId() throws Exception {
            Integer mockConversationId = 1;
            List<Message> mockMessages = Arrays.asList(new Message(), new Message());
            when(conversationService.getMessagesByConversationId(mockConversationId)).thenReturn(mockMessages);

            MockMvc mockMvc = MockMvcBuilders.standaloneSetup(conversationController).build();

            mockMvc.perform(MockMvcRequestBuilders.get("/api/conversations/{conversationId}/messages", mockConversationId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(mockMessages.size()));
        }
    }