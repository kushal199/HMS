package com.kush.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.kush.modal.User;

import com.kush.repository.UserRepository;

@Service
@Transactional
public class UserService {
	



	private final UserRepository userRep;
	
	
	
	public UserService(UserRepository userRep) {
		//super();
		this.userRep = userRep;
		
	}
	
	
	
	public void saveUser(User user) {
		userRep.save(user);
		
	}
	
	public void check() {
		userRep.getUser().forEach(e->System.out.println(e));
	}
	
	public void inse() {
		userRep.insert();
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		return userRep.findByUsernameAndPassword(username, password);
	}

	
//	public List<User> showAllUsers(){
//		List<User> users = new ArrayList<User>();
//		for(User user : userRep.findAll()) {
//			users.add(user);
//		}
//		
//		return users;
//	}
	public List<User> showAllUsers(){
		List<User> users = new ArrayList<User>();
		userRep.getUser().forEach(e->System.out.println(e));
		for(User user : userRep.getUser()) {
			users.add(user);
		}
		return users;
	}
	
	public Optional<User> editUser(int doctor_id) {
		return userRep.findById(doctor_id);
	}
	
	public  void updateu(String username,String firstname, String lastname,String password,int doctor_id,String dob,int department_id,String address,String email,String active) {
		  userRep.update(username,firstname,lastname, password,doctor_id,dob,department_id,address,email,active);
	}
	
	public void deleteMyUser(int doctor_id) {
		userRep.deleteById(doctor_id);
	
	}
	
	
	
	
	
	
}
