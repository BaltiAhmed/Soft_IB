package tn.elif.spring.services;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.elif.spring.Entitys.Banque;
import tn.elif.spring.Entitys.Compte;
import tn.elif.spring.Entitys.Facture;
import tn.elif.spring.Exceptions.ResourceNotFoundException;
import tn.elif.spring.repository.BonPlanRepository;
import tn.elif.spring.repository.CompteRepository;
import tn.elif.spring.repository.FactureRepository;
import tn.elif.spring.repository.ServiceRepository;

@Service
@EnableScheduling
public class FactureImpl implements IFacture {

	@Autowired
	FactureRepository factureRepo;
	@Autowired
	CompteRepository compteRepo;
	@Autowired
	ServiceRepository serviceRepo;
	@Autowired
	BonPlanRepository bonPlanRepo;
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public Facture AddFacture(Facture f, Long compteId) {
		try {
			Compte compte = compteRepo.findById(compteId).get();
			f.setCompte(compte);
		} catch (Exception e) {
			throw new ResourceNotFoundException("compte not found wih that id: " + compteId);
		}

		try {
			return factureRepo.save(f);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Problem while generating new facture pleasee try later !!");
		}

	}

	@Override
	public Facture getFactureById(Long facturId) {
		try {
			return factureRepo.findById(facturId).get();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Problem !!");
		}

	}

	@Override
	public List<Facture> getAllFactureByCompteId(Long compteId) {
		try {
			return factureRepo.getAllFactureByCompteId(compteId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Problem !!");
		}
	}

	@Override
	public Facture validerFactureService(Long factureId) {
		Facture facture;
		try {
			facture = factureRepo.findById(factureId).get();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Problem !!!!! !!");
		}

		double balance;
		balance = facture.getCompte().getBalance();

		facture.setMontant(serviceRepo.getSommeTotal(factureId));

		if (balance < facture.getMontant()) {
			throw new ResourceNotFoundException("balance insufisante");
		} else {
			facture.getCompte().setBalance(balance - facture.getMontant());
		}

		try {
			compteRepo.save(facture.getCompte());
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(facture.getCompte().getClientPhysique().getEmail());
			mail.setFrom("darragino1@gmail.com");
			mail.setSubject("Validation de payement.");
			mail.setText("Une Facture d'un mantant de " + facture.getMontant() + " est payee avec success!!!");
			javaMailSender.send(mail);
			return factureRepo.save(facture);
		} catch (Exception e) {
			throw new ResourceNotFoundException("failed while saving facture please try again !!");
		}
	}

	@Override
	public Facture validerFactureBonPlan(Long factureId) {
		Facture facture;
		try {
			facture = factureRepo.findById(factureId).get();
		} catch (Exception e) {
			throw new ResourceNotFoundException("Problem !!!!! !!");
		}

		double balance;
		balance = facture.getCompte().getBalance();

		facture.setMontant(bonPlanRepo.getSommeTotal(factureId));

		if (balance < facture.getMontant()) {
			throw new ResourceNotFoundException("balance insufisante");
		} else {
			facture.getCompte().setBalance(balance - facture.getMontant());
		}

		try {
			compteRepo.save(facture.getCompte());
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(facture.getCompte().getClientPhysique().getEmail());
			mail.setFrom("darragino1@gmail.com");
			mail.setSubject("Validation de payement.");
			mail.setText("Une Facture d'un mantant de " + facture.getMontant() + " est payee avec success!!!");
			javaMailSender.send(mail);
			return factureRepo.save(facture);
		} catch (Exception e) {
			throw new ResourceNotFoundException("failed while saving facture please try again !!");
		}
	}

	//@Scheduled(fixedDelay = 1000*60*60*24)
	@Scheduled(cron = "0 0 12 * * *")
	public void doSomething() {
		System.out.println("Schedule");
		Iterable<Facture> facture = factureRepo.findAll();
		for (Facture element : facture) {
			LocalDateTime toDay = LocalDateTime.now();  	
			System.out.println(toDay.getDayOfMonth());
			System.out.println(element.getDate().getDate());
			if (element.getMontant() != 0 && element.getDate().getDate() == toDay.getDayOfMonth()) {
				System.out.println(element.getDate().getDay());
				double balance;
				balance = element.getCompte().getBalance();
				if (balance > element.getMontant()) {
					try {
						element.getCompte().setBalance(balance - element.getMontant());
						compteRepo.save(element.getCompte());
						SimpleMailMessage mail = new SimpleMailMessage();
						mail.setTo(element.getCompte().getClientPhysique().getEmail());
						mail.setFrom("darragino1@gmail.com");
						mail.setSubject("Validation de payement.");
						mail.setText("Une Facture d'un mantant de " + element.getMontant() + " est payee avec success!!!");
						javaMailSender.send(mail);
						factureRepo.save(element);
					} catch (Exception e) {
						throw new ResourceNotFoundException("failed while saving facture please try again !!");
					}
				} else {
					SimpleMailMessage mail = new SimpleMailMessage();
					mail.setTo(element.getCompte().getClientPhysique().getEmail());
					mail.setFrom("darragino1@gmail.com");
					mail.setSubject("Balance insufisante.");
					mail.setText("Votre balance n'est pas suffisante pour payee la Facture d'un mantant de " + element.getMontant());
					javaMailSender.send(mail);
				}

			}
		}
	}

}
