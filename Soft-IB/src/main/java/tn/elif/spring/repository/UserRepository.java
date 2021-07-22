package tn.elif.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.elif.spring.Entitys.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
