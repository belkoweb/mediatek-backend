package com.pro.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Table(name = "v_chiffre_affaire")
public class Chiffre {
	@Id
	private Long id;
	@Column(name="num_cli")
	private Long numC;
	private String nom;
	private String prenom;
	private double ca;
	private String categorie;
}

