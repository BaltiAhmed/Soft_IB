package tn.elif.spring.Entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;

	protected String nom;
	
	protected int tel;

	protected String email;

	protected String region;

	protected String adresse;

	protected String ville;

	protected int codePostal;

	protected String pays;

	protected String userName;

	protected String mdp;
	
	protected String nationalite;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String nom, int tel, String email, String region, String adresse, String ville, int codePostal,
			String pays, String userName, String mdp, String nationalite) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.email = email;
		this.region = region;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.pays = pays;
		this.userName = userName;
		this.mdp = mdp;
		this.nationalite = nationalite;
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", tel=" + tel + ", email=" + email + ", region=" + region
				+ ", adresse=" + adresse + ", ville=" + ville + ", codePostal=" + codePostal + ", pays=" + pays
				+ ", userName=" + userName + ", mdp=" + mdp + ", nationalite=" + nationalite + "]";
	}

	
	
	
	
	
	
	

}
