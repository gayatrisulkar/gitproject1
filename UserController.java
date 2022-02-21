package com.springbackend.Springbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbackend.Springbackend.model.Register;
import com.springbackend.Springbackend.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	//http://localhost:8080/api/v1/loginuser
	@PostMapping("/loginuser")
	public Register validateUser(@RequestBody Register register) 		
	{
		System.out.println("in controller ="+register.getEmail_id());
		Register u = userService.validateUser(register);
//		//if (u==null)
//		
//		return new ResponseEntity<>("Invalid credentials",HttpStatus.NOT_FOUND);
//			
//		else
//			return new ResponseEntity<>("Successful login", HttpStatus.OK);
		return u;
		
	}
}