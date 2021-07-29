package tn.elif.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.elif.spring.Entitys.Compte;
import tn.elif.spring.Entitys.Facture;
import tn.elif.spring.services.IFacture;

@RestController
@ComponentScan("tn.elif.spring.services")
public class FactureControllers {
	
	@Autowired
	IFacture facture;
	
	@PostMapping("/ajoutFacture/{compteId}")
	public Facture ajoutFacture(@RequestBody Facture f, @PathVariable Long compteId) {
		return facture.AddFacture(f, compteId);
	}
	
	@PutMapping("/validerFactureService/{id}")
	public Facture validerFactureService(@PathVariable Long id) {
		return facture.validerFactureService(id);
	}
	
	@GetMapping("/getFactureById/{id}")
	public Facture getFactureById(@PathVariable Long id) {
		return facture.getFactureById(id);
	}
	
	@GetMapping("/getAllFactureByCompteId/{id}")
	public List<Facture> getAllFactureByCompteId(@PathVariable Long id) {
		return facture.getAllFactureByCompteId(id);
	}

}
