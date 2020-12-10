package com.ensup.partielwebservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ensup.partielwebservice.domaine.Etudiant;
import com.ensup.partielwebservice.domaine.User;

public class EtudiantDao implements IEtudiantDao  {

	
	private static final Logger daoLogger = LogManager.getLogger(EtudiantDao.class);

	
	/**
	 * Methode de creation d'etudiant
	 * @param etudiant
	 */
	@Override
	public void createEtudiant(Etudiant etudiant) {
		
		daoLogger.info("Module dao ,Methode  Creation de l'etudiant");
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		// Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			//	Persistence Objet Relationnel : création d'un enregistrement en base
			em.persist(etudiant);
			
			// Fermeture transaction
			tx.commit();
			daoLogger.info("Module dao , Etudiant crée");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			daoLogger.info("Module dao , Entudian non crée");
		}
		
		//	Fermeture unité de travail
		em.close();
		emf.close();
	}
	
	
	
	/**
	 * Methode de recherche d'etudiant par son id
	 * @param id
	 * @return un etudiant
	 */
	@Override
	public Etudiant getEtudiant(Long id) {
			daoLogger.info("module dao , recherche etudiant par son id");
			// Ouverture unité de travail JPA
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
			EntityManager em = emf.createEntityManager();
			
			//	Récupération etudiant
			Etudiant etudiant = null;
			try {
				etudiant = em.find(Etudiant.class, id);
				daoLogger.info("Module dao , etudiant trouvé");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				daoLogger.info("Module dao , etudiant non trouvé");
	
			}
			
			em.close();
			emf.close();
			
			return etudiant;
	}
	
	
	/**
	 * Methode de recherche d'etudiant par son email
	 * @param email
	 * @return
	 */
	@Override
	public Etudiant getEtudiantByEmail(String email) {
		daoLogger.info("Module dao ,Methode recherche etudiant par son email" );
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		Etudiant etudiantFound = null;
		
		try {
			TypedQuery<Etudiant> query = em.createQuery("SELECT c FROM Etudiant c WHERE c.mail ='" + email +  "'"  , Etudiant.class);
			 etudiantFound = query.getSingleResult();
			 daoLogger.info("Module dao , etudiant trouvé");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 daoLogger.info("Module dao , etudiant non trouvé");

		}
		
		return etudiantFound;
	}
	
	
	/**
	 * Methode de recherche d'etudiant par son firstName et lastName
	 * @param firstNameR
	 * @param lastNameR
	 * @return
	 */
	@Override
	public List<Etudiant> getStudentByResearch(String firstNameR, String lastNameR){
		
		daoLogger.info("Module dao ,Methode recherche etudiant par son lastName et firstname" );
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		List<Etudiant> etudiantFound = null;
		
		TypedQuery<Etudiant> query;
		try {
			query = em.createQuery("SELECT c FROM Etudiant c WHERE c.first_name like '%" + firstNameR +  "%' AND c.last_name like '%" + lastNameR +"%'"  , Etudiant.class);
			etudiantFound = query.getResultList();
			daoLogger.info("Module dao , etudiant trouvé");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			daoLogger.info("Module dao , etudiant non trouvé");

		}
		return etudiantFound;
	}
	
	
	/**
	 * Methode modifier un etudiant
	 * @param id
	 * @param nEtudiant
	 */
	@Override
	public void updateStudent(Long id, Etudiant nEtudiant) {
		daoLogger.info("Module dao ,Methode modifier un etudiant" );

		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		// Ouverture de la transaction
				EntityTransaction tx = em.getTransaction();
				tx.begin();
		
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
		etdt.setCours(nEtudiant.getCours());

		try {
			//	Persistence Objet Relationnel : création d'un enregistrement en base
			em.merge(etdt);
			
			//	Fermeture de la transaction
			tx.commit();
			
			daoLogger.info("module dao , etudiant modifié");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			daoLogger.info("module dao , etudiant non modifié");

		}
		
		//	Fermeture unité de travail
		em.close();
		emf.close();	
		
	}
	
	
	/**
	 * Methode recuperer tous les etudiants
	 * @return
	 */
	@Override
	public List<Etudiant> getAllStudent() {
		
		daoLogger.info("module dao , Methode pour recuperer la liste des etudiant");

		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		try {
			etudiants = em.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
			daoLogger.info("module dao , liste etudiants récuperer");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			daoLogger.info("module dao , liste etudiants  nonnrécuperer");

		}
		
		
		return etudiants;
				
	}
	
	/**
	 * Methode pour supprimer un etudiant
	 * @param id
	 */
	@Override
	public void deleteEtudiant(Long id) {
		
		daoLogger.info("module dao , Methode pour supprimer etudiant");

		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();

		// Ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			//Récupération etudiant
				Etudiant etdt = em.find(Etudiant.class, id);
				//	Persistence Objet Relationnel : suppression d'un élément dans la base
				em.remove(etdt);
				//	Fermeture de la transaction
				tx.commit();
				daoLogger.info("module dao , etudiant suprimé");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			daoLogger.info("module dao , etudiant non  suprimé");

		}
		
		//	Fermeture unité de travail
		em.close();
		emf.close();	
		
	}
	
}
