package tn.elif.spring.services;

import java.util.List;

import tn.elif.spring.Entitys.Services;

public interface IService {
	
	Services AddServiceClientMorale(Services s, Long clientId ,Long factureId);
	Services AddServiceClientPhysique(Services s, Long clientId ,Long factureId);
	List<Services> getServiceByClientMoraleId(Long clientId);
	List<Services> getServiceByClientPhysiqueId(Long clientId);
	String deleteService(Long id);

}
