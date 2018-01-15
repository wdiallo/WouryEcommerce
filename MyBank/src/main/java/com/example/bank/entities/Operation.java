package com.example.bank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_operation", discriminatorType=DiscriminatorType.STRING, length=1)
public abstract class Operation implements Serializable{
	
	@Id @GeneratedValue
	private Long number_op;
	private Date date_op;
	private double amount; 
	@ManyToOne
	@JoinColumn(name="accountOp_Id")
	private Account account_op;
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Operation(Date date_op, double amount, Account account_op) {
		super();
		this.date_op = date_op;
		this.amount = amount;
		this.account_op = account_op;
	}

	public Long getNumber_op() {
		return number_op;
	}

	public void setNumber_op(Long number_op) {
		this.number_op = number_op;
	}

	public Date getDate_op() {
		return date_op;
	}

	public void setDate_op(Date date_op) {
		this.date_op = date_op;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount_op() {
		return account_op;
	}

	public void setAccount_op(Account account_op) {
		this.account_op = account_op;
	}
	
	
}
