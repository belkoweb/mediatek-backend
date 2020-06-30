package com.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.Audit_Stock;

@Repository
public interface Audit_StockDao extends JpaRepository<Audit_Stock,Long > {

}
