package tn.applicationtrack.applicationpfe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.applicationtrack.applicationpfe.entities.AffectationColis;
import tn.applicationtrack.applicationpfe.entities.Colis;
import tn.applicationtrack.applicationpfe.entities.Transporteur;

@Repository
public interface AffectationColisRepository extends JpaRepository<AffectationColis, Long> {

	@Query("SELECT ac FROM AffectationColis ac WHERE ac.transporteur.id_user = :transporteurId")
	public AffectationColis findAffectationColisByTransporteurId(@Param("transporteurId") Long transporteurId);
	 
	@Query("SELECT ac FROM AffectationColis ac JOIN ac.colisList c WHERE ac.transporteur.id_user = :transporteurId AND c.idCmd = :colisId")
	AffectationColis findByTransporteurIdAndColisListId(@Param("transporteurId") Long transporteurId, @Param("colisId") Long colisId);
	
	@Query("SELECT ac FROM AffectationColis ac JOIN ac.colisList c WHERE ac.transporteur = :transporteur AND c.acceptee = true")
    public List<AffectationColis> findByTransporteurAndColisList_AccepteeTrue(@Param("transporteur") Transporteur transporteur);
	@Query("SELECT ac FROM AffectationColis ac JOIN ac.colisList c WHERE ac.transporteur = :transporteur AND c.acceptee = false")
	public List<AffectationColis> findByTransporteurAndColisList_AccepteeFalse(Transporteur transporteur);


	
}
	



