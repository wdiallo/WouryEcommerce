package com.example.bank.metier;

import org.springframework.data.domain.Page;

import com.example.bank.entities.Account;
import com.example.bank.entities.Operation;

public interface IBankMetier {
	
	public Account consultAccount(String codeAc);
	public void deposit(String codeAc, double amount);
	public void revocation(String codeAc, double amount);
	public void transfert(String codeAcSub, String codeAcAdd, double amount);
	public Page<Operation> listOpertionAccount(String codeAc, int page, int size);
	
	
}
