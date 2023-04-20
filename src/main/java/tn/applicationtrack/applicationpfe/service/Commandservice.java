package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.entities.Command;
import tn.applicationtrack.applicationpfe.repository.Commandrepository;
@Service
public class Commandservice implements ICommandservice {
	@Autowired
	Commandrepository cmdrep;
	public Command addCommand(Command cmd) {
		// TODO Auto-generated method stub
		return cmdrep.save(cmd);
	}
	@Override
	public List<Command> getAllCommands() {
		// TODO Auto-generated method stub
		return cmdrep.findAll();
	}

}
