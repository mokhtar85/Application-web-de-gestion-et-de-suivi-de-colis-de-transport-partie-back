package tn.applicationtrack.applicationpfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import tn.applicationtrack.applicationpfe.entities.Command;
import tn.applicationtrack.applicationpfe.service.Commandservice;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class Commandcontrolleur {
	@Autowired 
	Commandservice Commandserv; 
@PostMapping(value="/addCommand")
public Command addCommand (@RequestBody Command cmd) {
	return Commandserv.addCommand(cmd);
}
@GetMapping(value="getAllCommands")
public List<Command> getAllCommands() 
{ return Commandserv.getAllCommands();}
}
