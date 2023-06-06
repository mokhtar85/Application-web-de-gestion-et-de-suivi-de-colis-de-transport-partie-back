package tn.applicationtrack.applicationpfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
import tn.applicationtrack.applicationpfe.entities.Colis;
import tn.applicationtrack.applicationpfe.entities.Product;
import tn.applicationtrack.applicationpfe.repository.ProduitRepository;
import tn.applicationtrack.applicationpfe.service.AffectationColisService;
import tn.applicationtrack.applicationpfe.service.ColisService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class ColisControlleur {
	@Autowired 
	ColisService Commandserv; 
	@Autowired 
	AffectationColisService affectationColisService; 
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
    return Commandserv.accepterCommande(id);
}

@GetMapping("/getColsiAcceptes")
public List<Colis> getColisAcceptes() {
    return Commandserv.getColisAcceptes();
}
@DeleteMapping("/colis/{colisId}")
public ResponseEntity<String> supprimerColisPourTransporteur(@PathVariable Long colisId) {
   
    	Commandserv.supprimerColisParId(colisId);
        return ResponseEntity.ok("Colis supprimé avec succès pour le transporteur.");
    
     
    }
}



