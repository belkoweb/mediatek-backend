package com.pro.service;

import java.util.List;

import com.pro.model.Facture;


public interface FactureService {
  public Facture save(Facture facture);
  public List<Facture> findAll();
  public void delete(Long id);
  public Facture update(Long id,Facture facture);
  Long numberOffactures();

 }
