package tn.elif.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Long> {

}