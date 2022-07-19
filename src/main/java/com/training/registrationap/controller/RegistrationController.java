package com.training.registrationap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.registrationap.model.ResponseInfo;
import com.training.registrationap.model.User;
import com.training.registrationap.service.RegistrationService;

@RestController
@RequestMapping("/pages")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public String registerUser(@Valid @RequestBody User user) throws Exception {
		try {
		String tempEmailId=user.getEmailId();
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			User userobj=service.fetchUserByEmailId(tempEmailId);
			if(userobj!=null) {
				System.out.println("User with "+tempEmailId+" is already exist");
			}
		}
		User userObj=null;
		userObj=service.saveUser(user);
		return "User saved";
		}catch(Exception e) {
			System.out.println(e);
		}
		return "user already exists";
	    
	}
	
    @PostMapping("/login")
    @CrossOrigin(origins="http://localhost:4200")
	public ResponseInfo loginUser(@Valid @RequestBody User user) throws Throwable {
    	String tempEmailId=user.getEmailId();
    	String tempPass=user.getPassword();
    	String tempStatus=this.service.getStatus(tempEmailId);
    	User userObj=null;
    	ResponseInfo ri=null;
    	if(tempEmailId !=null && tempPass !=null && tempStatus.equals("active")) {
    		userObj=service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
    		ri=new ResponseInfo("You have logged in successfully","You are active.");
    	}else {
    	try {
    	if(userObj == null) {
    		System.out.println("bad Credentials");
    		ri = new ResponseInfo("You entered bad Credentials","You are inactive | User not registered");
    	}}
    	catch(Exception e){
    		System.out.println(e);
    		
    	}
    	}
    	return ri;
    }
    

}
