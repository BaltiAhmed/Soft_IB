package tn.elif.spring.services;

import java.util.List;

import tn.elif.spring.Entitys.User;



public interface IUser {
	
	List<User> retrieveAllUsers();
	User addUser(User u);
	String deleteUser(Long id);
	User updateUser(User u);
	User retrieveUser(Long id);

}
