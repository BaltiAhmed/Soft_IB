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
	private ClientPhysique clientPhysique;

	@ManyToOne
	private ClientMorale clientMorale;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	private List<Service> service;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	private List<BonPlan> bonPlan;

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(String titre, double montant, Date date, ClientPhysique clientPhysique, ClientMorale clientMorale) {
		super();
		this.titre = titre;
		this.montant = montant;
		this.date = date;
		this.clientPhysique = clientPhysique;
		this.clientMorale = clientMorale;
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

	@Override
	public String toString() {
		return "Facture [id=" + id + ", titre=" + titre + ", montant=" + montant + ", date=" + date
				+ ", clientPhysique=" + clientPhysique + ", clientMorale=" + clientMorale + "]";
	}

}
