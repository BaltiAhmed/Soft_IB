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
@Table(name = "client_morale")
public class ClientMorale extends User  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private Long idantifiatUnique;

	private String pdg;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientMorale")
	private List<Compte> compte;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="clientMorale")
	private List<Facture> facture;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="clientMorale")
	private List<Intervention> intervention;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="clientMorale")
	private List<Credit> credit;
	
	

	
	public ClientMorale() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ClientMorale(String nom, int tel, String email, String region, String adresse, String ville, int codePostal,
			String pays, String userName, String mdp, String nationalite) {
		super(nom, tel, email, region, adresse, ville, codePostal, pays, userName, mdp, nationalite);
		// TODO Auto-generated constructor stub
	}



	public ClientMorale(Long idantifiatUnique, String pdg, Date dateCreation) {
		super();
		this.idantifiatUnique = idantifiatUnique;
		this.pdg = pdg;
		this.dateCreation = dateCreation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdantifiatUnique() {
		return idantifiatUnique;
	}

	public void setIdantifiatUnique(Long idantifiatUnique) {
		this.idantifiatUnique = idantifiatUnique;
	}

	public String getPdg() {
		return pdg;
	}

	public void setPdg(String pdg) {
		this.pdg = pdg;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public ClientMorale(Long id, Long idantifiatUnique, String pdg, Date dateCreation) {
		super();
		this.id = id;
		this.idantifiatUnique = idantifiatUnique;
		this.pdg = pdg;
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "ClientMorale [id=" + id + ", idantifiatUnique=" + idantifiatUnique + ", pdg=" + pdg + ", dateCreation="
				+ dateCreation + "]";
	}
	
	
	
	

}
