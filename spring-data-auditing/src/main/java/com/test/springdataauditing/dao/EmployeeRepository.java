package com.test.springdataauditing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.springdataauditing.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
