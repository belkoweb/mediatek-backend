package com.pro.service;

import java.util.List;
import java.util.Optional;

import com.pro.model.Client;


public interface ClientService {
	public Client findByNom(String nom);
	public Client findById(Long id);
	public List<Client> findAll();
	public Client save(Client client);
	public Client update(Long id,Client client);
	public void delete(Long id);
    public Client  findByLogin(String login);
    public Long numberOfClients();

}
