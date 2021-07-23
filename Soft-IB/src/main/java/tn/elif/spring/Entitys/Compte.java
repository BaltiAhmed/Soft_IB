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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "compte")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private Long rib;
	private int pin;
	private double balance;
	private Type type;
	private Etat etat;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@ManyToOne
	private ClientMorale clientMorale;

	@ManyToOne
	private ClientPhysique clientPhysique;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="compte")
	private List<Transaction> transaction;
	
	@ManyToOne
	private Banque banque;
	
	@OneToOne(mappedBy="compte")
	private Archive archive;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Compte(Long rib, int pin, double balance, Type type, Etat etat, Date dateCreation) {
		super();
		this.rib = rib;
		this.pin = pin;
		this.balance = balance;
		this.type = type;
		this.etat = etat;
		this.dateCreation = dateCreation;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRib() {
		return rib;
	}

	public void setRib(Long rib) {
		this.rib = rib;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", rib=" + rib + ", pin=" + pin + ", balance=" + balance + ", type=" + type
				+ ", etat=" + etat + ", dateCreation=" + dateCreation + ", clientMorale=" + clientMorale
				+ ", clientPhysique=" + clientPhysique + ", transaction=" + transaction + ", banque=" + banque
				+ ", archive=" + archive + "]";
	}
	
	

	
}
