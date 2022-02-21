package com.springbackend.Springbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.Springbackend.dao.ALoginRepository;
import com.springbackend.Springbackend.model.ALogin;



@Service
public class ALoginService {

	@Autowired
	ALoginRepository ALoginRepository;

	public ALogin validateALogin(ALogin alogin) {
		ALogin a=ALoginRepository.validateALogin(alogin.getEmail_id(),alogin.getPassword());
		
		return a;
	}
	
}