package tn.elif.spring.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import tn.elif.spring.Entitys.Banque;
import tn.elif.spring.Entitys.ClientMorale;
import tn.elif.spring.Entitys.Compte;
import tn.elif.spring.Entitys.Etat;
import tn.elif.spring.Exceptions.ResourceNotFoundException;
import tn.elif.spring.repository.BanqueRepository;
import tn.elif.spring.repository.ClientMoraleRepository;
import tn.elif.spring.repository.ClientPhysiqueRepository;
import tn.elif.spring.repository.CompteRepository;

@Service
public class CompteImpl implements ICompte {

	@Autowired
	CompteRepository compteRepo;
	@Autowired
	BanqueRepository banqueRepo;
	@Autowired
	ClientMoraleRepository clientMorale;
	@Autowired
	ClientPhysiqueRepository clientPhysique;

	@Override
	public List<Compte> findAllCompte() {
		// TODO Auto-generated method stub
		return (List<Compte>) compteRepo.findAll();
	}

	@Override
	public List<Compte> findByUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Compte addCompteClientMorale(Compte c, Long banqueId, Long idClient) {
		try {
			Banque banque = banqueRepo.findById(banqueId).get();
			c.setBanque(banque);
		} catch (Exception e) {
			throw new ResourceNotFoundException("bank not found wih that id: " + banqueId);
		}
		try {
			ClientMorale clientM = clientMorale.findById(idClient).get();
			c.setClientMorale(clientM);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Client not found wih that id: " + banqueId);
		}
		Random rd = new Random();
		c.setRib(Math.abs(rd.nextLong()));
		c.setEtat(Etat.OUVERT);
		c.setBalance(0.0);
		return compteRepo.save(c);

	}

	@Override
	public Compte addCompteClientPhysique(Compte c, Long banqueId, Long idClient) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public List<Compte> getCompteByBanqueId(Long idBanque) {
		// TODO Auto-generated method stub
		if(compteRepo.getCompteByBanqueId(idBanque).size()==0){
			throw new ResourceNotFoundException("there is no item");
		}
		return compteRepo.getCompteByBanqueId(idBanque);
	}

	@Override
	public List<Compte> getCompteByClientMoraleId(Long clientId, Long idBanque) {
		// TODO Auto-generated method stub
		if(compteRepo.getCompteByClientMoraleId(clientId, idBanque).size()==0){
			throw new ResourceNotFoundException("there is no item");
		}
		return compteRepo.getCompteByClientMoraleId(clientId, idBanque);
	}

	@Override
	public List<Compte> getCompteByClientPhysiqueId(Long clientId, Long idBanque) {
		// TODO Auto-generated method stub
		if(compteRepo.getCompteByClientPhysiqueId(clientId, idBanque).size()==0){
			throw new ResourceNotFoundException("there is no item");
		}
		
		return compteRepo.getCompteByClientPhysiqueId(clientId, idBanque);
	}

}
