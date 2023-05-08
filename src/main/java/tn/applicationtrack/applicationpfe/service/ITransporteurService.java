package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import tn.applicationtrack.applicationpfe.entities.Transporteur;

public interface ITransporteurService {

	public Transporteur addTransporteur(Transporteur transporteur);
	public List<Transporteur> getAllTransporters();
	public Transporteur getTransporteurById(Long id);
	public Transporteur updateTrans(Long id,Transporteur updatedTrans);
	public Boolean deleteTrans(Long id);
	public Long getNombreTransporters();
}

