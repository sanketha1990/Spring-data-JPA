package com.test.springdatajpa.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.springdatajpa.model.User;
import com.test.springdatajpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initDB() {
		List<User> user = Arrays.asList(new User(111, "Samip", "IT", 23), new User(112, "Sam", "IT", 28),
				new User(113, "Samrat", "BT", 333), new User(114, "Samip", "IT", 23));
		repository.saveAll(user);

	}

	public List<User> getUsers() {
		return repository.findAll();
	}

	public List<User> getByProfession(String profession) {
		return repository.findByProfession(profession);
	}

	public long countByAge(int age) {
		return repository.countByAge(age);
	}

	public List<User> deleteUserByName(String name) {
		return repository.deleteByName(name);
	}

	public List<User> getUserByProfessionAndAge(String profession, int age) {
		return repository.findByProfessionAndAge(profession, age);
	}

	public List<User> getProfessionIgnoreCase(String profession) {
		return repository.findByProfessionIgnoreCase(profession);
	}
	
	/*
	 * public List<User> getUserSort(String field){ return
	 * repository.findAll(Sort.by(Sort.Direction.DESC, field)); }
	 */
	
	public Page<User> getPaginatedUser(){
		return repository.findAll(PageRequest.of(1, 3));
	}
	
	public List<User> getUsersCustomQuery(){
		return repository.getUsersCustomQuery();
	}
}
