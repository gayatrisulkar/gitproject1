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
import com.springbackend.Springbackend.model.Order;
import com.springbackend.Springbackend.service.OrderService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class OrderController {

	@Autowired
	OrderService ordService;

//http://localhost:8080/api/v1/getAllOrders
	@GetMapping("/getAllOrders")
	public List<Order> getOrder() {
		List<Order> ordList = ordService.fetchOrder();

		return ordList;

	}

	// http://localhost:8080/api/v1/getOrder/1
	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") int orderId)
			throws ResourceNotFoundException {
		Order order = ordService.getOrder(orderId);
		return ResponseEntity.ok().body(order);
	}

	// http://localhost:8080/api/v1/saveOrder
	@PostMapping("/saveOrder")
	public Order addOrder(@RequestBody Order ord) {

		Order order = ordService.saveOrder(ord);

		// return new ResponseEntity<>("Employee added successsfully", HttpStatus.OK);
		return order;
	}

	
	// http://localhost:8080/api/v1/updateOrder/2
		@PutMapping("/updateOrder/{id}")
		public ResponseEntity<Order> updateOrder(@PathVariable("id") int orderId,
				@RequestBody Order orderDetails) throws ResourceNotFoundException {
			Order order = ordService.getOrder(orderId);

			order.setAddress(orderDetails.getAddress());
			
			final Order updatedOrder = ordService.saveOrder(order);
			return ResponseEntity.ok(updatedOrder);
		}

	//http://localhost:8080/api/v1/deleteOrder/1
		@DeleteMapping(value = "/deleteOrder/{orderId}")
		public ResponseEntity<String> deleteOrder(@PathVariable("orderId") int ordId) {

			ordService.deleteOrder(ordId);
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
