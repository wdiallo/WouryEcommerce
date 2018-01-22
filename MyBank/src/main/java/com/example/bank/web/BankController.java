package com.example.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String consult(Model model, String codeAc,
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="5")int size) {
		model.addAttribute("codeAc", codeAc);
		try {
			Account ac = banqueMetier.consultAccount(codeAc);
			Page<Operation> pagesOps = banqueMetier.listOpertionAccount(codeAc, page, size);
			model.addAttribute("listsOps", pagesOps.getContent());
			int[] pages = new int[pagesOps.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("account", ac);
		}
		catch(Exception e) {
			model.addAttribute("exception", e);
		}
		return "accounts";
	}
	
	@RequestMapping(value="/saveOperation", method=RequestMethod.POST)
	public String saveOperation(Model model, String typeOp, String codeAc, double amount, String codeAcAdd) {
		try {
			if(typeOp.equals("dep"))
				banqueMetier.deposit(codeAc, amount);
			else {
					if(typeOp.equals("revocat"))
					banqueMetier.revocation(codeAc, amount);
				else {
					if(typeOp.equals("transf"))
						banqueMetier.transfert(codeAc, codeAcAdd, amount);
				}
			}
		}
		catch(Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consultAccount?codeAc="+codeAc+"&error="+e.getMessage();
		}
		return "redirect:/consultAccount?codeAc="+codeAc;
	}
	
	//@RequestMapping("/consultAccount")
	//public String formE
}
