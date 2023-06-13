package tn.applicationtrack.applicationpfe.controlleur;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.applicationtrack.applicationpfe.entities.AffectationColis;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Colis;
import tn.applicationtrack.applicationpfe.entities.Notification;
import tn.applicationtrack.applicationpfe.entities.Product;
import tn.applicationtrack.applicationpfe.entities.Transporteur;
import tn.applicationtrack.applicationpfe.repository.ColisRepository;
import tn.applicationtrack.applicationpfe.repository.NotificationRepository;
import tn.applicationtrack.applicationpfe.repository.ProduitRepository;
import tn.applicationtrack.applicationpfe.service.AffectationColisService;
import tn.applicationtrack.applicationpfe.service.ColisService;
import tn.applicationtrack.applicationpfe.service.NotificationService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class ColisControlleur {
	@Autowired 
	ColisService Commandserv; 
	@Autowired 
	AffectationColisService affectationColisService; 
	@Autowired
	NotificationService notificationService;
	@Autowired 
	NotificationRepository notificationRepository;
	@Autowired 
	ColisRepository colisRep;
@PostMapping(value="/addCommand")
public Colis addCommand (@RequestBody Colis cmd) {
	return Commandserv.addCommand(cmd);
}
	@GetMapping(value="getColisByClient")
	public ResponseEntity<List<Colis>> getColisByClient() 
	{
		List<Colis> listcolis =  Commandserv.getColisByAuthClient();
		return ResponseEntity.ok(listcolis);
	}
	@GetMapping(value="getAllColis")
	public List<Colis> getAllColis() 
	{
	return Commandserv.getAllColis();
	}
	
@GetMapping(value="getCmdById/{id}")
public Colis getCmdById(@PathVariable(name="id") Long id) {
	return Commandserv.getCommandById(id);
}
@PutMapping(value="/updateCommand/{id}")
public Colis updateCommand(@PathVariable(name="id") Long id, @RequestBody Colis updatedCommand) {
	return  Commandserv.updateCommand(id,updatedCommand);
 
}
@DeleteMapping(value="/deleteCmd/{id}")
public ResponseEntity<Long> deletemd(@PathVariable(name= "id") Long id) {
	Boolean cmdDeleted = Commandserv.deleteCommand(id);
	if(cmdDeleted) {
		return ResponseEntity.ok().body(id);
	}
	else {
		return ResponseEntity.badRequest().body(id);
	}

}
@GetMapping("/numbercommands")
public ResponseEntity<Long> getNumbreCommands() {
       long numbercommands = Commandserv.getNumbercommand();
       return ResponseEntity.ok().body(numbercommands);
   }
@PostMapping("/soumettreColis")
public ResponseEntity<Colis> soumettreColis(Authentication authentication, @RequestBody Colis colis){
	String userName = authentication.getName();
	Colis nouveauColis = Commandserv.soumettreColis(colis);
	return ResponseEntity.ok(nouveauColis);
}
@PostMapping("/colis/{colisId}/transporteur/{transporteurId}")
public ResponseEntity<AffectationColis> affecterColis(
        @PathVariable("colisId") List<Long> colisIds,
        @PathVariable("transporteurId") Long transporteurId) {

    AffectationColis affectationColis = affectationColisService.affecterColis(transporteurId, colisIds);

    if (affectationColis == null) {
        // Gérer le cas où l'affectation a échoué (transporteur non trouvé, colis non trouvés, liste de colis vide, etc.)
        return ResponseEntity.badRequest().build();
    }

    // Affectation réussie
    return ResponseEntity.ok(affectationColis);
}
@GetMapping("/getColisAffecter")
public ResponseEntity<List<Colis>>  getColisAffected(){
	List<Colis> colisAffected = Commandserv.getColisAffectesAuTransporteurConnecte();
	 return ResponseEntity.ok(colisAffected);
}

@PostMapping("/accepter/{id}")
public Colis accepterCommande(@PathVariable("id") Long id) {
    // Envoi de la notification aux administrateurs
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication.getPrincipal() instanceof Transporteur) {
        Transporteur transporteur = (Transporteur) authentication.getPrincipal();
        Optional<Colis> colisOptional = colisRep.findById(id); // Récupérer le colis associé à l'ID donné
        
        if (colisOptional.isPresent()) {
            Colis colis = colisOptional.get();
            Client client = colis.getClient();
        // Enregistrer la notification
        Notification notification = new Notification();
        notification.setContenu("Le colis "+ colis.getIdCmd()+ "affecté à transporteur " + transporteur.getUsername() + " a eté accepté  ");
        notification.setHeureEnvoi(LocalDateTime.now());
        notification.setNew(true); // Définir la notification comme nouvelle
        notification.setClient(client);
        // Enregistrer la notification dans la base de données
        notificationService.sendNotificationToAdmin(notification);
        }
    }
    
    return Commandserv.accepterCommande(id);
}

 


@GetMapping("/getColsiAcceptes")
public  List<Colis> retrieveColisAcceptes() {
	return Commandserv.getColisAcceptes();
   
}
@DeleteMapping("/colis/{colisId}")
public ResponseEntity<Map<String, String>> supprimerColisPourTransporteur(@PathVariable Long colisId) {
    // Supprimer l'affectation du colis par ID
    Commandserv.supprimerAffectationColisParId(colisId);

    // Envoi de la notification aux administrateurs
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication.getPrincipal() instanceof Transporteur) {
        Transporteur transporteur = (Transporteur) authentication.getPrincipal();
        String contenuNotification = "Le colis affecté au transporteur " + transporteur.getUsername() + " a été rejeté.";

        // Enregistrer la notification
        Notification notification = new Notification();
        notification.setContenu(contenuNotification);
        notification.setHeureEnvoi(LocalDateTime.now());
        notification.setNew(true); // Définir la notification comme nouvelle

        // Enregistrer la notification dans la base de données
        notificationService.sendNotificationToAdmin(notification);
    }

    // Préparer la réponse
    Map<String, String> response = new HashMap<>();
    response.put("message", "Colis supprimé avec succès pour le transporteur.");

    return ResponseEntity.ok(response);
}

	@GetMapping("/client/{clientId}")
	public ResponseEntity<List<Notification>> getNotificationsByClient() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    if (authentication.getPrincipal() instanceof Client) {
		    	Client client = (Client) authentication.getPrincipal();
		    	
	
	    List<Notification> notifications = notificationService.getNotificationsByClient(client);
	    return ResponseEntity.ok(notifications);
	}
		    // Dans le cas où l'utilisateur authentifié n'est pas un transporteur
		    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}



