
package com.exilant.training.spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exilant.training.spring.mvc.model.Department;
import com.exilant.training.spring.mvc.model.Employee;

@SpringBootApplication
public class SpringTrainingApp {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Department department1 = new Department();
		department1.setName("IT Solutions");
		
		Employee employee = new Employee();
		employee.setEmail("vijay@exilant.com");
		employee.setFirstname("Vijay");
		employee.setLastname("Kumar");
		
		txn.begin();
		em.persist(department1);
		txn.commit();
		
		txn.begin();
		Department department = em.find(Department.class, 1);

		System.out.println(department);
		txn.commit();

		employee.setDepartment(department);

		txn.begin();
		em.persist(employee);
		txn.commit();
		
		System.exit(0);
	}

}
