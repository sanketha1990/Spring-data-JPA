package com.jpa.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.mapping.dto.OrderRequest;
import com.jpa.mapping.dto.OrderResponse;
import com.jpa.mapping.entity.Customer;
import com.jpa.mapping.repository.CustomerRepository;
import com.jpa.mapping.repository.ProductRepository;

@RestController
public class OrderController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}

	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/getJoinInformation")
	public List<OrderResponse> getJoinInfo() {
		return customerRepository.getJoinInformation();
	}
	
}
