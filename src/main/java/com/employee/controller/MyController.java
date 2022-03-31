package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Service.EmployeeService;
import com.employee.entity.Employee;

@RestController
@RequestMapping("/emp")
public class MyController {

	@Autowired
	private EmployeeService employeeService;
	
	
	//To insert the employee details into database
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp)
	{
		return employeeService.saveEmployee(emp);
	}
	
	//To fetch all the employee records
	@GetMapping
	public List<Employee> fetchEmployee()
	{
		return employeeService.fetchEmployee();
	}
	//To fetch all the employees by their name
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> fetchEmployeeById(@PathVariable Long id)
	{
		return new ResponseEntity<Optional<Employee>>(employeeService.fetchEmployeeById(id),HttpStatus.OK);
	}
	//To fetch all the employees by their name
	@GetMapping("/display")
	public ResponseEntity<List<Employee>> fetchEmployeeByName(@RequestParam String name)
	{
		return new ResponseEntity<List<Employee>>(employeeService.fetchEmployeeByName(name),HttpStatus.OK);
	}
	
	//To update customer by id
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id,emp),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public List<Employee> deleteEmployee(@PathVariable Long id)
	{
		return employeeService.deleteEmployee(id);
		
	}
}
