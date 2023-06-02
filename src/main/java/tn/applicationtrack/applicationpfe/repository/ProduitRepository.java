package tn.applicationtrack.applicationpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.applicationtrack.applicationpfe.entities.Product;
@Repository
public interface ProduitRepository extends JpaRepository<Product, Long> {

}
