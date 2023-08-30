package com.manytomany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.manytomany.model.Employee;
import com.manytomany.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// POST
	@PostMapping("/employee/register-employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	// GET EMPLOYEE BY ID
	@GetMapping("/employee/get-employee-by-id/employeeId:{empId}")
	public Employee getEmployee(@PathVariable long empId) {
		return employeeService.getEmployee(empId);
	}

	 // GET EMPLOYEE BY ID
	@GetMapping("/employee/get-all-employee")
	public List<Employee> getAllEmployee(){
		return  employeeService.getAllEmployees();
	}
	
	// ASSIGN PROJECT TO EMPLOYEE
	@PostMapping("/employee/{employeeId}/project/{projectIds}")
	public Employee assignProject(@PathVariable long employeeId, @PathVariable long projectIds) {
		return employeeService.assignProjectEmployee(employeeId, projectIds);
	}

	//UPDATE EMPLOYEE
	@PutMapping("/employee/update/employeeId:{empId}")
	public Employee updateEmployee(@PathVariable long empId , @RequestBody Employee empoyee) {
		return employeeService.updateEmployee(empId, empoyee);
	}
	
	// DELETE BY ID
	@DeleteMapping("/employee/delete/{empId}")
	public String deleteEmployeeById(@PathVariable long empId) {
		try {
			return "employee with Id : " + empId + "deleted Successfully";

		} catch (Exception e) {
			return "employee with Id : " + empId + "not fonund";
		}
	}
}
