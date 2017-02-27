package com.exilant.training.spring.jpa.repo;

import java.util.List;

import com.exilant.training.spring.jpa.entity.Task;

public interface TaskRepository {

	Task save(Task task);

	List<Task> findByTaskArchived(int taskArchivedFalse);

	List<Task> findByTaskStatus(String taskStatus);

}
