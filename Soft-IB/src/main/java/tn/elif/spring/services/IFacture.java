package tn.elif.spring.services;

import java.util.List;

import tn.elif.spring.Entitys.Facture;

public interface IFacture {
	
	Facture AddFacture(Facture f, Long CompteId);
	Facture getFactureById(Long facturId);
	List<Facture> getAllFactureByCompteId(Long compteId);
	Facture validerFactureService(Long factureId);
	Facture validerFactureBonPlan(Long factureId);

}
