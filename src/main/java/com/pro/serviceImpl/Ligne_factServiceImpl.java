package com.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.Ligne_factDao;
import com.pro.model.Ligne_fact;
import com.pro.service.Ligne_factService;


@Service
public class Ligne_factServiceImpl implements Ligne_factService{
 
  @Autowired
  private Ligne_factDao ligne_factDao;

@Override
public List<Ligne_fact> findAll() {
	return ligne_factDao.findAll();
}

@Override
public void delete(Long id) {
	
}

@Override
public void save(Ligne_fact ligne) {
 ligne_factDao.save(ligne);
}
 
}
