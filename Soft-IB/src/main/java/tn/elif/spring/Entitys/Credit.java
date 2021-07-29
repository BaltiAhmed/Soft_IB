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
	
	//@ManyToOne
	//private ClientMorale clientMorale;
	
	//@ManyToOne
	//private ClientPhysique clientPhysique;

	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	


}
