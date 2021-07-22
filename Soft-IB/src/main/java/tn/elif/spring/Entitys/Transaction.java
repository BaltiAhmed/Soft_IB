package tn.elif.spring.Entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private TypeTransaction type;
	
	private Date date;
	
	private double balanceAvant;
	
	private double balanceApres;
	
	private int tansfertVers;
	
	@ManyToOne
	private Compte compte;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(TypeTransaction type, Date date, double balanceAvant, double balanceApres, int tansfertVers,
			Compte compte) {
		super();
		this.type = type;
		this.date = date;
		this.balanceAvant = balanceAvant;
		this.balanceApres = balanceApres;
		this.tansfertVers = tansfertVers;
		this.compte = compte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeTransaction getType() {
		return type;
	}

	public void setType(TypeTransaction type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getBalanceAvant() {
		return balanceAvant;
	}

	public void setBalanceAvant(double balanceAvant) {
		this.balanceAvant = balanceAvant;
	}

	public double getBalanceApres() {
		return balanceApres;
	}

	public void setBalanceApres(double balanceApres) {
		this.balanceApres = balanceApres;
	}

	public int getTansfertVers() {
		return tansfertVers;
	}

	public void setTansfertVers(int tansfertVers) {
		this.tansfertVers = tansfertVers;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", date=" + date + ", balanceAvant=" + balanceAvant
				+ ", balanceApres=" + balanceApres + ", tansfertVers=" + tansfertVers + ", compte=" + compte + "]";
	}
	
	
	
	

}
