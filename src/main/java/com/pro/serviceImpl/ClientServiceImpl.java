package com.pro.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pro.dao.ClientDao;
import com.pro.model.Client;
import com.pro.service.ClientService;


@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDao clientDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public Client findByNom(final String nom) {
		return clientDao.findByNom(nom);
	}
	@Override
	public Client findById(final Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Override
	public Client save( final Client client) {
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		return clientDao.save(client);
	}

	@Override
	public Client update(Long id, Client client) {
		client.setId(id);

		return clientDao.save(client);

	}

	@Override
	@Transactional
	public void delete(final Long id) {
		 clientDao.deleteById(id);
	}

	@Override
	public Client findByLogin(final String login) {
		return clientDao.findByLogin(login).orElse(null);
	}

	@Override
	public Long numberOfClients() {
		return clientDao.count();
		
	}

}
