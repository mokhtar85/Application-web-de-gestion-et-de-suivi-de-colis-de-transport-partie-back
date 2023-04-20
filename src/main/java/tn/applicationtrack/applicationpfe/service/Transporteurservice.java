package tn.applicationtrack.applicationpfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.entities.Transporteur;
import tn.applicationtrack.applicationpfe.repository.Transporteurrepository;
@Service

public class Transporteurservice implements ITransporteurService {
@Autowired
Transporteurrepository transporteurrep;

@Override
public Transporteur addTransporteur(Transporteur transporteur) {
	// TODO Auto-generated method stub
	return transporteurrep.save(transporteur);
}

@Override
public List<Transporteur> getAllTransporteur() {
	// TODO Auto-generated method stub
	return transporteurrep.findAll();
}


}
