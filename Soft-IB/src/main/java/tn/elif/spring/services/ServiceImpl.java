package tn.elif.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elif.spring.Entitys.Banque;
import tn.elif.spring.Entitys.ClientMorale;
import tn.elif.spring.Entitys.ClientPhysique;
import tn.elif.spring.Entitys.Facture;
import tn.elif.spring.Entitys.Services;
import tn.elif.spring.Exceptions.ResourceNotFoundException;
import tn.elif.spring.repository.ClientMoraleRepository;
import tn.elif.spring.repository.ClientPhysiqueRepository;
import tn.elif.spring.repository.FactureRepository;
import tn.elif.spring.repository.ServiceRepository;

@Service
public class ServiceImpl implements IService {

	@Autowired
	ServiceRepository serviceRepo;
	@Autowired
	FactureRepository factureRepo;
	@Autowired
	ClientMoraleRepository clientM;
	@Autowired
	ClientPhysiqueRepository clientPhy;

	@Override
	public Services AddServiceClientMorale(Services s, Long clientId, Long factureId) {
		// TODO Auto-generated method stub
		try {
			ClientMorale client = clientM.findById(clientId).get();
			s.setClientMorale(client);
		} catch (Exception e) {
			throw new ResourceNotFoundException("client not found wih that id: " + clientId);
		}

		try {
			Facture facture = factureRepo.findById(factureId).get();
			s.setFacture(facture);
		} catch (Exception e) {
			throw new ResourceNotFoundException("facture not found wih that id: " + factureId);
		}

		try {
			return serviceRepo.save(s);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}

	}

	@Override
	public Services AddServiceClientPhysique(Services s, Long clientId, Long factureId) {
		try {
			ClientPhysique client = clientPhy.findById(clientId).get();
			s.setClientPhysique(client);
		} catch (Exception e) {
			throw new ResourceNotFoundException("client not found wih that id: " + clientId);
		}

		try {
			Facture facture = factureRepo.findById(factureId).get();
			s.setFacture(facture);
		} catch (Exception e) {
			throw new ResourceNotFoundException("facture not found wih that id: " + factureId);
		}

		try {
			return serviceRepo.save(s);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}
	}

	@Override
	public List<Services> getServiceByClientMoraleId(Long clientId) {
		try {
			return serviceRepo.getServiceByClientMoraleId(clientId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}

	}

	@Override
	public List<Services> getServiceByClientPhysiqueId(Long clientId) {
		try {
			return serviceRepo.getServiceByClientPhysiqueId(clientId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Error!!!!");
		}
	}

	@Override
	public String deleteService(Long id) {
		Services service;
		try{
			 service = serviceRepo.findById(id).get();
		}catch (Exception e) {
			throw new ResourceNotFoundException("problem !!!!");
		}
		
		try{
			serviceRepo.delete(service);
			return ("deleted");
		}catch (Exception e) {
			throw new ResourceNotFoundException("failed to delete !!!!");
		}
		
	}

}
