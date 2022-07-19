package com.training.registrationap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.registrationap.model.User;
import com.training.registrationap.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		 return repo.save(user);
		
	}
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	public User fetchUserByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}
	public List<User> getallUsers(){
		List<User> users=repo.findAll();
		return users;
		
	}
	public Optional<User> getUserById(int id) {
		return repo.findById(id);
	}
	 public String deleteUserById(int id){
		 String result;
		 try {
			repo.deleteById(id);
			result="user deleted";
		} catch (Exception e) {
			// TODO: handle exception
			result="user by id not deleted";
		}
		 return result;
	 }

	 public User deActivateUser(Integer id) {
		 User user2 = this.repo.findById(id).orElse(null);
		user2.setStatus("inactive");
		User user = this.repo.save(user2);
		 return user;
	 }
	 
	 public String getStatus(String emailId) {
		 User user = this.repo.findByEmailId(emailId);
		 String status = user.getStatus();
		 return status;
	 }
	 
	 public User updateoneUser(User user,int id) {
		 User user2 = this.repo.findById(id).orElse(null);
		 user2.setEmailId(user.getEmailId());
		 user2.setFullName(user.getFullName());
		 User user3 = this.repo.save(user2);
		 return user3;
	 }
}
