package tn.applicationtrack.applicationpfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.applicationtrack.applicationpfe.entities.Product;
import tn.applicationtrack.applicationpfe.repository.ProduitRepository;
import tn.applicationtrack.applicationpfe.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/auth")
public class ProductControlleur {
	@Autowired
	ProductService productServ;

	@PostMapping("/produits/{colisId}")
	public ResponseEntity<Product> ajouterProduitAuColis(@PathVariable Long colisId, @RequestBody Product produit) {
		Product addedProduct = productServ.addProductToColis(colisId, produit);
		return ResponseEntity.ok(addedProduct);
	}

	@GetMapping("/listProducts/{colisId}")
	public ResponseEntity<List<Product>> getAllProductsByColis(@PathVariable Long colisId) {
		List<Product> products = productServ.getAllProductsByColis(colisId);
		return ResponseEntity.ok(products);
	}
}
