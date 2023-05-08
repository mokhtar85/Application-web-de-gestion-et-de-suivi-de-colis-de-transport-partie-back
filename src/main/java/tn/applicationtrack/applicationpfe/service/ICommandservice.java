package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import tn.applicationtrack.applicationpfe.entities.Command;

public interface ICommandservice {

	public Command addCommand(Command cmd);
	public List<Command> getAllCommands();
	public Command getCommandById(Long id);
	public Command updateCommand(Long id,Command updatedCommand);
	public Boolean deleteCommand(Long id);
	public Long getNumbercommand();
}
