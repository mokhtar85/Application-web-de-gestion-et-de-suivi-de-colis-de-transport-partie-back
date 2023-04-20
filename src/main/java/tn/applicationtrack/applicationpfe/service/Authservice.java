package tn.applicationtrack.applicationpfe.service;

import org.springframework.beans.factory.annotation.Autowired;

import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.repository.Clientrreposiotry;

public class Authservice {

@Autowired 
Clientrreposiotry clientrep;

public Client login(String userName,String Password) throws Exception {
	Client client = clientrep.findByUserName(userName);
   
	if (!client.getPassword().equals(Password)) {
        throw new Exception("Nom d'utilisateur ou mot de passe invalide");
	
	
}
	return client;
}
}


