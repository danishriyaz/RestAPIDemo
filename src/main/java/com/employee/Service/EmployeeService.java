package com.employee.Service;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.employee.Repository.EmployeeRepository;
import com.employee.entity.Employee;
import java.util.*;
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	public List<Employee> fetchEmployee()
	{
		return employeeRepository.findAll();
	}
	
	public Employee saveEmployee(Employee emp)
	{
		System.out.println();
	
		return employeeRepository.save(emp);
	}
	
	public Optional<Employee> fetchEmployeeById(Long id)
	{
		return employeeRepository.findById(id);
	}
	
	public List<Employee> fetchEmployeeByName(String name)
	{
		return employeeRepository.findByName(name);
	}
	
	public Employee updateEmployee(Long id,Employee emp)
	{
		Optional<Employee> op=employeeRepository.findById(id);
		Employee employee=null;
		if(op.isPresent())
		{
			employee=op.get();
			System.out.println("employee record udpated");
			employee.setName(emp.getName());
			employee.setDesg(emp.getDesg());
			return employeeRepository.saveAndFlush(employee);
		}
		else
		{
			System.out.println("new record created");
			return employeeRepository.save(emp);
			
		}
	}
	
	public List<Employee> deleteEmployee(Long id)
	{
		employeeRepository.deleteById(id);
		return employeeRepository.findAll();
	}
}
