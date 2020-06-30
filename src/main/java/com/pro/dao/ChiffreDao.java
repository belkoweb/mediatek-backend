package com.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.Chiffre;

@Repository
public interface ChiffreDao extends JpaRepository<Chiffre, Long> {
    
	public Chiffre findByNumC(Long numC);
	public Chiffre findByNom(String nom);
}
