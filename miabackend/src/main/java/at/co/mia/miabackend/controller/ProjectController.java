package at.co.mia.miabackend.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import at.co.mia.miabackend.component.Project;
import at.co.mia.miabackend.model.ProjectEntity;
import at.co.mia.miabackend.service.ProjectService;
import at.co.mia.miabackend.util.BackendConverter;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;


	@GetMapping("/get-projects")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public Collection<Project> getProjects() {
		System.out.println("getProjects()");
		List<Project> projects = new ArrayList<>();
		projectService.getProjects().forEach(projectEntity -> projects.add(BackendConverter.convertProjectJPAModelToFrontend(projectEntity)));
		System.out.println("found projects: " + projects);
		return projects;
	}

	@PostMapping("/add-project")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public void addProjects(@RequestBody ProjectEntity newProject) {
		projectService.createOrUpdateProject(newProject);
	}

	@GetMapping("/get-project/{id}")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public Project getProject(@PathVariable(value = "id") Long id) {

		return BackendConverter.convertProjectJPAModelToFrontend(projectService.getProject(id));
	}

	@PutMapping("/update-project/{id}")
	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
	public void updateProject(@PathVariable(value = "id") Long id, @RequestBody ProjectEntity project) {
		project.setProjectId(id);
		projectService.createOrUpdateProject(project);
	}

}
