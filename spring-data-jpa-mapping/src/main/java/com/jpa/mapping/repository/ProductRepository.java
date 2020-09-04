package com.jpa.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.mapping.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
