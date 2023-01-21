package at.co.mia.miabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import at.co.mia.miabackend.component.Project;

@RepositoryRestResource
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
