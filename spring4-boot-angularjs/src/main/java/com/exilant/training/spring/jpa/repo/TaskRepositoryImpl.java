package com.exilant.training.spring.jpa.repo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.exilant.training.spring.jpa.entity.Task;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

	private static final Logger LOGGER = Logger.getLogger("TaskRepositoryImpl");

	@PersistenceContext(unitName = "h2")
	private EntityManager entityManager;

	@Override
	@Transactional
	public Task save(Task task) {

		System.out.println("entityManager1 : " + entityManager);
		try {
			entityManager.persist(task);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		}
		return task;
	}

	@Override
	public List<Task> findByTaskStatus(String taskStatus) {
		List<Task> taskList = null;
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			// select * from message where id = ?
			CriteriaQuery<Task> find = criteriaBuilder.createQuery(Task.class);

			ParameterExpression<String> filteredColumn = criteriaBuilder.parameter(String.class, "task_status");

			Root<Task> root = find.from(Task.class);
			find.select(root);
			find.where(criteriaBuilder.equal(root.get("task_status"), filteredColumn));

			TypedQuery<Task> query = entityManager.createQuery(find);
			query = query.setParameter("task_status", taskStatus);
			taskList = query.getResultList();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return taskList;
	}

	public List<Task> findByTaskArchived(int taskArchivedFalse) {
		System.out.println("entityManager1 : " + entityManager);

		List<Task> taskList = null;
		try {
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			// select * from message where id = ?
			CriteriaQuery<Task> find = criteriaBuilder.createQuery(Task.class);

			ParameterExpression<Integer> filteredColumn = criteriaBuilder.parameter(Integer.class, "taskArchived");

			Root<Task> root = find.from(Task.class);
			find.select(root);
			find.where(criteriaBuilder.equal(root.get("taskArchived"), filteredColumn));

			TypedQuery<Task> query = entityManager.createQuery(find);
			query = query.setParameter("taskArchived", taskArchivedFalse);
			taskList = query.getResultList();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return taskList;
	}

}
