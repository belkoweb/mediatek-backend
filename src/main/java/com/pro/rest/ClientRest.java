package com.pro.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.jwt.JwtTokenProvider;
import com.pro.model.Client;
import com.pro.model.Role;
import com.pro.service.ClientService;
import com.pro.service.FactureService;
import com.pro.service.ProduitService;


@RestController
public class ClientRest {
@Autowired
private ClientService clientService;
@Autowired
private JwtTokenProvider tokenProvider;
@Autowired
private ProduitService produitService;
@Autowired
private FactureService factureService;


@DeleteMapping("/api/user/id/{id}")
public void delete(@PathVariable Long id) {
	clientService.delete(id);
}
@PutMapping("/api/user/num/{id}")
public Client update(@PathVariable Long id,@RequestBody Client client) {
	return clientService.update(id, client);
}
@PostMapping("/api/user/")
public Client save(@RequestBody Client client) {
	return clientService.save(client);
}
@GetMapping("/api/user/nom/{nom}")
public Client findByNom(@PathVariable String nom) {
	return clientService.findByNom(nom);
}

@GetMapping("/api/user/id/{id}")
public Client findById(@PathVariable Long id) {
    return clientService.findById(id);
}




@GetMapping("/api/user/")
public List<Client> findAll() {
	return clientService.findAll();
}


@PostMapping("/api/user/registration")
public ResponseEntity<?> register(@RequestBody Client client){
    if(clientService.findByLogin(client.getLogin())!=null){
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    client.setRole(Role.USER);
    return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
}

@GetMapping("/api/user/login")
public ResponseEntity<?> getUser(Principal principal){
     if(principal == null){
        return ResponseEntity.ok(principal);
    }
    UsernamePasswordAuthenticationToken authenticationToken =
            (UsernamePasswordAuthenticationToken) principal;
    Client client = clientService.findByLogin(authenticationToken.getName());
    client.setToken(tokenProvider.generateToken(authenticationToken));

    return new ResponseEntity<>(client, HttpStatus.OK);
}

@GetMapping("/api/user/produits")
public ResponseEntity<?> getAllProducts(){
    return new ResponseEntity<>(produitService.findAll(), HttpStatus.OK);
}



}
