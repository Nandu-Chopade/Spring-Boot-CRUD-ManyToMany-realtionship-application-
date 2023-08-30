package com.manytomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manytomany.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
 

}
