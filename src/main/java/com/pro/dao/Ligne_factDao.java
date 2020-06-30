package com.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.model.Ligne_fact;


public interface Ligne_factDao extends JpaRepository<Ligne_fact, Long> {

}
