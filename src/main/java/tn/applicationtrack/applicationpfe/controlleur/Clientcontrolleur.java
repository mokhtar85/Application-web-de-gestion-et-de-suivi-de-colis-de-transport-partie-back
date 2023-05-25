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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.service.Clientservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
public class Clientcontrolleur {
	@Autowired 
	Clientservice clientserv;
	
	
	/*@PostMapping(value="/addRoleUser/{idRole}")
public Client addclientRole(@RequestBody Client client, @PathVariable("idRole") Long idRole) {
	
	
	return clientserv.addClient(client, idRole)	;
}*/
	/*@PostMapping(value="/addClientWithoutRole")
	public Client addClientWithoutRole(@RequestBody Client client) throws Exception {
		
		String tempEmailId=client.getEmail();
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			Client clientobj = clientserv.fetchClientByEmailId(tempEmailId);
			if(clientobj!=null) {
				throw new Exception("user with this"+tempEmailId+ "already exists");
			}
		}
		
		return clientserv.addClientWithoutRole(client)	;
	
}*/
	@PostMapping(value="/addClientWithTestmail")
	public Client addClientWithTestmail(@RequestBody Client client) {
		
		
		return clientserv.addClientWithTestmail(client)	;
	
}
	@PostMapping(value="/addClientWithTestpassword")
	public String addClientWithTestpassword(@RequestBody Client client) {
		
		
		return clientserv.addClientWithTestpassword(client)	;
	
}
	@DeleteMapping(value="/deleteUser/{iduser}")
	public ResponseEntity<Long> deleteUser(@PathVariable(name= "iduser") Long iduser) {
		
		
		Boolean usrDeleted= clientserv.deleteUser(iduser);
		if(usrDeleted) {
			return ResponseEntity.ok().body(iduser);
		}
		else {
			return ResponseEntity.badRequest().body(iduser);
		}
		
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
	 @GetMapping("/nombre")
	 public ResponseEntity<Long> getNombreClients() {
	        long nombreClients = clientserv.getNombreClients();
	        return ResponseEntity.ok().body(nombreClients);
	    }
	 @PostMapping("/loginUsr")
	 public Client loginUser(@RequestBody Client client) throws Exception {
		 String tempEmail = client.getEmail();
		 String tempPassword = client.getPassword();
		 Client clientObj = null;
		 if(tempEmail != null && tempPassword != null ) {
			clientObj=clientserv.fetchClientByEmailIdAndPassword(tempEmail, tempPassword);
		 }
		 if(clientObj==null) {
			 throw new Exception("bad informations");
		 }
		 return clientObj;
		 
	 }
	 

	 
}