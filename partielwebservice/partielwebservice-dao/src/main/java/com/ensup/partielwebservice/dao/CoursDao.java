package com.ensup.partielwebservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ensup.partielwebservice.domaine.Cours;

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
	
	public Cours getCours(Long id) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		Cours cours = em.find(Cours.class, id);
		em.close();
		emf.close();
		
		return cours;
	}
	
	public List<Cours> getAllCours() {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("SELECT c FROM Cours c", Cours.class).getResultList();
	}
	
	public void updateCours(Long id, Cours nCours) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		//	Récupération etudiant
		Cours cours = em.find(Cours.class, id);
		
		//	Modification de l'instance	
		cours.setNumberHours(nCours.getNumberHours());
		cours.setThemeCourse(nCours.getThemeCourse());
		
		// Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	Persistence Objet Relationnel : création d'un enregistrement en base
		em.merge(cours);
		
		//	Fermeture de la transaction
		tx.commit();
		
		//	Fermeture unité de travail
		em.close();
		emf.close();	
	}
	
	public void deleteCours(Long id) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		//	Récupération etudiant
		Cours cours = em.find(Cours.class, id);
		
		// Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	Persistence Objet Relationnel : suppression d'un élément dans la base
		em.remove(cours);
		
		//	Fermeture de la transaction
		tx.commit();
		
		//	Fermeture unité de travail
		em.close();
		emf.close();
	}


}
