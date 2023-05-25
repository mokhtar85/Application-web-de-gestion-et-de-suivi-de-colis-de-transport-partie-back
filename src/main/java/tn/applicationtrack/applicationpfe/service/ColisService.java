package tn.applicationtrack.applicationpfe.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Colis;
import tn.applicationtrack.applicationpfe.entities.Product;
import tn.applicationtrack.applicationpfe.repository.Clientrreposiotry;
import tn.applicationtrack.applicationpfe.repository.ColisRepository;
import tn.applicationtrack.applicationpfe.repository.ProduitRepository;
@Service
public class ColisService implements IColisservice {
	@Autowired
	ColisRepository cmdrep;
	@Autowired
	Clientrreposiotry clientRep;
	@Autowired
	ProduitRepository productRep;
	public Colis addCommand(Colis cmd) {
		// TODO Auto-generated method stub
		return cmdrep.save(cmd);
	}
	@Override
	public List<Colis> getColisByAuthClient() {
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		    if (authentication.getPrincipal() instanceof Client) {
		        Client client = (Client) authentication.getPrincipal();
		        return cmdrep.findByClient(client);
		    }
		    // Gérer le cas où le client n'est pas authentifié correctement
		    throw new IllegalStateException("Client non authentifié.");
	
	}
	public List<Colis> getAllColis(){
		return cmdrep.findAll();
	}
	@Override
	public Colis getCommandById(Long id) {
		// TODO Auto-generated method stub
		Colis cmd = cmdrep.findById(id).get();
		return cmd;
	}
	@Override
	public Colis updateCommand(Long id, Colis updatedCommand) {
		// TODO Auto-generated method stub
		Optional<Colis> optionalCmd = cmdrep.findById(id);
	      Colis cmd = optionalCmd.get();
	      cmd.setAdresseExpedition(updatedCommand.getAdresseExpedition());
	      cmd.setAdresseLivraison(updatedCommand.getAdresseLivraison());
	      cmd.setDate(updatedCommand.getDate());
	      cmd.setNumberProduct(updatedCommand.getNumberProduct());
	      cmd.setPoid(updatedCommand.getPoid());
	      cmd.setTaille(updatedCommand.getTaille());
	      cmd.setRemarques(updatedCommand.getRemarques());
	      return cmdrep.save(cmd);
	}
	@Override
	public Boolean deleteCommand(Long id) {
		// TODO Auto-generated method stub
		String ch="";
		if(cmdrep.existsById(id)) {
		 cmdrep.deleteById(id);
		 return true;
		}
		else {
			 return false ;
		}
		
	}
	@Override
	public Long getNumbercommand() {
		// TODO Auto-generated method stub
		return cmdrep.count();
	}
	
	public Colis soumettreColis( Colis colis) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication.getPrincipal() instanceof Client) {
	        Client client = (Client) authentication.getPrincipal();
	        colis.setClient(client);

	        // Sauvegarder le colis pour générer l'identifiant
	        Colis createdColis = cmdrep.save(colis);

            return createdColis;
	      
	    }

	    // Gérer le cas où le client n'est pas authentifié correctement
	    throw new IllegalStateException("Client non authentifié.");
	}

}

	


