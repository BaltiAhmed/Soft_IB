package tn.elif.spring.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.elif.spring.services.CompteImpl;
import tn.elif.spring.services.ICompte;
import tn.elif.spring.Entitys.Compte;


@RestController
@ComponentScan("tn.elif.spring.services")
public class CompteControllers {

	@Autowired
	ICompte compte;

	@PostMapping("/ajoutCompteClientMorale/{idBanque}/{idClient}")
	public Compte ajoutCompteClientMorale(@RequestBody Compte c, @PathVariable Long idBanque, @PathVariable Long idClient) {
		return compte.addCompteClientMorale(c, idBanque,idClient);
	}
	
	@PostMapping("/ajoutCompteClientPhysique/{idBanque}/{idClient}")
	public Compte ajoutCompteClientPhysique(@RequestBody Compte c, @PathVariable Long idBanque, @PathVariable Long idClient) {
		return compte.addCompteClientPhysique(c, idBanque, idClient);
	}

	@GetMapping("/getAllCompte")
	public List<Compte> getAllCompte() {
		return compte.findAllCompte();
	}
	
	@GetMapping("/getCompteByBanqueId/{banqueId}")
	public List<Compte> getCompteByBanqueId(@PathVariable Long banqueId) {
		return compte.getCompteByBanqueId(banqueId);
	}
	
	@GetMapping("/getCompteByClientMoraleId/{clientId}/{banqueId}")
	public List<Compte> getCompteByClientMoraleId(@PathVariable Long clientId,@PathVariable Long banqueId) {
		return compte.getCompteByClientMoraleId(clientId,banqueId);
	}
	
	@GetMapping("/getCompteByClientPhysiqueId/{clientId}/{banqueId}")
	public List<Compte> getCompteByClientPhysiqueId(@PathVariable Long clientId,@PathVariable Long banqueId) {
		return compte.getCompteByClientPhysiqueId(clientId,banqueId);
	}
	
	@PutMapping("/fermerCompte/{id}")
	public Compte fermerCompte(@PathVariable Long id) {
		return compte.FermerCompte(id);
	}
	
	@PutMapping("/bloquerCompte/{id}")
	public Compte bloquerCompte(@PathVariable Long id) {
		return compte.BloquerCompte(id);
	}

}
