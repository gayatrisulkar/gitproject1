package com.springbackend.Springbackend.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.Springbackend.dao.TransactionRepository;
import com.springbackend.Springbackend.model.Transaction;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository trsRepository;
	
	@Transactional
	public List<Transaction> fetchTransaction() {
		List<Transaction> trsList=trsRepository.findAll();
		return trsList;
		
	}
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {		
		return trsRepository.save(transaction);		
	}
	@Transactional
	public void updateTransaction(Transaction trs) {
		trsRepository.save(trs);		
	}
	
	@Transactional
	public void deleteTransaction(int trsId) {
		//empRepository.delete(emp);	
		System.out.println("service method called");
		trsRepository.deleteById(trsId);	
	}
	@Transactional 
	  public Transaction getTransaction(int id) { 
	  Optional<Transaction> optional=trsRepository.findById(id);
	  Transaction trs=optional.get();
	  return trs;
	  }
}

