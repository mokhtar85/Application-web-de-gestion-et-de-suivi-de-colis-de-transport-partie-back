package tn.applicationtrack.applicationpfe.service;

import java.util.Optional;

import tn.applicationtrack.applicationpfe.entities.Admin;
import tn.applicationtrack.applicationpfe.repository.Adminrepository;

public class AdminServiceImpl {
	 private final Adminrepository adminRepository;

	    public AdminServiceImpl(Adminrepository adminRepository) {
	        this.adminRepository = adminRepository;
	    }

	    public Admin getAdminByEmail(String email) {
	    	  Optional<Admin> adminOptional = adminRepository.findByEmail(email);
	    	if (adminOptional.isPresent()) {
	    	    Admin admin = adminOptional.get();
	    	    return admin;
	    	    // Autres opérations avec l'administrateur trouvé
	    	} else {
	    	    throw new RuntimeException("Aucun administrateur trouvé pour l'e-mail donné");
	    	    // ou
	    	    // claims.put("role", "ROLE_DEFAULT");
	    	    // Utiliser une valeur par défaut pour le rôle de l'administrateur
	    	}
	    }
}
