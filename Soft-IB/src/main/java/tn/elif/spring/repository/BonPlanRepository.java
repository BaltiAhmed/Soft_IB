package tn.elif.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.BonPlan;

@Repository
public interface BonPlanRepository extends CrudRepository<BonPlan, Long> {
	
	@Query("select SUM(b.prix) from BonPlan b where b.facture.id=:factureId")
    public double getSommeTotal(@Param("factureId")Long factureId);
	
	@Query("select b from BonPlan b where b.clientMorale.id=:clientId")
    public List<BonPlan> getBonPlanByClientMoraleId(@Param("clientId")Long clientId);
	
	@Query("select b from BonPlan b where b.clientPhysique.id=:clientId")
    public List<BonPlan> getBonPlanByClientPhysiqueId(@Param("clientId")Long clientId);

}
