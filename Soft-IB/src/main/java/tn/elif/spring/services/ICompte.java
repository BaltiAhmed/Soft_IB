package tn.elif.spring.services;

import java.util.List;

import tn.elif.spring.Entitys.Compte;


public interface ICompte {
	
	List<Compte> findAllCompte();
	List<Compte> findByUserId();
	List<Compte> findByBankId();
	Compte addCompte(Compte c,Long banqueId);
	String deleteCompte(Long id);
	Compte updateCompte(Compte c);
	Compte findCompte(Long id);

}
