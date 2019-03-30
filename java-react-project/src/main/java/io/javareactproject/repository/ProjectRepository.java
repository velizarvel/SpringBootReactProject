package io.javareactproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javareactproject.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	Project findByProjectIdentifier (String projectId);
	
}
