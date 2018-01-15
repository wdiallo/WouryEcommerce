package com.example.bank;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.bank.dao.AccountRepository;
import com.example.bank.dao.CustomerRepository;
import com.example.bank.dao.OperationRepository;
import com.example.bank.entities.Account;
import com.example.bank.entities.CurrentAccount;
import com.example.bank.entities.Customer;
import com.example.bank.entities.DepositOp;
import com.example.bank.entities.Operation;
import com.example.bank.entities.RevocationOp;
import com.example.bank.entities.SavingAccount;
import com.example.bank.metier.IBankMetier;

@SpringBootApplication
public class MyBankApplication implements CommandLineRunner{
	@Autowired
	private CustomerRepository customRepo;
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private OperationRepository operationRepo;
	@Autowired
	private IBankMetier bankMetier;
	
	public static void main(String[] args) {
		 SpringApplication.run(MyBankApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*Customer cli1 = customRepo.save(new Customer("Alpha Baldé", "alpha@gmail.com"));
		Customer cli2 = customRepo.save(new Customer("Anne Dupont", "anne@gmail.com"));
		
		Account ac1 = accountRepo.save(new CurrentAccount("c1", new Date(), 90000, cli1, 6000));
		Account ac2 = accountRepo.save(new SavingAccount("c2", new Date(), 6000, cli2, 5.5));
		
		operationRepo.save(new DepositOp(new Date(), 9000, ac1));
		operationRepo.save(new DepositOp(new Date(), 6000, ac1));
		operationRepo.save(new DepositOp(new Date(), 2300, ac1));
		operationRepo.save(new RevocationOp(new Date(), 9000, ac1));
		
		operationRepo.save(new DepositOp(new Date(), 2300, ac2));
		operationRepo.save(new DepositOp(new Date(), 400, ac2));
		operationRepo.save(new DepositOp(new Date(), 2300, ac2));
		operationRepo.save(new RevocationOp(new Date(), 3000, ac2));
		
		bankMetier.deposit("c1", 111111);*/
		
	}
}
