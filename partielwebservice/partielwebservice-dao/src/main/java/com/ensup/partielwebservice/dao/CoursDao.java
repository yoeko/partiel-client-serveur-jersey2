package com.ensup.partielwebservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ensup.partielwebservice.domaine.Cours;
import com.ensup.partielwebservice.domaine.Etudiant;

public class CoursDao implements ICoursDao {
	
	/**
	 * createCours
	 * @param cours
	 */
	public void createCours(Cours cours) {
		
		// 1. Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		//	Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//	Persistence
		em.persist(cours);
		//	Fermeture de la transaction
		tx.commit();
		//	Fermeture unité de travail
		em.close();
		emf.close();
		
	}
	
	public void getCours() {
		
	}
	
	public List<Cours> getAllCours() {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("SELECT c FROM Cours c", Cours.class).getResultList();
	}
	
	public void updateCours() {
		
	}
	
	public void deleteCours() {
		
	}

}
