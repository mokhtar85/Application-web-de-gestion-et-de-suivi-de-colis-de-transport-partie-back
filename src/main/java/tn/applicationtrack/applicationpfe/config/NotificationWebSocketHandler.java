package tn.applicationtrack.applicationpfe.config;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import tn.applicationtrack.applicationpfe.entities.Notification;

@Component
public class NotificationWebSocketHandler extends TextWebSocketHandler {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationWebSocketHandler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Traitez les messages reçus du client (si nécessaire)
    }

    public void sendNotificationToAdmin(Notification notification) {
        messagingTemplate.convertAndSend("/topic/admin-notifications", notification);
    }
}
