package com.manytomany.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;



@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employeeId")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String employeeName;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project",
	    joinColumns = @JoinColumn(name = "employee_id"),
	    inverseJoinColumns = @JoinColumn(name = "project_id"))
	private Set<Project> project = new HashSet<>();

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	

	public Set<Project> getProject() {
		return project;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public void setProject(Set<Project> project) {
		this.project = project;
	}

	public Employee(long employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

}
