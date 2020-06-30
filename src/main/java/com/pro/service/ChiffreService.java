package com.pro.service;

import java.util.List;

import com.pro.model.Chiffre;


public interface ChiffreService {
	public Chiffre findByNumC(Long numC);
	public List<Chiffre> findAll();
	public Chiffre findByNom(String nom);
}
