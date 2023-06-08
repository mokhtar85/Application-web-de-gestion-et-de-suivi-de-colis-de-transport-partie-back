package tn.applicationtrack.applicationpfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Role;
import tn.applicationtrack.applicationpfe.repository.Clientrreposiotry;
import tn.applicationtrack.applicationpfe.repository.RoleRepository;
@Service
@RequiredArgsConstructor
public class Clientservice implements IClientService {
	private  final PasswordEncoder passwordEncoder;
	
	@Autowired
	Clientrreposiotry clientrep;
	/*@Override
	/*public Client addClient(Client client, Long idRole) {
		// TODO Auto-generated method stub
		Role role = rolerep.findById(idRole).get();
	    client.setRoleclient(role);
		return clientrep.save(client);
	}*/
	@Override
	public Client addClientWithoutRole(Client client) {
		// TODO Auto-generated method stub
		return clientrep.save(client);
	}
	@Override
	public Client addClientWithTestmail(Client client) {
		// TODO Auto-generated method stub
		
		if (clientrep.existsByEmail(client.getEmail()) ) {
			return null;
		}
		else {
			 return clientrep.save(client);
			
			
		}
		
		
	}
	@Override
	public String addClientWithTestpassword(Client client) {
		// TODO Auto-generated method stub
		System.out.println(client.getPassword());
		System.out.println(client.getConfirmPassword());
		String ch="";
		if(client.getPassword().equals(client.getConfirmPassword())) {//ca marche pas ca sort que de "password not matched"//
			clientrep.save(client);
			ch="user added successfully";
		}
		else {
			ch="password not matched";
		}
		return ch;
		
	}
	
	public Boolean deleteUser(Long iduser) {
		
		// TODO Auto-generated method stub
		
		if(clientrep.existsById(iduser)) {
		 clientrep.deleteById(iduser);
		 return true;
		}
		else {
			
			 return false;
		}
		
	}
	public List<Client> findAllClientbyuserName(String ch) {
		// TODO Auto-generated method stub
		return clientrep.findAllClientbyuserName(ch);
	}
	public Client updateUser(Client client, Long idUser) {
		// TODO Auto-generated method stub
		Client clt = clientrep.findById(idUser).get();
		clt.setFirstName(client.getFirstName());
		clt.setLastName(client.getLastName());
		
		return clientrep.save(clt);
	}

	    

	    public List<Client> getAllClients() {
	        return clientrep.findAll();
	    }
	    
		public Client getClientById(Long id) {
			// TODO Auto-generated method stub
			Client clt = clientrep.findById(id).get();
			return clt;
		}

		  public Client updateUser(Long idUser, Client updatedUser) {
		    Optional<Client> optionalUser = clientrep.findById(idUser);
		      Client user = optionalUser.get();
		      user.setUserName(updatedUser.getUserName());
		      user.setFirstName(updatedUser.getFirstName());
		      user.setLastName(updatedUser.getLastName());
		      user.setPhone(updatedUser.getPhone());
		      user.setCity(updatedUser.getCity());
		      user.setAdress(updatedUser.getAdress());
		      user.setPassword(updatedUser.getPassword());
		      user.setConfirmPassword(updatedUser.getConfirmPassword());
		      user.setEmail(updatedUser.getEmail());
		      return clientrep.save(user);
		   
		  }
		  public Long getNombreClients() {
		        return clientrep.count();
		    }
		/*@Override
		public Client fetchClientByEmailId(String email) {
			// TODO Auto-generated method stub
			return clientrep.findByEmail(email);
		}*/
		public Client fetchClientByEmailIdAndPassword(String email,String password) {
			// TODO Auto-generated method stub
			return clientrep.findByEmailAndPassword(email,password);
		}
		@Override
		 public Client updateClient( Client updatedClient) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication.getPrincipal() instanceof Client) {
	            Client existingClient = (Client) authentication.getPrincipal();
	            existingClient.setUserName(updatedClient.getUserName());
	            existingClient.setLastName(updatedClient.getLastName());
	            existingClient.setFirstName(updatedClient.getFirstName());
	            existingClient.setPhone(updatedClient.getPhone());
	            existingClient.setAdress(updatedClient.getAdress());
	            existingClient.setCity(updatedClient.getCity());

	            // Vérifier si un nouveau mot de passe est fourni
	            if (updatedClient.getPassword() != null) {
	                // Crypter le nouveau mot de passe
	                String hashedPassword = passwordEncoder.encode(updatedClient.getPassword());
	                existingClient.setPassword(hashedPassword);
	            }
	            if (updatedClient.getConfirmPassword() != null) {
	                // Crypter le nouveau mot de passe
	                String hashedConfirmPassword = passwordEncoder.encode(updatedClient.getConfirmPassword());
	                existingClient.setConfirmPassword(hashedConfirmPassword);
	            }

	            return clientrep.save(existingClient);
	        }

	        throw new IllegalStateException("Client non authentifié.");
	    }
		@Override
		public Client getCurrentClient() {
			// TODO Auto-generated method stub
			 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		        if (authentication.getPrincipal() instanceof Client) {
		        	   return (Client) authentication.getPrincipal();
		        }
		        return null;
		}
		
		}
		
		
	
	
	


