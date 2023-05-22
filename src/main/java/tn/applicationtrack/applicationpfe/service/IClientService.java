package tn.applicationtrack.applicationpfe.service;

import java.util.List;
import java.util.Optional;

import tn.applicationtrack.applicationpfe.entities.Client;

public interface IClientService {
/*public Client addClient(Client client,Long idRole);*/
public Client addClientWithoutRole(Client client);
public Client addClientWithTestmail(Client client);
public String addClientWithTestpassword(Client client);
public Boolean deleteUser(Long idUser);
public List<Client> findAllClientbyuserName(String userName);
public List<Client> getAllClients();
public Client getClientById(Long id);
public Client updateUser(Long idUser, Client updatedUser);
public Long getNombreClients();
/*public Client fetchClientByEmailId(String email);*/
public Client fetchClientByEmailIdAndPassword(String email,String password);
}