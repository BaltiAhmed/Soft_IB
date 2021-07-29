package tn.elif.spring.Entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service")
public class Services implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String nom;
	
	private String description;
	
	private double prix;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JsonIgnore
	private Facture facture;
	
	@ManyToOne
	@JsonIgnore
	private ClientMorale clientMorale;

	@ManyToOne
	@JsonIgnore
	private ClientPhysique clientPhysique;

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Services(String nom, String description, double prix, Date date) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	

	public ClientMorale getClientMorale() {
		return clientMorale;
	}

	public void setClientMorale(ClientMorale clientMorale) {
		this.clientMorale = clientMorale;
	}

	public ClientPhysique getClientPhysique() {
		return clientPhysique;
	}

	public void setClientPhysique(ClientPhysique clientPhysique) {
		this.clientPhysique = clientPhysique;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", date="
				+ date + ", facture=" + facture + "]";
	}

	
	

}
