package com.pro.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.ProduitDao;
import com.pro.model.Produit;
import com.pro.service.ProduitService;


@Service
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	private ProduitDao produitDao;

	@Override
	public Produit findBylibelle(final String libelle) {
		return produitDao.findBylibelle(libelle);
	}

	@Override
	public List<Produit> findAll() {
		return produitDao.findAll();
	}

	@Override
	public Produit save(final Produit produit) {
		Produit product = produitDao.findBylibelle(produit.getLibelle());
		if (product == null) {
			return produitDao.save(produit);
		}
		return null;

	}

	@Override
	@Transactional
	public void deleteBylibelle(String libelle) {
		Produit produit = findBylibelle(libelle);
		if (produit != null) {
			System.out.println("le produit" + produit);

			produitDao.deleteBylibelle(libelle);
		} else {
			System.out.println("le produit n'existe pas ");
		}

	}

	@Override
	public void delete(final Long id) {
		produitDao.deleteById(id);

	}

	@Override
	public Produit update(final Long id, final Produit produit) {
		produit.setNum_prod(id);
		return produitDao.save(produit);
	}

	@Override
	public String demande(final Long num_prod) {
		return produitDao.demande(num_prod);
	}

	@Override
	public Long numberOfProduits() {
		return produitDao.count();
	}
}
