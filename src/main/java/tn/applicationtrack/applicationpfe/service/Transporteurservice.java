package tn.applicationtrack.applicationpfe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.applicationtrack.applicationpfe.entities.Client;
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
public List<Transporteur> getAllTransporters() {
	// TODO Auto-generated method stub
	return transporteurrep.findAll();
}

public Transporteur getTransporteurById(Long id) {
	// TODO Auto-generated method stub
	Transporteur trans= transporteurrep.findById(id).get();
	return trans;
}

@Override
public Transporteur updateTrans(Long id, Transporteur updatedTrans) {
	// TODO Auto-generated method stub
	Optional<Transporteur> optionalUser = transporteurrep.findById(id);
    Transporteur user = optionalUser.get();
    user.setnImmatricualtion(updatedTrans.getnImmatricualtion());
    user.setFirstName(updatedTrans.getFirstName());
    user.setLastName(updatedTrans.getLastName());
    user.setUserName(updatedTrans.getUserName());
    user.setPhone(updatedTrans.getPhone());
    user.setCity(updatedTrans.getCity());
    user.setAdress(updatedTrans.getAdress());
    user.setPassword(updatedTrans.getPassword());
    user.setConfirmpassword(updatedTrans.getConfirmpassword());
    user.setEmail(updatedTrans.getEmail());
    user.setnImmatricualtion(updatedTrans.getnImmatricualtion());
    user.setCin(updatedTrans.getCin());
    return transporteurrep.save(user);}

@Override
public Boolean deleteTrans(Long id) {
	// TODO Auto-generated method stub
	if(transporteurrep.existsById(id)) {
	 transporteurrep.deleteById(id);
	return true;
	}
	else {
		return false;
	}
	
}


public Long getNombreTransporters() {
	// TODO Auto-generated method stub
	return transporteurrep.count();
}




}
