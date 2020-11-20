package com.ensup.partielwebservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ensup.partielwebservice.domaine.Etudiant;
import com.ensup.partielwebservice.domaine.Personne;
import com.ensup.partielwebservice.domaine.User;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/


public class UserDao implements IUserDao {
	
	//private static final Logger daoLogger = LogManager.getLogger(UserDao.class);

	/**
	 * createUser
	 * @param
	 */
	public void createUser(User user) {
		
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		// Ouverture de la transaction		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	Persistence Objet Relationnel : création d'un enregistrement en base
		em.persist(user);
		
		// Fermeture transaction
		tx.commit();
		
		//	Fermeture unité de travail
		em.close();
		emf.close();
	}
	
	public void getUser() {
		
	}
	
	public void getAllUser() {
		
	}
	
	public void updateUser() {
		
	}
	
	public void deleteUser() {
		
	}

	public User getUser(String login, String password) {
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
//		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.login = " + login + " AND u.password = " + password + ""  , User.class);
//		TypedQuery<User> query;
		User user = null;
		
		try {
			user =  em.createQuery("SELECT u FROM User u WHERE u.login = '" + login + "' AND u.password = '" + password + "'"  , User.class).getSingleResult();
			//daoLogger.info("User trouvé");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//daoLogger.info("Utilisateur non trouvé");
		}
		
		return user;
		
		
	}
	
	
}
