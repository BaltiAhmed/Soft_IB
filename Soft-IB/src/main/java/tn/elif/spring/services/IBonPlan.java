package tn.elif.spring.services;

import java.util.List;

import tn.elif.spring.Entitys.BonPlan;


public interface IBonPlan {
	
	BonPlan AddBonPlanClientMorale(BonPlan b, Long clientId ,Long factureId);
	BonPlan AddBonPlanClientPhysique(BonPlan b, Long clientId ,Long factureId);
	List<BonPlan> getBonPlanByClientMoraleId(Long clientId);
	List<BonPlan> getBonPlanByClientPhysiqueId(Long clientId);
	
}
