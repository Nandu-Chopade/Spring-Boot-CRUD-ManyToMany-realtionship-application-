package com.manytomany.service;

import java.util.List;

import com.manytomany.model.Project;

public interface ProjectService {
	public Project addProject(Project project);

	public Project updateProject(Project project);

	public void deleteProject(Long id);

	public Project getProject(Long id);

	public List<Project> getAllProjects();

	public boolean findProjectId(long projectId);
}
