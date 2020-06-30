package com.pro.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.FactureDao;
import com.pro.dao.Ligne_factDao;
import com.pro.dao.ProduitDao;
import com.pro.model.Client;
import com.pro.model.Facture;
import com.pro.model.Ligne_fact;
import com.pro.model.Produit;
import com.pro.service.ClientService;
import com.pro.service.FactureService;


@Service
public class FactureServiceimpl implements FactureService {
	@Autowired
	private FactureDao factureDao;
	@Autowired
	private ClientService clientService;
	@Autowired
	private Ligne_factDao ligne_factDao;
	@Autowired
	private ProduitDao produitDao;

	@Override
	public Facture save(final Facture facture) {
		System.out.println("************************");
		System.out.println(facture);
		Client client = clientService.findById(facture.getClient().getId());
		facture.setDate_fact(LocalDateTime.now());
		factureDao.save(facture);
		if (client == null) {
			clientService.save(facture.getClient());
			client = facture.getClient();
		}
		if(facture.getLigne_factures() != null)
		{
			for (Ligne_fact ligne_fact : facture.getLigne_factures()) {
				Produit produit = produitDao.findBylibelle(ligne_fact.getProduit().getLibelle());
				if (produit == null) {
					produit = ligne_fact.getProduit();
					produitDao.save(produit);
				}
				ligne_fact.setProduit(produit);
				ligne_fact.setFacture(facture);
				ligne_factDao.save(ligne_fact);
			}
		} 
	
		facture.setClient(client);
		return factureDao.save(facture);
	}

	@Override
	public List<Facture> findAll() {
		return factureDao.findAll();
	}

	@Override
	@Transactional
	public void delete(final Long id) {
		Facture facture = factureDao.getOne(id);
		if (facture != null) {
			for (Ligne_fact ligne_fact : facture.getLigne_factures()) {
				ligne_factDao.deleteById(ligne_fact.getId());
			}
			factureDao.deleteById(id);
		}

	}

	@Override
	public Facture update(final Long id, final Facture facture) {
		facture.setNumero(id);
		return factureDao.save(facture);
	}

	@Override
	public Long numberOffactures() {
		return factureDao.count();
	}

}
