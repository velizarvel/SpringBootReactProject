package io.javareactproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javareactproject.domain.Project;
import io.javareactproject.exception.ProjectIdException;
import io.javareactproject.service.MapValidationService;
import io.javareactproject.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private MapValidationService mapValidationService;


    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
    	
    	ResponseEntity<?> errorMap = mapValidationService.mapValidationServiceMethod(result);
    	if(errorMap!=null) return errorMap;
    	
        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }
    
    @GetMapping("{projectId}")
    public ResponseEntity<?> getProjectById (@PathVariable String projectId) {
    	Project project = projectService.findByProjectIdentifier(projectId);	
    	return new ResponseEntity<Project> (project, HttpStatus.OK);
    }
	
}
