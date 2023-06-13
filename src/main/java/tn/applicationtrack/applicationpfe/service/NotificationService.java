package tn.applicationtrack.applicationpfe.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.config.NotificationWebSocketHandler;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Notification;
import tn.applicationtrack.applicationpfe.repository.NotificationRepository;
import tn.applicationtrack.applicationpfe.requests.NotificationRequest;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    public void sendNotificationToAdmin(Notification notification) {
        // Enregistrer la notification dans la base de données
        notificationRepository.save(notification);
    }

  

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAllByOrderByHeureEnvoiDesc();
    }

	public void saveNotification(Notification notification) {
		// TODO Auto-generated method stub
		notificationRepository.save(notification);
	}
	public List<Notification> getNotificationsByClient(Client client) {
        return notificationRepository.findByClientOrderByHeureEnvoiDesc(client);
    }
}
