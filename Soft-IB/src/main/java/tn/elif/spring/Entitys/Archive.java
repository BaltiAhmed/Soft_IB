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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "archiche")
public class Archive implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private Date date;
	
	@OneToOne
	private Compte compte;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="archive")
	private List<Transaction> transaction;

	public Archive() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Archive(Date date, Compte compte, List<Transaction> transaction) {
		super();
		this.date = date;
		this.compte = compte;
		this.transaction = transaction;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}


	@Override
	public String toString() {
		return "Archive [id=" + id + ", date=" + date + ", compte=" + compte + ", transaction=" + transaction + "]";
	}

	
	
	
	

}
