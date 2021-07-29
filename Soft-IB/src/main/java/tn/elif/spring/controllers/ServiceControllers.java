package tn.elif.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.elif.spring.Entitys.Compte;
import tn.elif.spring.Entitys.Facture;
import tn.elif.spring.Entitys.Services;
import tn.elif.spring.services.IService;

@RestController
@ComponentScan("tn.elif.spring.services")
public class ServiceControllers {

	@Autowired
	IService service;

	@PostMapping("/ajoutServiceClientMorale/{factureId}/{clientId}")
	public Services ajoutServiceClientMorale(@RequestBody Services s, @PathVariable Long factureId,
			@PathVariable Long clientId) {
		return service.AddServiceClientMorale(s, clientId, factureId);
	}

	@PostMapping("/ajoutServiceClientPhysique/{factureId}/{clientId}")
	public Services ajoutServiceClientPhysique(@RequestBody Services s, @PathVariable Long factureId,
			@PathVariable Long clientId) {
		return service.AddServiceClientPhysique(s, clientId, factureId);
	}

	@GetMapping("/getServiceByClientMoraleId/{clientId}")
	public List<Services> getServiceByClientMoraleId(@PathVariable Long clientId) {
		return service.getServiceByClientMoraleId(clientId);
	}

	@GetMapping("/getServiceByClientPhysiqueId/{clientId}")
	public List<Services> getServiceByClientPhysiqueId(@PathVariable Long clientId) {
		return service.getServiceByClientPhysiqueId(clientId);
	}

	@DeleteMapping("/deleteService/{id}")
	public String deleteService(@PathVariable Long id) {
		return service.deleteService(id);

	}

}
