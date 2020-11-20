package com.ensup.partielwebservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ensup.partielwebservice.domaine.Etudiant;
import com.ensup.partielwebservice.domaine.User;

public class EtudiantDao implements IEtudiantDao {

	
	/**
	 * createEtudiant
	 */
	public void createEtudiant(Etudiant etudiant) {
		
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		// Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	Persistence Objet Relationnel : création d'un enregistrement en base
		em.persist(etudiant);
		
		// Fermeture transaction
		tx.commit();
		
		//	Fermeture unité de travail
		em.close();
		emf.close();
	}
	
	/**
	 * create Etudiant
	 */
	public Etudiant getEtudiant(Long id) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		//	Récupération etudiant
		Etudiant etdt = em.find(Etudiant.class, id);
		
		em.close();
		emf.close();
		
		return etdt;
	}
	
	public Etudiant getEtudiantByEmail(String email) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Etudiant> query = em.createQuery("SELECT c FROM Etudiant c WHERE c.mail ='" + email +  "'"  , Etudiant.class);
		return query.getSingleResult();
	}
	
	public List<Etudiant> getStudentByResearch(String firstNameR, String lastNameR){
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Etudiant> query = em.createQuery("SELECT c FROM Etudiant c WHERE c.first_name like '%" + firstNameR +  "%' AND c.last_name like '%" + lastNameR +"%'"  , Etudiant.class);
		return query.getResultList();
	}
	
	/**
	 * updateEtudiant
	 */
	public void updateStudent(Long id, Etudiant nEtudiant) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		//	Récupération etudiant
		Etudiant etdt = em.find(Etudiant.class, id);
		
		//	Modification de l'instance	
		etdt.setAddress(nEtudiant.getAddress());
		etdt.setCours(nEtudiant.getCours());
		etdt.setDob(nEtudiant.getDob());
		etdt.setFirst_name(nEtudiant.getFirst_name());
		etdt.setLast_name(nEtudiant.getLast_name());
		etdt.setMail(nEtudiant.getMail());
		etdt.setPhone(nEtudiant.getPhone());
		
		// Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	Persistence Objet Relationnel : création d'un enregistrement en base
		em.merge(etdt);
		
		//	Fermeture de la transaction
		tx.commit();
		
		//	Fermeture unité de travail
		em.close();
		emf.close();	
		
	}
	
	/**
	 * getAllEtudiant
	 */
	public List<Etudiant> getAllStudent() {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		return em.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
				
	}
	
	/**
	 * deleteEtudiant
	 */
	public void deleteEtudiant(Long id) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		//	Récupération etudiant
		Etudiant etdt = em.find(Etudiant.class, id);
		
		// Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	Persistence Objet Relationnel : suppression d'un élément dans la base
		em.remove(etdt);
		
		//	Fermeture de la transaction
		tx.commit();
		
		//	Fermeture unité de travail
		em.close();
		emf.close();	
		
	}
	
}
