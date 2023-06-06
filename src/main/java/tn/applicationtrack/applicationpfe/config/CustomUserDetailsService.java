package tn.applicationtrack.applicationpfe.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tn.applicationtrack.applicationpfe.entities.Admin;
import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Transporteur;
import tn.applicationtrack.applicationpfe.repository.Adminrepository;
import tn.applicationtrack.applicationpfe.repository.Clientrreposiotry;
import tn.applicationtrack.applicationpfe.repository.Transporteurrepository;

public class CustomUserDetailsService  implements UserDetailsService  {
    private final Clientrreposiotry clientRepository;
    private final Adminrepository adminRepository;
    private final Transporteurrepository trasnporteurRepository;
    
    public CustomUserDetailsService(Clientrreposiotry clientRepository, Adminrepository adminRepository,Transporteurrepository trasnporteurRepository) {
        this.clientRepository = clientRepository;
        this.adminRepository = adminRepository;
        this.trasnporteurRepository=trasnporteurRepository;
       
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Recherche d'un client par e-mail
        Optional<Client> clientOptional = clientRepository.findByEmail(username);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return client;
        }
        
        // Recherche d'un admin par e-mail
        Optional<Admin> adminOptional = adminRepository.findByEmail(username);
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            return admin;
        }
        
        // Recherche d'un transporteur par e-mail
        Optional<Transporteur> TransporteurOptional = trasnporteurRepository.findByEmail(username);
        if (TransporteurOptional.isPresent()) {
        	Transporteur transporteur = TransporteurOptional.get();
            return transporteur;
        }
        
        throw new UsernameNotFoundException("User not found");
    }
}