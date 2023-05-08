package tn.applicationtrack.applicationpfe.service;

import java.util.List;
import java.util.Optional;

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
	@Override
	public Command getCommandById(Long id) {
		// TODO Auto-generated method stub
		Command cmd = cmdrep.findById(id).get();
		return cmd;
	}
	@Override
	public Command updateCommand(Long id, Command updatedCommand) {
		// TODO Auto-generated method stub
		Optional<Command> optionalCmd = cmdrep.findById(id);
	      Command cmd = optionalCmd.get();
	      cmd.setWeight(updatedCommand.getWeight());
	      cmd.setType(updatedCommand.getType());
	      cmd.setSize(updatedCommand.getSize());
	      cmd.setDate(updatedCommand.getDate());
	      cmd.setCity(updatedCommand.getCity());
	      cmd.setDate(updatedCommand.getDate());
	      cmd.setPrice(updatedCommand.getPrice());
	      return cmdrep.save(cmd);
	}
	@Override
	public Boolean deleteCommand(Long id) {
		// TODO Auto-generated method stub
		String ch="";
		if(cmdrep.existsById(id)) {
		 cmdrep.deleteById(id);
		 return true;
		}
		else {
			 return false ;
		}
		
	}
	@Override
	public Long getNumbercommand() {
		// TODO Auto-generated method stub
		return cmdrep.count();
	}
	

}
