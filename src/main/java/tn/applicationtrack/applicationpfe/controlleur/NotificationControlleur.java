package tn.applicationtrack.applicationpfe.controlleur;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Notification;
import tn.applicationtrack.applicationpfe.entities.Transporteur;
import tn.applicationtrack.applicationpfe.repository.NotificationRepository;
import tn.applicationtrack.applicationpfe.requests.NotificationRequest;
import tn.applicationtrack.applicationpfe.service.NotificationService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class NotificationControlleur {
	@Autowired
	 private final NotificationService notificationService;
		 @GetMapping("/notifications")
	    public ResponseEntity<List<Notification>> getAllNotifications() {
	        List<Notification> notifications = notificationService.getAllNotifications();
	        return ResponseEntity.ok(notifications);
	    }
		 @GetMapping("/notificationclient")
		    public ResponseEntity<List<Notification>> getNotificationsForAuthenticatedClient() {
			  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			    if (authentication.getPrincipal() instanceof Client) {
			    	Client client = (Client) authentication.getPrincipal();
		            List<Notification> notifications = notificationService.getNotificationsByClient(client);
		            
		            // Mettre à jour le contenuClient avec le message spécifié
		            for (Notification notification : notifications) {
		                notification.setContenuClient("Votre colis est en train de se faire livrer");
		                notificationService.saveNotification(notification);
		            }
		            
		            return ResponseEntity.ok(notifications);
		        } else {
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		        }
		    }
		

}