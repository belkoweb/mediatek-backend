package com.pro.service;

import java.util.List;

import com.pro.model.Produit;

public interface ProduitService{
	  public Produit findBylibelle(String libelle);
	  public List<Produit> findAll();
	  public Produit save(Produit produit);
	  public void deleteBylibelle(String libelle);
	  public void delete(Long id);
	  public Produit update(Long id , Produit produit);
	  public String demande(Long num_prod);
	  Long numberOfProduits();
}
