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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "client_physique")
public class ClientPhysique extends User  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private TypePieceIdentite typePI;

	private String numPieceIdentite;

	private String penom;

	private Genre genre;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	private EtatCivile etatcivile;

	private Profession profession;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientPhysique")
	private List<Compte> compte;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientPhysique")
	private List<Facture> facture;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="clientPhysique")
	private List<Intervention> intervention;
	
	//@ManyToMany(cascade = CascadeType.ALL, mappedBy="clientPhysique")
	//private List<Credit> credit;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientPhysique")
	private List<Services> service;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientPhysique")
	private List<BonPlan> bonPlan;

	public ClientPhysique() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ClientPhysique(String nom, int tel, String email, String region, String adresse, String ville,
			int codePostal, String pays, String userName, String mdp, String nationalite) {
		super(nom, tel, email, region, adresse, ville, codePostal, pays, userName, mdp, nationalite);
		// TODO Auto-generated constructor stub
	}



	public ClientPhysique(TypePieceIdentite typePI, String numPieceIdentite, String penom, Genre genre,
			Date dateNaissance, EtatCivile etatcivile, Profession profession) {
		super();
		this.typePI = typePI;
		this.numPieceIdentite = numPieceIdentite;
		this.penom = penom;
		this.genre = genre;
		this.dateNaissance = dateNaissance;
		this.etatcivile = etatcivile;
		this.profession = profession;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypePieceIdentite getTypePI() {
		return typePI;
	}

	public void setTypePI(TypePieceIdentite typePI) {
		this.typePI = typePI;
	}

	public String getNumPieceIdentite() {
		return numPieceIdentite;
	}

	public void setNumPieceIdentite(String numPieceIdentite) {
		this.numPieceIdentite = numPieceIdentite;
	}

	public String getPenom() {
		return penom;
	}

	public void setPenom(String penom) {
		this.penom = penom;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public EtatCivile getEtatcivile() {
		return etatcivile;
	}

	public void setEtatcivile(EtatCivile etatcivile) {
		this.etatcivile = etatcivile;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "ClientPhysique [id=" + id + ", typePI=" + typePI + ", numPieceIdentite=" + numPieceIdentite + ", penom="
				+ penom + ", genre=" + genre + ", dateNaissance=" + dateNaissance + ", etatcivile=" + etatcivile
				+ ", profession=" + profession + "]";
	}
	
	

}
