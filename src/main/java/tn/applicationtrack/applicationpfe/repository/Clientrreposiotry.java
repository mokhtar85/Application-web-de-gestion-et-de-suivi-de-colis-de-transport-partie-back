package tn.applicationtrack.applicationpfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.applicationtrack.applicationpfe.entities.Client;
@Repository
public interface Clientrreposiotry extends JpaRepository<Client, Long> {
	Boolean existsByEmail(String Email);
	@Query(value="select * from client c where c.user_name like :cle% ", nativeQuery = true)
	List<Client>  findAllClientbyuserName(@Param("cle") String cle);
	Client  findByUserName(String userName);
	Optional<Client> findById(Long id_user);
}
