package tn.elif.spring.Entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "intervention")
public class Intervention implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private TypeIntervention type;
	
	private Date date;
	
	private String description;
	
	@ManyToMany
	private List<ClientMorale> clientMorale;
	
	@ManyToMany
	private List<ClientPhysique> clientPhysique;

}
