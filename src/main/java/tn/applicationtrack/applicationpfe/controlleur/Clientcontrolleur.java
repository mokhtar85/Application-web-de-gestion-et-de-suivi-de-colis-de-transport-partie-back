package tn.applicationtrack.applicationpfe.controlleur;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.service.Clientservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Clientcontrolleur {
	@Autowired 
	Clientservice clientserv;
	
	
	@PostMapping(value="/addRoleUser/{idRole}")
public Client addclientRole(@RequestBody Client client, @PathVariable("idRole") Long idRole) {
	
	
	return clientserv.addClient(client, idRole)	;
}
	@PostMapping(value="/addClientWithoutRole")
	public Client addClientWithoutRole(@RequestBody Client client) {
		
		
		return clientserv.addClientWithoutRole(client)	;
	
}
	@PostMapping(value="/addClientWithTestmail")
	public String addClientWithTestmail(@RequestBody Client client) {
		
		
		return clientserv.addClientWithTestmail(client)	;
	
}
	@PostMapping(value="/addClientWithTestpassword")
	public String addClientWithTestpassword(@RequestBody Client client) {
		
		
		return clientserv.addClientWithTestpassword(client)	;
	
}
	@DeleteMapping(value="/deleteUser/{iduser}")
	public String deleteUser(@PathVariable(name= "iduser") Long iduser) {
		
		
		return clientserv.deleteUser(iduser);
	
}
	@GetMapping(value="/findallClientByUsername/{ch}")
	public List<Client> findClientByUsername(@PathVariable(name = "ch") String ch) {
		return clientserv.findAllClientbyuserName(ch);
}
	@GetMapping(value="getAllClients")
	public List<Client> getAllClients() 
	{ return clientserv.getAllClients();}
	@GetMapping(value="getclientById/{iduser}")
	public Client getClientById(@PathVariable(name="iduser") Long iduser){
		return clientserv.getClientById(iduser);
	}
	 @PutMapping(value="/updateClient/{id}")
	  public Client updateUser(@PathVariable(name="id") Long idUser, @RequestBody Client updatedUser) {
		return  clientserv.updateUser(idUser, updatedUser);
	   
	  }
	 
}