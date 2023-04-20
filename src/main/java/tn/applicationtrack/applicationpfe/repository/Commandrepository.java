package tn.applicationtrack.applicationpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.applicationtrack.applicationpfe.entities.Command;

@Repository
public interface Commandrepository extends JpaRepository<Command, Long> {
}
