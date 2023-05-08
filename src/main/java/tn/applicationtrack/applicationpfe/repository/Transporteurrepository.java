package tn.applicationtrack.applicationpfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.applicationtrack.applicationpfe.entities.Transporteur;

public interface Transporteurrepository extends JpaRepository<Transporteur,Long> {
	Optional<Transporteur> findById(Long id);
}
