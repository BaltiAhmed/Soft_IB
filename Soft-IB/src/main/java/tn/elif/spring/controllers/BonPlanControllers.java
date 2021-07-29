package tn.elif.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.elif.spring.Entitys.BonPlan;
import tn.elif.spring.Entitys.Services;
import tn.elif.spring.services.IBonPlan;

@RestController
@ComponentScan("tn.elif.spring.services")
public class BonPlanControllers {
	
	@Autowired
	IBonPlan bonPlan;
	
	@PostMapping("/ajoutBonPlanClientMorale/{factureId}/{clientId}")
	public BonPlan ajoutBonPlanClientMorale(@RequestBody BonPlan b, @PathVariable Long factureId,
			@PathVariable Long clientId) {
		return bonPlan.AddBonPlanClientMorale(b, clientId, factureId);
	}
	
	@PostMapping("/ajoutBonPlanClientPhysique/{factureId}/{clientId}")
	public BonPlan ajoutBonPlanClientPhysique(@RequestBody BonPlan b, @PathVariable Long factureId,
			@PathVariable Long clientId) {
		return bonPlan.AddBonPlanClientPhysique(b, clientId, factureId);
	}
	
	@GetMapping("/getBonPlanByClientMoraleId/{clientId}")
	public List<BonPlan> getBonPlanByClientMoraleId(@PathVariable Long clientId) {
		return bonPlan.getBonPlanByClientMoraleId(clientId);
	}
	
	
	@GetMapping("/getBonPlanByClientPhysiqueId/{clientId}")
	public List<BonPlan> getBonPlanByClientPhysiqueId(@PathVariable Long clientId) {
		return bonPlan.getBonPlanByClientPhysiqueId(clientId);
	}

}
