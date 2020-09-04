package com.jpa.mapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpa.mapping.dto.OrderResponse;
import com.jpa.mapping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select new com.jpa.mapping.dto.OrderResponse(c.name, p.productName) from Customer c JOIN c.products p")
	public List<OrderResponse> getJoinInformation();

}
