package com.manytomany.service;

import java.util.List;

import com.manytomany.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Long id, Employee employee);

	public void deleteEmployee(Long id);

	public Employee getEmployee(Long empId);

	public List<Employee> getAllEmployees();
	
	public Employee assignProjectEmployee(Long empId , Long Project);
} 
