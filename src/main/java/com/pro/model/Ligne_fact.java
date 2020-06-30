package com.pro.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ligne_fact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JoinColumn(name="num_prod")
	@ManyToOne
	private Produit produit;
	@JoinColumn(name="num_fact")
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private Facture facture;
	private int quantite;
	private double total;
}
