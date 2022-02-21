package com.springbackend.Springbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.Springbackend.dao.UserRepository;
import com.springbackend.Springbackend.model.Register;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Register validateUser(Register register) {
		Register u=userRepository.validateUser(register.getEmail_id(),register.getPassword());
		
		return u;
	}
	
}