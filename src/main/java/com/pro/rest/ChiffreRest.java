package com.pro.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.Chiffre;
import com.pro.service.ChiffreService;


@RestController
@RequestMapping("mediatek-api/chiffre")
public class ChiffreRest {
@Autowired
private ChiffreService chiffreService;
@GetMapping("/nom/{nom}")
public Chiffre findByNom(@PathVariable String nom) {
	return chiffreService.findByNom(nom);
}
@GetMapping("/num/{numC}")
public Chiffre findByNumC(@PathVariable Long numC) {
	return chiffreService.findByNumC(numC);
}
@GetMapping("/")
public List<Chiffre> findAll() {
	return chiffreService.findAll();
}

}
