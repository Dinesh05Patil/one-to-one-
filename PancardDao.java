package one_to_one_uni1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import one_to_one_uni1.dto.Pancard;
import one_to_one_uni1.dto.Person;

public class PancardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
		 
	}
	public void savePancard(Pancard pancard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
	
		
		entityTransaction.begin();
		
		entityManager.persist(pancard);
		
		entityTransaction.commit();
	}
	
	public void updatePancard(String panid,String name) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Pancard pancard=entityManager.find(Pancard.class, panid);
		pancard.setName(name);
		
		
		
		entityTransaction.begin();
		
		entityManager.merge(pancard);
	
		entityTransaction.commit();
		
	}
	
	public void deletePancard(String panid) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		
		Pancard pancard=entityManager.find(Pancard.class, panid);
		
		if(pancard!=null) {
			entityTransaction.begin();
			entityManager.remove(pancard);
			
			
			entityTransaction.commit();
		}		
		
	}
	
	public void getPancardById(String panid) {
		EntityManager entityManager=getEntityManager();
		
		Pancard pancard=entityManager.find(Pancard.class, panid);
		
		System.out.println(pancard);	
		
	}
	
	public void getAllPancard() {
		EntityManager entityManager=getEntityManager();
		
		Query query=entityManager.createQuery("select p from Pancard p");
		
		List<Person> list=query.getResultList();
		System.out.println(list);
		
	}
}
