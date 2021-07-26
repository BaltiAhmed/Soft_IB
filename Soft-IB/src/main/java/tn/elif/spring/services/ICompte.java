package tn.elif.spring.services;

import java.util.List;

import tn.elif.spring.Entitys.Compte;


public interface ICompte {
	
	List<Compte> findAllCompte();
	List<Compte> findByUserId();
	List<Compte> findByBankId();
	Compte addCompteClientMorale(Compte c,Long banqueId,Long idClient);
	Compte addCompteClientPhysique(Compte c,Long banqueId,Long idClient);
	String deleteCompte(Long id);
	Compte updateCompte(Compte c);
	Compte findCompte(Long id);
	List<Compte> getCompteByBanqueId(Long idBanque);
	List<Compte> getCompteByClientMoraleId(Long clientId,Long idBanque);
	List<Compte> getCompteByClientPhysiqueId(Long clientId,Long idBanque);

}
