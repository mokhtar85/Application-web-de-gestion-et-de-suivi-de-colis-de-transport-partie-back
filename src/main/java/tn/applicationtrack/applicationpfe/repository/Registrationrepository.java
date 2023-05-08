package tn.applicationtrack.applicationpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.applicationtrack.applicationpfe.entities.Client;

public interface Registrationrepository extends JpaRepository<Client, Long> {

}
