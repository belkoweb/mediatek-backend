package com.pro.model;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numero;
	private String ref;
    private LocalDateTime date_fact;
	@ManyToOne
	@JoinColumn(name="num_cli")
	private Client client;
	private String methodP;
	private double gtotal;
	private String deletedOrderItemIDs;
	@OneToMany(mappedBy = "facture")
	private List<Ligne_fact> ligne_factures;
}
