package at.co.mia.miabackend.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class TaskEntity {

	@Id
	@GeneratedValue
	private Long taskId;

	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectEntity project;

	private String description;
	private int duration; //hours
	private boolean finished;


	public TaskEntity() {
	}

	public TaskEntity(String description, int duration, boolean finished) {
		this.description = description;
		this.duration = duration;
	}


	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long id) {
		this.taskId = id;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TaskEntity task = (TaskEntity) o;
		return duration == task.duration && finished == task.finished && Objects.equals(taskId, task.taskId) && Objects.equals(project, task.project) &&
				Objects.equals(description, task.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId, project, description, duration, finished);
	}

	@Override
	public String toString() {
		return "Task{" +
				"taskId=" + taskId +
				", projectId=" + project.getProjectId() +
				", description='" + description + '\'' +
				", duration=" + duration +
				", finished=" + finished +
				'}';
	}
}
