package com.pro.service;

import java.util.List;

import com.pro.model.Ligne_fact;


public interface Ligne_factService {
public List<Ligne_fact> findAll();
public void delete(Long id);
public void save(Ligne_fact ligne);

}
