package com.training.registrationap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.registrationap.model.User;
import com.training.registrationap.service.RegistrationService;

@RestController
@RequestMapping("/userdetails")
public class AdminController {
	
	@Autowired
	private RegistrationService service;
	
	@GetMapping("/users")
	@CrossOrigin(origins="http://localhost:4200")
	public List<User> getallUsers(){
		List<User> users = service.getallUsers();
		return users;
		
	}
	
	
	@GetMapping("/userbyId/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public User getUserById(@PathVariable int id){
		return service.getUserById(id).get();
		
	}
	
	@DeleteMapping("/deletebyId/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public String deleteUserById(@PathVariable int id) {
		
		return service.deleteUserById(id);
		
	}
	
	@GetMapping("/deactivate/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public User deactivateUserById(@PathVariable int id) {
		User user2 = this.service.deActivateUser(id);
		return user2;
		
	}
	
	@PutMapping("/updateuserById/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public User updateUserById(@RequestBody User user,@PathVariable int id) {
		User user2 = this.service.updateoneUser(user, id);
		return user2;
	}
}
