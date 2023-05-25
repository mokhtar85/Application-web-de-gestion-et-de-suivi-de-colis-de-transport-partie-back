package tn.applicationtrack.applicationpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.applicationtrack.applicationpfe.entities.Product;

public interface ProduitRepository extends JpaRepository<Product, Long> {

}
