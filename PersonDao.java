package one_to_one_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_one_uni1.dto.Pancard;
import one_to_one_uni1.dto.Person;



public class PersonDao {
	
		
	
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
		 
	}
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Pancard pancard=person.getPancard();
		
		entityTransaction.begin();
		
		entityManager.persist(pancard);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}
	
	public void updatePerson(int id,String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Person person=entityManager.find(Person.class, id);
		person.setName(name);
		
		
		
		entityTransaction.begin();
		Pancard pancard=person.getPancard();
		entityManager.merge(pancard);
		entityManager.merge(person);
		entityTransaction.commit();
		
	}
	
	public void deletePerson(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		
		Person person=entityManager.find(Person.class, id);
		
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityManager.remove(person.getPancard());
			
			entityTransaction.commit();
		}		
		
	}
	
	public void getPersonById(int id) {
		EntityManager entityManager=getEntityManager();
		
		Person person=entityManager.find(Person.class, id);
		
		System.out.println(person);	
		
	}
	
	public void getAllPersons() {
		EntityManager entityManager=getEntityManager();
		
		Query query=entityManager.createQuery("select p from Person p");
		
		List<Person> list=query.getResultList();
		System.out.println(list);
		
	}

	
}
