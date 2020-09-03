package com.test.springdatajpa.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springdatajpa.model.User;
import com.test.springdatajpa.service.UserService;

@RestController
@RequestMapping("/spring-data-jpa")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/getUsers")
	public List<User> getAllUsers() {
		return service.getUsers();
	}

	@GetMapping("/getUserByProfession/{profession}")
	public List<User> getUserByProfession(@PathVariable String profession) {
		return service.getByProfession(profession);
	}

	@GetMapping("/countByAge/{age}")
	public String getCountByAge(@PathVariable int age) {
		return "Count By Age = " + service.countByAge(age);
	}

	@DeleteMapping("/delete/{name}")
	public List<User> deleteUser(@PathVariable String name) {
		return service.deleteUserByName(name);
	}

	@GetMapping("/find/{profession}/{age}")
	public List<User> findByProfessionAndAge(@PathVariable String profession, @PathVariable int age) {
		return service.getUserByProfessionAndAge(profession, age);
	}

	@GetMapping("/getUserByProfessionIgnoreCase")
	public List<User> getUserByProfessionIgnoreCase(@PathParam("profession") String profession) {
		return service.getProfessionIgnoreCase(profession);
	}
	
	/*
	 * @GetMapping("/getUserSortByField/{field}") public List<User>
	 * getUserSortByField(@PathVariable String field){ return
	 * service.getUserSort(field); }
	 */
	
	@GetMapping("/getPaginatedUser")
	public Page<User> getPaginatedUser(){
		return service.getPaginatedUser();
	}
	
	@GetMapping("/getUsersCustomQuery")
	public List<User> getUsersCustomQuery(){
		return service.getUsersCustomQuery();
	}

}
