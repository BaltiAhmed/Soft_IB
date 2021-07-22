package tn.elif.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.elif.spring.Entitys.User;
import tn.elif.spring.repository.UserRepository;

@Service
public class UserImpl implements IUser {
	
	@Autowired
	UserRepository userRep;

	@Override
	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRep.findAll();
	}

	@Override
	public User addUser(User u) {
		
		return userRep.save(u);
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRep.deleteById(id);
		return "deleted";	
	}

	@Override
	public User updateUser(User u) {
		
		return userRep.save(u);
	}

	@Override
	public User retrieveUser(Long id) {
		// TODO Auto-generated method stub
		return userRep.findById(id).get();
	}

}
