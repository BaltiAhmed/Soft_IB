package tn.elif.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.Banque;

@Repository
public interface BanqueRepository extends CrudRepository<Banque, Long> {

}
