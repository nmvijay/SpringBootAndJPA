package com.exilant.training.jpa.repo;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.exilant.training.jpa.entity.User;

public class UserDAO {
	
	private static final Logger LOGGER = Logger.getLogger("JPA");

	public User save(User user) {
		EntityManager entityManager = null;
		EntityManagerFactory factory = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("PersistenceUnit");
			entityManager = factory.createEntityManager();

			transaction = entityManager.getTransaction();
			transaction.begin();

			entityManager.persist(user);

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
		return user;
	}
}
