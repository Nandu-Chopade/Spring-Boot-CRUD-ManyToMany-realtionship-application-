package com.manytomany.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.dao.EmployeeRepository;
import com.manytomany.dao.ProjectRepository;
import com.manytomany.model.Employee;
import com.manytomany.model.Project;

@Service
public class ServiceImpl implements EmployeeService, ProjectService {

	// PROJECT DAO
	@Autowired
	private  ProjectRepository projectRepository;
	
	// EMPLOYEE DAO
	@Autowired 
	private EmployeeRepository employeeRepository;
	
	
	
	
	//PROJECT BUSSINESS LOGIC START FROM HERE
	
	// register project
	@Override
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}

	// update project
	@Override
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	//delete project
	@Override
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

	// get project by id
	@Override
	public Project getProject(Long id) {
	 return projectRepository.findById(id).get();
	}

	// get all project
	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}
	
	@Override
	public boolean findProjectId(long projectId) {
		Project checkIdExist = projectRepository.findById(projectId).get();
		if(checkIdExist.getProjectName().isBlank()) {
			return true;
		}else {
		return false;
		}
	}


/* ------------------------------------------------------------------------ */
	
	// EPLOYEE BUSSINESS LOGIC START FROM HERE
	
	// register employee 
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee) ;
	}

	// update employee
	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		  employee = employeeRepository.findById(id).get();
		  return employeeRepository.save(employee);
	}

	// delete employee
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);  
	}
	
    // get employee by id
	@Override
	public Employee getEmployee(Long empId) {
		
		return employeeRepository.findById(empId).get() ;
	}

	//get all employee list
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	// assign project to employee 
	@Override
	public Employee assignProjectEmployee(Long empId, Long Project) {
		Set<Project> projectSet;
		Employee employee = employeeRepository.findById(empId).get();
		Project project = projectRepository.findById(Project).get();
		projectSet = employee.getProject();
		projectSet.add(project);
	    employee.setProject(projectSet);
	    return employeeRepository.save(employee);
	}

	


}
