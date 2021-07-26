package tn.elif.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {
	
	@Query("select c from Compte c where c.banque.id=:banqueId")
    public List<Compte> getCompteByBanqueId(@Param("banqueId")Long banqueId);
	
	@Query("select c from Compte c where c.clientMorale.id=:clientId and c.banque.id=:banqueId")
    public List<Compte> getCompteByClientMoraleId(@Param("clientId")Long clientId,@Param("banqueId")Long banqueId);
	
	@Query("select c from Compte c where c.clientPhysique.id=:clientId and c.banque.id=:banqueId")
    public List<Compte> getCompteByClientPhysiqueId(@Param("clientId")Long clientId,@Param("banqueId")Long banqueId);

}
