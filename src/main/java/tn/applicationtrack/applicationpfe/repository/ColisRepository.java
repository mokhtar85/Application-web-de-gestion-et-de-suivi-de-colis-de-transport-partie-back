package tn.applicationtrack.applicationpfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.applicationtrack.applicationpfe.entities.Client;
import tn.applicationtrack.applicationpfe.entities.Colis;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {
	public List<Colis> findByClient(Client client);
	List<Colis> findByAccepteeTrue();
}
