package at.co.mia.miabackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.co.mia.miabackend.component.Project;
import at.co.mia.miabackend.model.ProjectEntity;
import at.co.mia.miabackend.model.TaskEntity;
import at.co.mia.miabackend.repository.ProjectRepository;
import at.co.mia.miabackend.repository.TaskRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;


	public ProjectEntity createOrUpdateProject(ProjectEntity project) {
		return projectRepository.save(project);
	}

	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

	public ProjectEntity addTask(Long projectId, TaskEntity task) {
		ProjectEntity project = projectRepository.findById(projectId).get();
		task.setProject(project);
		taskRepository.save(task);
		project.getTasks().add(task);
		return projectRepository.save(project);
	}

	public ProjectEntity removeTask(Long projectId, Long taskId) {
		ProjectEntity project = projectRepository.findById(projectId).get();
		TaskEntity task = taskRepository.findById(taskId).get();
		task.setProject(null);
		taskRepository.delete(task);
		project.getTasks().remove(task);
		return projectRepository.save(project);
	}

	public List<ProjectEntity> getProjects(){
		List<ProjectEntity> projects = new ArrayList<>();
		projectRepository.findAll().forEach(project -> {
			System.out.println(project + ", taskSize = " + project.getTasks().size());
			projects.add(project);
		} );

		return projects;
	}

	public List<TaskEntity> getTasks(){
		List<TaskEntity> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}

	public ProjectEntity getProject(long projectId){
		return projectRepository.findById(projectId).get();
	}
}