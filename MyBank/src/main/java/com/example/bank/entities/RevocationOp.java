package com.example.bank.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class RevocationOp extends Operation{

	public RevocationOp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RevocationOp(Date date_op, double amount, Account account_op) {
		super(date_op, amount, account_op);
		// TODO Auto-generated constructor stub
	}
	
	
}
