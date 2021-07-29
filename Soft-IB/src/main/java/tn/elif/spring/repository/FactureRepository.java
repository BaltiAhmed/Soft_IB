package tn.elif.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.elif.spring.Entitys.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long> {
	

	@Query("select f from Facture f where f.compte.id=:compteId")
    public List<Facture> getAllFactureByCompteId(@Param("compteId")Long compteId);

}
