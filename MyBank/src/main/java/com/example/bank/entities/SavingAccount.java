package com.example.bank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SA")
public class SavingAccount extends Account{
	
	private double rateBank;

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(String code_ac, Date dateCreate_ac, double amount_ac, Customer customer_ac, double rateBank) {
		super(code_ac, dateCreate_ac, amount_ac, customer_ac);
		this.rateBank = rateBank;
	}

	public double getRateBank() {
		return rateBank;
	}

	public void setRateBank(double rateBank) {
		this.rateBank = rateBank;
	}
	
	
}
