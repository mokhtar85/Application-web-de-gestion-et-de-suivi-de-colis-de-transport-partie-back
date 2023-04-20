package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import tn.applicationtrack.applicationpfe.entities.Command;

public interface ICommandservice {

	public Command addCommand(Command cmd);
	public List<Command> getAllCommands();
}
