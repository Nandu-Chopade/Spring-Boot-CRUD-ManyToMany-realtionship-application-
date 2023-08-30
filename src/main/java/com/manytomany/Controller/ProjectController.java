package com.manytomany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manytomany.model.Project;
import com.manytomany.service.ProjectService;


@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	// POST
	@PostMapping("/project/register-project")
	public ResponseEntity<String> saveProject(@RequestBody Project project) {
		if(!project.getProjectName().isBlank()) {
			projectService.addProject(project);
			return new ResponseEntity<>("Project Created", HttpStatus.CREATED);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		            .contentType(MediaType.TEXT_PLAIN)
		            .body("Provide Project Name");
		}
		    
	}

	// GET  PROJECT BY ID
	@GetMapping("/project/get-project-by-id/projectId:{projectId}")
	public Project getProject(@PathVariable long projectId) {
		return projectService.getProject(projectId);
	}

	 // GET  PROJECT BY ID
	@GetMapping("/project/get-all-project")
	public List<Project> getAllproject(){
		return  projectService.getAllProjects();
	}
	

	//UPDATE PROJECT
	@PutMapping("/project/update")
	public Project updateProject(@RequestBody Project empoyee) {
		return projectService.updateProject(empoyee);
	}
	
	// DELETE BY ID
	@DeleteMapping("/project/delete/{projectId}")
	public ResponseEntity<String> deleteProjectById(@PathVariable long projectId) {
	    try {
	        // Check if the project with the given ID exists (You should have a service or repository method for this)
	        boolean projectExists = projectService.findProjectId(projectId);

	        if (projectExists) {
	            // Delete the project (You should have a service or repository method for this)
	            projectService.deleteProject(projectId);
	            return ResponseEntity.status(HttpStatus.OK)
	                .body("Project with ID " + projectId + " deleted successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                .body("Project with ID " + projectId + " not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	            .body("An error occurred while processing the request");
	    }
	}

}
