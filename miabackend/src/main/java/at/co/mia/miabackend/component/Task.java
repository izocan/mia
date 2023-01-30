package at.co.mia.miabackend.component;

import java.util.Objects;

import at.co.mia.miabackend.model.ProjectEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Task {

	private Long taskId;
	private String description;
	private int duration; //hours
	private boolean finished;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
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
		Task task = (Task) o;
		return duration == task.duration && finished == task.finished && Objects.equals(taskId, task.taskId) &&
				Objects.equals(description, task.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId, description, duration, finished);
	}

	@Override
	public String toString() {
		return "Task{" +
				"taskId=" + taskId +
				", description='" + description + '\'' +
				", duration=" + duration +
				", finished=" + finished +
				'}';
	}
}
