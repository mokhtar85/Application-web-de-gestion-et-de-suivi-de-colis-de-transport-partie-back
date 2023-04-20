package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import tn.applicationtrack.applicationpfe.entities.Transporteur;

public interface ITransporteurService {

	public Transporteur addTransporteur(Transporteur transporteur);
	public List<Transporteur> getAllTransporteur();
}
