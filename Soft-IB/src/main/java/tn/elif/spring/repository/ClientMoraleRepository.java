package tn.elif.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.ClientMorale;

@Repository
public interface ClientMoraleRepository extends CrudRepository<ClientMorale, Long> {

}
