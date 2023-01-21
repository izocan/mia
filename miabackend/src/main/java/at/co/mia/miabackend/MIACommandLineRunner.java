package at.co.mia.miabackend;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import at.co.mia.miabackend.component.Project;
import at.co.mia.miabackend.repository.ProjectRepository;

@Component
public class MIACommandLineRunner implements CommandLineRunner {

	private final ProjectRepository projectRepo;

	public MIACommandLineRunner(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}

	@Override
	public void run(String... strings) throws Exception {

		List<Project> projects = Arrays.asList(
				new Project("Dachsanierung SBG", "AglassingerStrasse 3"),
				new Project("Brandschaden SBG", "Bergerhof 3"),
				new Project("Wasserschaden VIE", "Nordbahnstrasse 47"));

		projectRepo.saveAll(projects);

		projectRepo.findAll().forEach(System.out::println);
	}
}