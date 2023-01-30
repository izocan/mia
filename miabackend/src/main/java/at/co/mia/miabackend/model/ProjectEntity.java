package at.co.mia.miabackend.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="project")
public class ProjectEntity {

	@Id
	@GeneratedValue
	@Column(name = "project_id")
	private Long projectId;

	private String name;
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<TaskEntity> tasks;

	public ProjectEntity() {
	}

	public ProjectEntity(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public ProjectEntity(String name, String address, List<TaskEntity> tasks) {
		this.name = name;
		this.address = address;
		this.tasks = tasks;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long id) {
		this.projectId = id;
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

	public List<TaskEntity> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskEntity> tasks) {
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
		ProjectEntity project = (ProjectEntity) o;
		return Objects.equals(projectId, project.projectId) && Objects.equals(name, project.name) && Objects.equals(address, project.address) &&
				Objects.equals(tasks, project.tasks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(projectId, name, address, tasks);
	}

	@Override
	public String toString() {
		return "Project{" +
				"projectId=" + projectId +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", tasks=" + tasks +
				'}';
	}
}
