package com.example.bank.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;;

@Entity
public class Customer implements Serializable{
	
	@Id @GeneratedValue
	private Long code_cli;
	private String nom_cli;
	private String email_cli;
	@OneToMany(mappedBy="customer_ac", fetch=FetchType.LAZY)
	private Collection<Account> comptes_cli;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String nom_cli, String email_cli) {
		super();
		this.nom_cli = nom_cli;
		this.email_cli = email_cli;
	}

	public Long getCode_cli() {
		return code_cli;
	}

	public void setCode_cli(Long code_cli) {
		this.code_cli = code_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getEmail_cli() {
		return email_cli;
	}

	public void setEmail_cli(String email_cli) {
		this.email_cli = email_cli;
	}

	public Collection<Account> getComptes_cli() {
		return comptes_cli;
	}

	public void setComptes_cli(Collection<Account> comptes_cli) {
		this.comptes_cli = comptes_cli;
	}
	
	
	
}
