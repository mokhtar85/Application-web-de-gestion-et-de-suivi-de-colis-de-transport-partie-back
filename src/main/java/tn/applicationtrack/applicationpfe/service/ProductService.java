package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.entities.Colis;
import tn.applicationtrack.applicationpfe.entities.Product;
import tn.applicationtrack.applicationpfe.repository.ColisRepository;
import tn.applicationtrack.applicationpfe.repository.ProduitRepository;

@Service
@Transactional
public class ProductService implements IProductService {
	@Autowired 
	ColisRepository colisRep;
	@Autowired 
	ProduitRepository produitRepo;
	
	public Product addProductToColis(Long colisId, Product produit) {
	    Colis colis = colisRep.findById(colisId)
	            .orElseThrow(() -> new IllegalArgumentException("Colis non trouvé"));

	    produit.setColis(colis);
	    colis.addProduct(produit);
	    colisRep.save(colis);
	    return produit;
	}
	public List<Product> getAllProductsByColis(Long colisId) {
        Colis colis = colisRep.findById(colisId)
                .orElseThrow(() -> new IllegalArgumentException("Colis non trouvé"));

        return colis.getProduits();
    }
	

}
