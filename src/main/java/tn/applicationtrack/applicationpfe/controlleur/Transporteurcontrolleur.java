package tn.applicationtrack.applicationpfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.applicationtrack.applicationpfe.entities.Transporteur;
import tn.applicationtrack.applicationpfe.service.Transporteurservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Transporteurcontrolleur {
	
	@Autowired
	Transporteurservice Transporteurserv;
	
@PostMapping(value="/addTransporteur")
public Transporteur addTransporteur(@RequestBody Transporteur transporteur) {
	return Transporteurserv.addTransporteur(transporteur);
}
@GetMapping(value="/getAllTransporteur")
public List<Transporteur> getAllTransporteur() {
	return Transporteurserv.getAllTransporteur();

}
}
