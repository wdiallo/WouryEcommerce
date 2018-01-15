package com.example.bank.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bank.dao.AccountRepository;
import com.example.bank.dao.OperationRepository;
import com.example.bank.entities.Account;
import com.example.bank.entities.CurrentAccount;
import com.example.bank.entities.DepositOp;
import com.example.bank.entities.Operation;
import com.example.bank.entities.RevocationOp;

@Service
@Transactional
public class BankMetier implements IBankMetier{

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private OperationRepository operationRepo;
	@Override
	public Account consultAccount(String codeAc) {
		Account ac = accountRepo.findOne(codeAc);
		if(ac == null) throw new RuntimeException("Account not found");
		return ac;
	}

	@Override
	public void deposit(String codeAc, double amount) {
		Account ac = this.consultAccount(codeAc);
		DepositOp d = new DepositOp(new Date(), amount, ac);
		operationRepo.save(d);
		ac.setAmount_ac(ac.getAmount_ac() + amount);
		accountRepo.save(ac);
	}

	@Override
	public void revocation(String codeAc, double amount) {
		Account ac = this.consultAccount(codeAc);
		double accountOverdraft = 0;
		if(ac instanceof CurrentAccount)
			accountOverdraft = ((CurrentAccount) ac).getOverdraft();
		if(ac.getAmount_ac() + accountOverdraft < amount)
			throw new RuntimeException("Insufficient balance");
		
		RevocationOp r = new RevocationOp(new Date(), amount, ac);
		operationRepo.save(r);
		ac.setAmount_ac(ac.getAmount_ac() - amount);
		accountRepo.save(ac);
	}

	@Override
	public void transfert(String codeAcSub, String codeAcAdd, double amount) {
		this.revocation(codeAcSub, amount);
		this.deposit(codeAcAdd, amount);
	}

	@Override
	public Page<Operation> listOpertionAccount(String codeAc, int page, int size) {
		return operationRepo.listOperation(codeAc, new PageRequest(page, size));
	}

}
