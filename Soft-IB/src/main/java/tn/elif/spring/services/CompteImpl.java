package tn.elif.spring.services;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elif.spring.Entitys.Banque;
import tn.elif.spring.Entitys.Compte;
import tn.elif.spring.repository.BanqueRepository;
import tn.elif.spring.repository.CompteRepository;


@Service
public class CompteImpl implements ICompte {
	
	@Autowired
	CompteRepository compteRepo;
	@Autowired
	BanqueRepository banqueRepo;

	@Override
	public List<Compte> findAllCompte() {
		// TODO Auto-generated method stub
		return (List<Compte>)compteRepo.findAll();
	}

	@Override
	public List<Compte> findByUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Compte addCompte(Compte c,Long banqueId) {
		Banque banque = banqueRepo.findById(banqueId).get();
		c.setBanque(banque);
		return compteRepo.save(c);
	}

	@Override
	public String deleteCompte(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte updateCompte(Compte c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte findCompte(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findByBankId() {
		// TODO Auto-generated method stub
		return null;
	}

}
