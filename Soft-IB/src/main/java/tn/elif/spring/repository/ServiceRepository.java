package tn.elif.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.Compte;
import tn.elif.spring.Entitys.Services;

@Repository
public interface ServiceRepository extends CrudRepository<Services, Long> {
	
	@Query("select SUM(s.prix) from Services s where s.facture.id=:factureId")
    public double getSommeTotal(@Param("factureId")Long factureId);
	
	@Query("select s from Services s where s.clientMorale.id=:clientId")
    public List<Services> getServiceByClientMoraleId(@Param("clientId")Long clientId);
	
	@Query("select s from Services s where s.clientPhysique.id=:clientId")
    public List<Services> getServiceByClientPhysiqueId(@Param("clientId")Long clientId);

}
