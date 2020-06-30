package com.pro.model;

import java.util.Date;
import javax.persistence.Transient;

import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	@Temporal(TemporalType.TIME) // TIME au lieu de TIMESTEMP
	private Date date_naissance;
	private String tel;
	private String login;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	// Not persistent. There is no column on database table.
	@Transient
	private String token;
	@OneToMany(mappedBy = "client")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Facture> factures;
}
