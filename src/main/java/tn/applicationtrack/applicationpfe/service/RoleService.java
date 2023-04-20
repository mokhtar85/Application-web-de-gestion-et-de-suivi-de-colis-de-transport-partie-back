package tn.applicationtrack.applicationpfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.entities.Role;
import tn.applicationtrack.applicationpfe.repository.RoleRepository;
@Service
public class RoleService implements IRoleService{
	@Autowired
	RoleRepository Rolerep;
	@Override
	public Role adddRole(Role role) {
		// TODO Auto-generated method stub
		return Rolerep.save(role);
	}

}
