package com.springbackend.Springbackend.dao;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbackend.Springbackend.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction ,Integer>  {

//	@Query("SELECT e FROM Employee e WHERE e.status =?1") JPQL
//	Collection<Employee> findAllActiveEmployees();
	
}
