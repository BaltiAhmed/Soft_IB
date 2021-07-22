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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "banque")
public class Banque implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String nom;
	
	private String pdg;
	
	private double capital;
	
	private int effectif;
	
	private String filiale;
	
	private String SiegeSociale;
	
	private int tel;
	
	private String email;
	
	private String siteWeb;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="banque")
	private List<Compte> compte;
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="banque")
	private List<Agence> agence;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="banque")
	private List<Pack_Produit> produit;
	

	public Banque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Banque(String nom, String pdg, double capital, int effectif, String filiale, String siegeSociale, int tel,
			String email, String siteWeb, Date date, List<Compte> compte) {
		super();
		this.nom = nom;
		this.pdg = pdg;
		this.capital = capital;
		this.effectif = effectif;
		this.filiale = filiale;
		SiegeSociale = siegeSociale;
		this.tel = tel;
		this.email = email;
		this.siteWeb = siteWeb;
		this.date = date;
		this.compte = compte;
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

	public String getPdg() {
		return pdg;
	}

	public void setPdg(String pdg) {
		this.pdg = pdg;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}

	public String getFiliale() {
		return filiale;
	}

	public void setFiliale(String filiale) {
		this.filiale = filiale;
	}

	public String getSiegeSociale() {
		return SiegeSociale;
	}

	public void setSiegeSociale(String siegeSociale) {
		SiegeSociale = siegeSociale;
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

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Compte> getCompte() {
		return compte;
	}

	public void setCompte(List<Compte> compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", pdg=" + pdg + ", capital=" + capital + ", effectif=" + effectif
				+ ", filiale=" + filiale + ", SiegeSociale=" + SiegeSociale + ", tel=" + tel + ", email=" + email
				+ ", siteWeb=" + siteWeb + ", date=" + date + ", compte=" + compte + "]";
	}
	
	

}
