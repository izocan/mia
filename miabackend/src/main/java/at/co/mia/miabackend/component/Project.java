package at.co.mia.miabackend.component;

import java.util.List;
import java.util.Objects;

public class Project {

	private Long projectid;
	private String name;
	private String address;
	private List<Task> tasks;

	public Project() {
	}

	public Project(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public Project(String name, String address, List<Task> tasks) {
		this.name = name;
		this.address = address;
		this.tasks = tasks;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Project project = (Project) o;
		return Objects.equals(projectid, project.projectid) && Objects.equals(name, project.name) &&
				Objects.equals(address, project.address) && Objects.equals(tasks, project.tasks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(projectid, name, address, tasks);
	}

	@Override
	public String toString() {
		return "Project{" +
				"projectId=" + projectid +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", tasks=" + tasks +
				'}';
	}
}
