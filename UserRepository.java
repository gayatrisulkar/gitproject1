package com.springbackend.Springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springbackend.Springbackend.model.Register;


public interface UserRepository extends JpaRepository<Register, String>{
	@Query("SELECT u FROM Register u WHERE u.email_id =?1 and u.password=?2")
			public Register validateUser(String email_id,String password);	
}