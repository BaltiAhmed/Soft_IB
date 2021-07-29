package tn.elif.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import tn.elif.spring.Entitys.BonPlan;
import tn.elif.spring.Entitys.ClientMorale;
import tn.elif.spring.Entitys.ClientPhysique;
import tn.elif.spring.Entitys.Facture;
import tn.elif.spring.Exceptions.ResourceNotFoundException;
import tn.elif.spring.repository.BonPlanRepository;
import tn.elif.spring.repository.ClientMoraleRepository;
import tn.elif.spring.repository.ClientPhysiqueRepository;
import tn.elif.spring.repository.FactureRepository;
import tn.elif.spring.repository.ServiceRepository;

@Service
public class BonPlanImpl implements IBonPlan {
	
	@Autowired
	BonPlanRepository bonPlanrepo;
	@Autowired
	FactureRepository factureRepo;
	@Autowired
	ClientMoraleRepository clientM;
	@Autowired
	ClientPhysiqueRepository clientPhy;
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public BonPlan AddBonPlanClientMorale(BonPlan b, Long clientId, Long factureId) {
		try {
			ClientMorale client = clientM.findById(clientId).get();
			b.setClientMorale(client);
		} catch (Exception e) {
			throw new ResourceNotFoundException("client not found wih that id: " + clientId);
		}

		try {
			Facture facture = factureRepo.findById(factureId).get();
			b.setFacture(facture);
		} catch (Exception e) {
			throw new ResourceNotFoundException("facture not found wih that id: " + factureId);
		}

		try {
			return bonPlanrepo.save(b);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}
	}

	@Override
	public BonPlan AddBonPlanClientPhysique(BonPlan b, Long clientId, Long factureId) {
		try {
			ClientPhysique client = clientPhy.findById(clientId).get();
			b.setClientPhysique(client);
		} catch (Exception e) {
			throw new ResourceNotFoundException("client not found wih that id: " + clientId);
		}

		try {
			Facture facture = factureRepo.findById(factureId).get();
			b.setFacture(facture);
		} catch (Exception e) {
			throw new ResourceNotFoundException("facture not found wih that id: " + factureId);
		}

		try {
			return bonPlanrepo.save(b);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}
	}

	@Override
	public List<BonPlan> getBonPlanByClientMoraleId(Long clientId) {
		try {
			return bonPlanrepo.getBonPlanByClientMoraleId(clientId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}
	}

	@Override
	public List<BonPlan> getBonPlanByClientPhysiqueId(Long clientId) {
		try {
			return bonPlanrepo.getBonPlanByClientPhysiqueId(clientId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}
	}

	

}
