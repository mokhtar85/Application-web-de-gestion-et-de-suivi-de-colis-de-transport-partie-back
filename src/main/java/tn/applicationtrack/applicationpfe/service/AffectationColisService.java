package tn.applicationtrack.applicationpfe.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.entities.AffectationColis;
import tn.applicationtrack.applicationpfe.entities.Colis;
import tn.applicationtrack.applicationpfe.entities.Transporteur;
import tn.applicationtrack.applicationpfe.repository.Adminrepository;
import tn.applicationtrack.applicationpfe.repository.AffectationColisRepository;
import tn.applicationtrack.applicationpfe.repository.ColisRepository;
import tn.applicationtrack.applicationpfe.repository.Transporteurrepository;

@Service
public class AffectationColisService {
	  @Autowired
	    private AffectationColisRepository affectationColisRepository;

	    @Autowired
	    private ColisRepository colisRepository;

	    @Autowired
	    private Transporteurrepository transporteurRepository;
	  

	    @Transactional
	    public AffectationColis affecterColis(Long transporteurId, List<Long> colisIds) {
	        Transporteur transporteur = transporteurRepository.findById(transporteurId).orElse(null);

	        if (transporteur == null) {
	            // Gérer le cas où le transporteur n'est pas trouvé
	            return null;
	        }

	        List<Colis> colisList = new ArrayList<>();

	        for (Long colisId : colisIds) {
	            Colis colis = colisRepository.findById(colisId).orElse(null);

	            if (colis != null) {
	                colisList.add(colis);
	            } else {
	                // Gérer le cas où un colis n'est pas trouvé
	                // Vous pouvez choisir d'ignorer ce colis ou d'annuler l'affectation complète
	            	 return null;
	            }
	        }

	        if (colisList.isEmpty()) {
	            // Gérer le cas où la liste des colis est vide
	            return null;
	        }

	        Date dateAffectation = new Date();
	        AffectationColis affectationColis = new AffectationColis(transporteur, colisList, dateAffectation);
	        return affectationColisRepository.save(affectationColis);
	    }
	   

}
