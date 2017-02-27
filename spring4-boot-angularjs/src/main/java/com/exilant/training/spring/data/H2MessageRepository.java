
package com.exilant.training.spring.data;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.exilant.training.spring.mvc.model.Message;

public class H2MessageRepository implements MessageRepository {

	private static final Logger LOGGER = Logger.getLogger("H2MessageRepository");

	@Override
	public Iterable<Message> findAll() {
		EntityManager entityManager = null;
		EntityManagerFactory factory = null;
		List<Message> result = null;

		try {
			factory = Persistence.createEntityManagerFactory("h2");
			entityManager = factory.createEntityManager();

			TypedQuery<Message> selectAll = entityManager.createQuery("from Message", Message.class);
			result = selectAll.getResultList();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {

			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		return result;
	}

	@Override
	public Message save(Message message) {
		EntityManager entityManager = null;
		EntityManagerFactory factory = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("h2");
			entityManager = factory.createEntityManager();

			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(message);

			System.out.println("created message: " + message);

			transaction.commit();

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		return message;
	}

	@Override
	public Message findMessage(Long idParam) {
		EntityManager entityManager = null;
		EntityManagerFactory factory = null;
		Message message = null;
		try {
			factory = Persistence.createEntityManagerFactory("h2");
			entityManager = factory.createEntityManager();
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			// select * from message where id = ?
			CriteriaQuery<Message> find = criteriaBuilder.createQuery(Message.class);

			ParameterExpression<Long> id = criteriaBuilder.parameter(Long.class, "id");

			Root<Message> root = find.from(Message.class);
			find.select(root);
			find.where(criteriaBuilder.equal(root.get("id"), id));

			TypedQuery<Message> query = entityManager.createQuery(find);
			query = query.setParameter("id", idParam);
			List<Message> messages = query.getResultList();

			if (messages.size() > 0) {
				message = messages.get(0);
			}

		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
		return message;
	}

	@Override
	public void deleteMessage(Long id) {
		EntityManager entityManager = null;
		EntityManagerFactory factory = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("h2");
			entityManager = factory.createEntityManager();
			// delete from message where id = ?
			Message message = entityManager.find(Message.class, id);
			transaction = entityManager.getTransaction();
			transaction.begin();

			if (message != null) {
				entityManager.remove(message);
			}

			transaction.commit();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}

}
