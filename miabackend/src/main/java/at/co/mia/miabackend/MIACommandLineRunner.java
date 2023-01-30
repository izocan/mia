package at.co.mia.miabackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import at.co.mia.miabackend.model.ProjectEntity;
import at.co.mia.miabackend.model.TaskEntity;
import at.co.mia.miabackend.service.ProjectService;

@Component
public class MIACommandLineRunner implements CommandLineRunner {

	@Autowired
	ProjectService projectService;

	public MIACommandLineRunner() {	}

	@Override
	public void run(String... strings) throws Exception {

/*		List<Task> tasks1 = Arrays.asList(
			new Task("Fliesenlegen Kinderzimmer", 16, true),
			new Task("Ausmalen Kinderzimmer", 4, true),
			new Task("Fliesenlegen Flur", 12, false),
			new Task("Ausmalen Flur", 2, false),
			new Task("Restarbeiten", 16, false)
		);

		List<Task> tasks2 = Arrays.asList(
				new Task("Malen Wohnzimmer", 6, false),
				new Task("malen küche", 4, true),
				new Task("Fenster austauschen", 16, false),
				new Task("Restarbeiten", 16, false)
		);

		List<Task> tasks3 = Arrays.asList(
				new Task("Trocknung", 16, true),
				new Task("Laminat erneuern", 8, false),
				new Task("Restarbeiten", 16, false)
		);


		List<Project> projects = Arrays.asList(
				new Project("Dachsanierung SBG", "AglassingerStrasse 3"),
				new Project("Brandschaden SBG", "Bergerhof 3"),
				new Project("Wasserschaden VIE", "Nordbahnstrasse 47"));
*/


		ProjectEntity project = new ProjectEntity("Dachsanierung SBG", "AglassingerStrasse 3");
		project = projectService.createOrUpdateProject(project);
		TaskEntity task = new TaskEntity("Fliesenlegen Kinderzimmer", 16, true);

		projectService.addTask(project.getProjectId(), task);

		projectService.getProjects();


		//projectService.getTasks();


	}
}