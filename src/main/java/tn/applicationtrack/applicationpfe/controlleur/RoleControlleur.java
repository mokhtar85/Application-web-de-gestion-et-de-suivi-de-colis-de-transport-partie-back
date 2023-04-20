package tn.applicationtrack.applicationpfe.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.applicationtrack.applicationpfe.entities.Role;
import tn.applicationtrack.applicationpfe.service.RoleService;

@RestController
public class RoleControlleur {
	@Autowired
	RoleService Roleserv;
@PostMapping(value="/addRole")
public Role addRole(@RequestBody Role role) {
	return Roleserv.adddRole(role);
	
}
}
