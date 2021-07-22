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

@Entity
@Table(name = "credit")
public class Credit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private TypeCredit type;
	
	private EtatCredit etat;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	private String duree;
	
	private double montantTotal;
	
	private double montantMonsuel;
	
	private double monatntRestant;
	
	private boolean isValid;
	
	private String description;
	
	@ManyToOne
	private ClientMorale clientMorale;
	
	@ManyToOne
	private ClientPhysique clientPhysique;

	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credit(TypeCredit type, EtatCredit etat, Date dateDebut, Date dateFin, String duree, double montantTotal,
			double montantMonsuel, double monatntRestant, boolean isValid, String description,
			ClientMorale clientMorale, ClientPhysique clientPhysique) {
		super();
		this.type = type;
		this.etat = etat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.duree = duree;
		this.montantTotal = montantTotal;
		this.montantMonsuel = montantMonsuel;
		this.monatntRestant = monatntRestant;
		this.isValid = isValid;
		this.description = description;
		this.clientMorale = clientMorale;
		this.clientPhysique = clientPhysique;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeCredit getType() {
		return type;
	}

	public void setType(TypeCredit type) {
		this.type = type;
	}

	public EtatCredit getEtat() {
		return etat;
	}

	public void setEtat(EtatCredit etat) {
		this.etat = etat;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public double getMontantMonsuel() {
		return montantMonsuel;
	}

	public void setMontantMonsuel(double montantMonsuel) {
		this.montantMonsuel = montantMonsuel;
	}

	public double getMonatntRestant() {
		return monatntRestant;
	}

	public void setMonatntRestant(double monatntRestant) {
		this.monatntRestant = monatntRestant;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Credit [id=" + id + ", type=" + type + ", etat=" + etat + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", duree=" + duree + ", montantTotal=" + montantTotal + ", montantMonsuel=" + montantMonsuel
				+ ", monatntRestant=" + monatntRestant + ", isValid=" + isValid + ", description=" + description
				+ ", clientMorale=" + clientMorale + ", clientPhysique=" + clientPhysique + "]";
	}

	
	
	


}
