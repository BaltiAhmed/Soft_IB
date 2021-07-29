package tn.elif.spring.Entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ch.qos.logback.core.net.server.Client;

@Entity
@Table(name = "facture")
public class Facture implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String titre;

	private double montant;

	private Date date;

	@ManyToOne
	@JsonIgnore
	private ClientPhysique clientPhysique;

	@ManyToOne
	@JsonIgnore
	private ClientMorale clientMorale;
	
	@ManyToOne
	@JsonIgnore
	private Compte compte;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	@JsonIgnore
	private List<Services> service;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	@JsonIgnore
	private List<BonPlan> bonPlan;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Facture(String titre, double montant, Date date) {
		super();
		this.titre = titre;
		this.montant = montant;
		this.date = date;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ClientPhysique getClientPhysique() {
		return clientPhysique;
	}

	public void setClientPhysique(ClientPhysique clientPhysique) {
		this.clientPhysique = clientPhysique;
	}

	public ClientMorale getClientMorale() {
		return clientMorale;
	}

	public void setClientMorale(ClientMorale clientMorale) {
		this.clientMorale = clientMorale;
	}
	
	

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Services> getService() {
		return service;
	}

	public void setService(List<Services> service) {
		this.service = service;
	}

	public List<BonPlan> getBonPlan() {
		return bonPlan;
	}

	public void setBonPlan(List<BonPlan> bonPlan) {
		this.bonPlan = bonPlan;
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", titre=" + titre + ", montant=" + montant + ", date=" + date
				+ ", clientPhysique=" + clientPhysique + ", clientMorale=" + clientMorale + "]";
	}

}
