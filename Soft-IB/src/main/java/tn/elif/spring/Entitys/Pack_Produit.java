package tn.elif.spring.Entitys;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pack_produit")
public class Pack_Produit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String lib;
	private String description;
	
	@ManyToOne
	private Banque banque;

	public Pack_Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pack_Produit(String lib, String description, Banque banque) {
		super();
		this.lib = lib;
		this.description = description;
		this.banque = banque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@Override
	public String toString() {
		return "Pack_Produit [id=" + id + ", lib=" + lib + ", description=" + description + ", banque=" + banque + "]";
	}
	
	
	
	

}
