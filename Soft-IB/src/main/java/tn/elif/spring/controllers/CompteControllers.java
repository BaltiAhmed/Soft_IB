package tn.elif.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.elif.spring.Entitys.Compte;
import tn.elif.spring.services.CompteImpl;

@RestController	
@ComponentScan("tn.elif.spring.services")
public class CompteControllers {
	
	@Autowired
	CompteImpl compte;
	
	//@PostMapping("/ajoutCompte/{idBanque}")
	//public Compte ajoutCompte(@RequestBody Compte c, @PathVariable Long idBanque) {
		//try{
		//	return compte.addCompte(c, idBanque);
		//}catch (Exception e) {
			
		//}
		//return c;
		
	//}
	
	@GetMapping("/getAllCompte")
	public String getAllCompte() {
		return "fuck off";
	}

}
