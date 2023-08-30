package com.manytomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
