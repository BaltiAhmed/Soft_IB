package tn.elif.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.ClientPhysique;

@Repository
public interface ClientPhysiqueRepository extends CrudRepository<ClientPhysique, Long> {

}
