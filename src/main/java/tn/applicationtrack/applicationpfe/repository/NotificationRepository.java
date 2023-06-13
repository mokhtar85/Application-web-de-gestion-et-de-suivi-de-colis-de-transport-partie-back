package tn.applicationtrack.applicationpfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Notification;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n WHERE n.isNew = true")
    List<Notification> findNewNotifications();

    @Query("SELECT n FROM Notification n WHERE n.id > :lastNotificationId AND n.isNew = true")
    List<Notification> findNewNotificationsByIdGreaterThan(Long lastNotificationId);
    List<Notification> findAllByOrderByHeureEnvoiDesc();

	List<Notification> findByClientOrderByHeureEnvoiDesc(Client client);

	//List<Notification> findByClientOrderByHeureEnvoiDesc(Client client);
}

