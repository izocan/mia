package at.co.mia.miabackend.util;

import java.util.ArrayList;
import java.util.List;

import at.co.mia.miabackend.component.Project;
import at.co.mia.miabackend.component.Task;
import at.co.mia.miabackend.model.ProjectEntity;
import at.co.mia.miabackend.model.TaskEntity;

public class BackendConverter {
	public static Project convertProjectJPAModelToFrontend(ProjectEntity projectEntity){
		Project project = new Project();

		project.setProjectid(projectEntity.getProjectId());
		project.setAddress(projectEntity.getAddress());
		project.setName(projectEntity.getName());
		project.setTasks(convertTaskJPAModelListToFrontend(projectEntity.getTasks()));

		return project;
	}

	public static List<Task> convertTaskJPAModelListToFrontend (List<TaskEntity> taskEntityList) {
		System.out.println(taskEntityList);
		List<Task> taskList = new ArrayList<>();
		taskEntityList.forEach(taskEntity -> taskList.add(convertTaskJPAModelToFrontend(taskEntity)));
		return taskList;
	}
	public static Task convertTaskJPAModelToFrontend(TaskEntity taskEntity){
		Task task = new Task();


		return task;
	}

}
