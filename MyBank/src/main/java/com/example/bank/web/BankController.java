package com.example.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bank.entities.Account;
import com.example.bank.entities.Operation;
import com.example.bank.metier.IBankMetier;

@Controller
public class BankController {
	@Autowired
	private IBankMetier banqueMetier;
	
	@RequestMapping("/accounts")
	public String index() {
		return "accounts";
	}
	
	@RequestMapping("/consultAccount")
	public String consult(Model model, String codeAc) {
		model.addAttribute("codeAc", codeAc);
		try {
			Account ac = banqueMetier.consultAccount(codeAc);
			Page<Operation> pagesOps = banqueMetier.listOpertionAccount(codeAc, 0, 4);
			model.addAttribute("listsOps", pagesOps.getContent());
			model.addAttribute("account", ac);
		}
		catch(Exception e) {
			model.addAttribute("exception", e);
		}
		return "accounts";
	}
}
