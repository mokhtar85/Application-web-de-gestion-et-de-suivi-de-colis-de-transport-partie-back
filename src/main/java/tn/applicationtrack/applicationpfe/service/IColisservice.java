package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import tn.applicationtrack.applicationpfe.entities.Colis;

public interface IColisservice {

	public Colis addCommand(Colis cmd);
	public List<Colis> getColisByAuthClient();
	public List<Colis> getAllColis();
	public Colis getCommandById(Long id);
	public Colis updateCommand(Long id,Colis updatedCommand);
	public Boolean deleteCommand(Long id);
	public Long getNumbercommand();
	 public List<Colis> getColisAffectesAuTransporteurConnecte();
	 public Colis accepterCommande(Long id) ;
	 public List<Colis> getColisAcceptes();
}
