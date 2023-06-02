package tn.applicationtrack.applicationpfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Transporteur;
import tn.applicationtrack.applicationpfe.service.Transporteurservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
public class Transporteurcontrolleur {
	
	@Autowired
	Transporteurservice Transporteurserv;
	
@PostMapping(value="/addTransporteur")
public Transporteur addTransporteur(@RequestBody Transporteur transporteur) {
	return Transporteurserv.addTransporteur(transporteur);
}
@GetMapping(value="/getAllTransporteur")
public List<Transporteur> getAllTransporteur() {
	return Transporteurserv.getAllTransporters();

}
@GetMapping(value="getTranspById/{id}")
public Transporteur getCmdById(@PathVariable(name="id") Long id) {
	return Transporteurserv.getTransporteurById(id);
}
@PutMapping(value="/updateTrans/{id}")
public Transporteur updateUser(@PathVariable(name="id") Long id, @RequestBody Transporteur updatedTrans) {
	return  Transporteurserv.updateTrans(id, updatedTrans);
 
}
@DeleteMapping(value="/deleteTrans/{id}")
public ResponseEntity<Long> deleteTrans(@PathVariable(name= "id") Long id) {
	Boolean transporterDeleted = Transporteurserv.deleteTrans(id);
	if(transporterDeleted) {
		return ResponseEntity.ok().body(id);
	}
	else {
		return ResponseEntity.badRequest().body(id);
	}
	

}
@GetMapping("/numbertransporters")
public ResponseEntity<Long> getNumbretransporters() {
       long numbertransporters = Transporteurserv.getNombreTransporters();
       return ResponseEntity.ok().body(numbertransporters);
   }

}
