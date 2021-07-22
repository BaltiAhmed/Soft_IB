package tn.elif.spring.Entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employer")
public class Employer extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String CIN;
	
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissnace;
	
	private Poste poste;
	
	private Contrat contrat;
	
	private double salaire;

	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Employer(String nom, int tel, String email, String region, String adresse, String ville, int codePostal,
			String pays, String userName, String mdp, String nationalite) {
		super(nom, tel, email, region, adresse, ville, codePostal, pays, userName, mdp, nationalite);
		// TODO Auto-generated constructor stub
	}



	public Employer(String cIN, String prenom, Date dateNaissnace, Poste poste, Contrat contrat, double salaire) {
		super();
		CIN = cIN;
		this.prenom = prenom;
		this.dateNaissnace = dateNaissnace;
		this.poste = poste;
		this.contrat = contrat;
		this.salaire = salaire;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissnace() {
		return dateNaissnace;
	}

	public void setDateNaissnace(Date dateNaissnace) {
		this.dateNaissnace = dateNaissnace;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", CIN=" + CIN + ", prenom=" + prenom + ", dateNaissnace=" + dateNaissnace
				+ ", poste=" + poste + ", contrat=" + contrat + ", salaire=" + salaire + "]";
	}
	
	
	
	


}
