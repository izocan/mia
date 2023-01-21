package at.co.mia.miabackend.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.co.mia.miabackend.component.Project;
import at.co.mia.miabackend.repository.ProjectRepository;

@RestController
public class ProjectController {
	private ProjectRepository projectRepo;

	public ProjectController(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}

	@GetMapping("/get-projects")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public Collection<Project> getProjects() {
		return projectRepo.findAll();
	}

	@PostMapping("/add-project")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public void addProjects(@RequestBody Project newProject) {
		projectRepo.save(newProject);
	}

	@GetMapping("/get-project/{id}")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public Project getProject(@PathVariable(value = "id") Long id) {
		return projectRepo.findById(id).get();
	}

	@PutMapping("/update-project/{id}")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public void updateProject(@PathVariable(value = "id") Long id, @RequestBody Project project) {
		project.setId(id);
		projectRepo.save(project);
	}

}
