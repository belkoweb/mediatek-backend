package com.pro.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.Client;


@Repository
public interface ClientDao  extends JpaRepository<Client,Long>{
	
	  public Client findByNom(String nom);
	  public Optional<Client>  findByLogin(String nom);

}
