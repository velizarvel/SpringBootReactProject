package io.javareactproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.javareactproject.domain.Project;
import io.javareactproject.exception.ProjectIdException;
import io.javareactproject.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdateProject(Project project) {

		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException(
					"Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
		}
	}

	public Project findByProjectIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId);

		if (project == null) {
			throw new ProjectIdException("Project ID '" + projectId + "'does not exist");
		}

		return project;
	}

}
