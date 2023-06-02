package tn.applicationtrack.applicationpfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.applicationtrack.applicationpfe.entities.Admin;

@Repository
public interface Adminrepository extends JpaRepository<Admin, Long> {
	public Optional<Admin> findByEmail(String email);

}
