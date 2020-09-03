package com.test.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.test.springdatajpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByProfession(String profession);

	// public List<User> findByName(String name);

	// public List<User> findByAge(int age);

	public long countByAge(int age);

	public List<User> deleteByName(String name);

	// Multi condition
	public List<User> findByProfessionAndAge(String profession, int age);

	// Ignore case
	public List<User> findByProfessionIgnoreCase(String profession);

	//public List<User> getUserSort(String field);

	@Modifying
	@Query("select u from User u")
	public List<User> getUsersCustomQuery();

}
