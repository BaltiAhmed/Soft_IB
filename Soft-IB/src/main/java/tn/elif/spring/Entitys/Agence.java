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

@Entity
@Table(name = "Agence")
public class Agence implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String nom;
	
	private String email;
	
	private int tel;
	
	private String Adresse; 
	
	private String ville;
	
	private String region;
	
	private int codePostale;
	
	private String pays;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private Banque banque;

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agence(String nom, String email, int tel, String adresse, String ville, String region, int codePostale,
			String pays, Date date) {
		super();
		this.nom = nom;
		this.email = email;
		this.tel = tel;
		Adresse = adresse;
		this.ville = ville;
		this.region = region;
		this.codePostale = codePostale;
		this.pays = pays;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + ", email=" + email + ", tel=" + tel + ", Adresse=" + Adresse
				+ ", ville=" + ville + ", region=" + region + ", codePostale=" + codePostale + ", pays=" + pays
				+ ", date=" + date + ", banque=" + banque + "]";
	}
	
	

}
