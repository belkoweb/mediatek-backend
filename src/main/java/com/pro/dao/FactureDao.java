package com.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.Facture;


@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {
}
