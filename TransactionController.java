package com.springbackend.Springbackend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbackend.Springbackend.exception.ResourceNotFoundException;
import com.springbackend.Springbackend.model.Transaction;
import com.springbackend.Springbackend.service.TransactionService;
// sql to springboot-->mysql eclipse
//
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class TransactionController {

	@Autowired
	TransactionService trsService;

//http://localhost:8080/api/v1/getAllTransactions
	@GetMapping("/getAllTransactions")
	public List<Transaction> getTransaction() {
		List<Transaction> trsList = trsService.fetchTransaction();

		return trsList;

	}

	// http://localhost:8080/api/v1/getTransaction/1
	@GetMapping("/getTransaction/{transactionId}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable("transactionId") int transactionId)
			throws ResourceNotFoundException {
		Transaction transaction = trsService.getTransaction(transactionId);
		return ResponseEntity.ok().body(transaction);
	}

	// http://localhost:8080/api/v1/saveTransaction
	@PostMapping("/saveTransaction")
	public Transaction addTransaction(@RequestBody Transaction trs) {

		Transaction transaction = trsService.saveTransaction(trs);

		// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return transaction;
	}

	
	// http://localhost:8080/api/v1/updateTransaction/2
//		@PutMapping("/updateTransaction/{id}")
//		public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") int transactionId,
//				@RequestBody Transaction transactionDetails) throws ResourceNotFoundException {
//			Transaction transaction = trsService.getTransaction(transactionId);
//
//			transaction.setEmail_id(transactionDetails.getEmail_id());
//			transaction.setPassword(transactionDetails.getPassword());
//			transaction.setAddress(transactionDetails.getAddress());
//			final Transaction updatedTransaction = trsService.saveTransaction(register);
//			return ResponseEntity.ok(updatedTransaction);
//		}

	//http://localhost:8080/api/v1/deleteTransaction/1
		@DeleteMapping(value = "/deleteTransaction/{transactionId}")
		public ResponseEntity<String> deleteTransaction(@PathVariable("transactionId") int trsId) {

			trsService.deleteTransaction(trsId);
			return (ResponseEntity<String>) new ResponseEntity<>("Register deleted successsfully", HttpStatus.OK);
		}
		/*
		 * @DeleteMapping("/deleteEmployee/{id}") public Map<String, Boolean>
		 * deleteEmployee(@PathVariable("id") int employeeId) throws
		 * ResourceNotFoundException { // Employee employee =
		 * empService.getEmployee(employeeId);
		 * System.out.println("delete method called");
		 * empService.deleteEmployee(employeeId); Map<String, Boolean> response = new
		 * HashMap<>(); response.put("deleted", Boolean.TRUE); return response; }
		 */
	}
