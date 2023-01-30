package at.co.mia.miabackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import at.co.mia.miabackend.model.TaskEntity;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}
