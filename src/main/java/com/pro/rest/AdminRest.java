package com.pro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.Client;
import com.pro.model.Facture;
import com.pro.model.Produit;
import com.pro.model.StringResponse;
import com.pro.service.ClientService;
import com.pro.service.FactureService;
import com.pro.service.ProduitService;


@RestController
public class AdminRest {
	 @Autowired
	    private ClientService clientService;

	    @Autowired
	    private ProduitService produitService;

	    @Autowired
	    private FactureService factureService;

	    @PutMapping("/api/admin/client-update")
	    public ResponseEntity<?> updateClient(@RequestBody Client client) {
	        Client existClient =clientService.findByLogin(client.getLogin());
	        if (existClient != null && !existClient.getId().equals(client.getId())) {
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
	        return new ResponseEntity<>(clientService.update(client.getId(),client), HttpStatus.CREATED);
	    }

	    @PostMapping("/api/admin/client-delete")
	    public ResponseEntity<?> deleteClient(@RequestBody Client client){
	       clientService.delete(client.getId());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    @PostMapping("/api/admin/client-create")
	    public ResponseEntity<?> createClient(@RequestBody Client client){
	       return new ResponseEntity<>( clientService.save(client), HttpStatus.CREATED);
	    }


	    @GetMapping("/api/admin/client-all")
	    public ResponseEntity<?> findAllClients(){
	        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/client-number")
	    public ResponseEntity<?> numberOfClients(){
	        Long number =clientService.numberOfClients();
	        StringResponse response = new StringResponse();
	        response.setResponse(number.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	    @PostMapping("/api/admin/produit-create")
	    public ResponseEntity<?> createProduct(@RequestBody Produit produit){
	        return new ResponseEntity<>(produitService.save(produit), HttpStatus.CREATED);
	    }

	    @PutMapping("/api/admin/produit-update")
	    public ResponseEntity<?> updateProduit(@RequestBody Produit produit){
	        return new ResponseEntity<>(produitService.update(produit.getNum_prod(),produit), HttpStatus.CREATED);
	    }

	    @PostMapping("/api/admin/produit-delete")
	    public ResponseEntity<?> deleteProduit(@RequestBody Produit produit){
	        produitService.delete(produit.getNum_prod());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/produit-all")
	    public ResponseEntity<?> findAllProduits(){
	        return new ResponseEntity<>(produitService.findAll(), HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/produit-number")
	    public ResponseEntity<?> numberOfProduits(){
	        Long number = produitService.numberOfProduits();
	        StringResponse response = new StringResponse();
	        response.setResponse(number.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @GetMapping("/api/admin/commandes-all")
	    public ResponseEntity<?> findAllTransactions(){
	        return new ResponseEntity<>(factureService.findAll(), HttpStatus.OK);
	    }

	    @GetMapping("api/admin/commande-number")
	    public ResponseEntity<?> numberOfTransactions(){
	        Long number = factureService.numberOffactures();
	        StringResponse response = new StringResponse();
	        response.setResponse(number.toString());
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
	    @PostMapping("/api/admin/facture-delete")
	    public ResponseEntity<?> deleteFacture(@RequestBody Facture facture){
	        factureService.delete(facture.getNumero());
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	    
	    
	    @PutMapping("/api/admin/facture-update")
	    public ResponseEntity<?> updateProduit(@RequestBody Facture facture){
	        return new ResponseEntity<>(factureService.update(facture.getNumero(),facture), HttpStatus.CREATED);
	    }
}
