package com.example.bank.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_account", discriminatorType=DiscriminatorType.STRING, length=2)
public abstract class Account implements Serializable{
	
	@Id
	private String code_ac;
	private Date dateCreate_ac;
	private double amount_ac;
	@ManyToOne
	@JoinColumn(name="customerAc_Id")
	private Customer customer_ac;
	@OneToMany(mappedBy="account_op", fetch=FetchType.LAZY)
	private Collection<Operation> operations_ac;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String code_ac, Date dateCreate_ac, double amount_ac, Customer customer_ac) {
		super();
		this.code_ac = code_ac;
		this.dateCreate_ac = dateCreate_ac;
		this.amount_ac = amount_ac;
		this.customer_ac = customer_ac;
	}
	
	public String getCode_ac() {
		return code_ac;
	}
	public void setCode_ac(String code_ac) {
		this.code_ac = code_ac;
	}
	public Date getDateCreate_ac() {
		return dateCreate_ac;
	}
	public void setDateCreate_ac(Date dateCreate_ac) {
		this.dateCreate_ac = dateCreate_ac;
	}
	public double getAmount_ac() {
		return amount_ac;
	}
	public void setAmount_ac(double amount_ac) {
		this.amount_ac = amount_ac;
	}
	public Customer getCustomer_ac() {
		return customer_ac;
	}
	public void setCustomer_ac(Customer customer_ac) {
		this.customer_ac = customer_ac;
	}
	public Collection<Operation> getOperations_ac() {
		return operations_ac;
	}
	public void setOperations_ac(Collection<Operation> operations_ac) {
		this.operations_ac = operations_ac;
	}

	
	
	
}
