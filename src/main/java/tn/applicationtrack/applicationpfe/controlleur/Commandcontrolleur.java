package tn.applicationtrack.applicationpfe.controlleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@GetMapping(value="getCmdById/{id}")
public Command getCmdById(@PathVariable(name="id") Long id) {
	return Commandserv.getCommandById(id);
}
@PutMapping(value="/updateCommand/{id}")
public Command updateCommand(@PathVariable(name="id") Long id, @RequestBody Command updatedCommand) {
	return  Commandserv.updateCommand(id,updatedCommand);
 
}
@DeleteMapping(value="/deleteCmd/{id}")
public ResponseEntity<Long> deletemd(@PathVariable(name= "id") Long id) {
	Boolean cmdDeleted = Commandserv.deleteCommand(id);
	if(cmdDeleted) {
		return ResponseEntity.ok().body(id);
	}
	else {
		return ResponseEntity.badRequest().body(id);
	}

}
@GetMapping("/numbercommands")
public ResponseEntity<Long> getNumbreCommands() {
       long numbercommands = Commandserv.getNumbercommand();
       return ResponseEntity.ok().body(numbercommands);
   }
}
