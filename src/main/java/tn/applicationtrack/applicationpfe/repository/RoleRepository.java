package tn.applicationtrack.applicationpfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.applicationtrack.applicationpfe.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
