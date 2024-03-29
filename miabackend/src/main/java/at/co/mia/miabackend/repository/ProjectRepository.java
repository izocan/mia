package at.co.mia.miabackend.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import at.co.mia.miabackend.model.ProjectEntity;

@RepositoryRestResource
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
}
