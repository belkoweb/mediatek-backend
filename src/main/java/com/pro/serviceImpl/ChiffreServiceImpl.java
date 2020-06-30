package com.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dao.ChiffreDao;
import com.pro.model.Chiffre;
import com.pro.service.ChiffreService;

@Service
public class ChiffreServiceImpl implements ChiffreService {
 @Autowired
 private ChiffreDao chiffreDao;


@Override
public List<Chiffre> findAll() {
	return chiffreDao.findAll();
}


@Override
public Chiffre findByNumC(Long numC) {
	return chiffreDao.findByNumC(numC);
}


@Override
public Chiffre findByNom(String nom) {
	return chiffreDao.findByNom(nom);
}





}
