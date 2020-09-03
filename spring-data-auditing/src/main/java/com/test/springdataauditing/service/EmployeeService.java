package com.test.springdataauditing.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springdataauditing.dao.EmployeeRepository;
import com.test.springdataauditing.dto.InputRequest;
import com.test.springdataauditing.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public String saveEmployee(InputRequest<Employee> request) {
		String currentUser = request.getLoggedInuser();
		request.setTimezone(Calendar.getInstance().getTimeZone().getDisplayName());

		Employee employee = request.getEmployee();
		employee.setCreatedBy(currentUser);
		repository.save(employee);
		return "Employee Saved Successfully... !!";
	}

	public String updateEmployee(int id, double salary, InputRequest<Employee> request) {
		Employee employee = repository.findById(id).get();

		if (employee != null) {
			employee.setSalary(salary);
			employee.setModifiedBy(request.getLoggedInuser());
			repository.saveAndFlush(employee);
		} else {
			throw new RuntimeException("Employee not found with id : " + id);
		}
		return "Employee updated Succesfully ...!";

	}

}
