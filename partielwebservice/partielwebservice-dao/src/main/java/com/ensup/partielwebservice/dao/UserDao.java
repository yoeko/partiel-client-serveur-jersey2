package com.ensup.partielwebservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ensup.partielwebservice.domaine.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UserDao implements IUserDao {
	
	private static final Logger daoLogger = LogManager.getLogger(UserDao.class);

	/**  Methode pour crée un utilisateur
	 * createUser
	 * @param
	 */
	
	@Override
	public void createUser(User user) {
		
		daoLogger.info("Module Dao , methode create User");
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		// Ouverture de la transaction		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		//	Persistence Objet Relationnel : création d'un enregistrement en base
		try {
			em.persist(user);
			// Fermeture transaction
			tx.commit();
			daoLogger.info("Utilisateur crée");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			daoLogger.info("Utilisateur non crée");
		}
		
		//	Fermeture unité de travail
		em.close();
		emf.close();
	}
	
	
	/** Méthode pour chercher un user 
	 * @param login ,password
	 * return user
	 */
	@Override
	public User getUser(String login, String password) {
		// Ouverture unité de travail JPA
		daoLogger.info("Module dao, Methode get User" );
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("partiel");
		EntityManager em = emf.createEntityManager();
		
		User user = null;
		
		try {
			user =  em.createQuery("SELECT u FROM User u WHERE u.login = '" + login + "' AND u.password = '" + password + "'"  , User.class).getSingleResult();
			daoLogger.info("User trouvé");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			daoLogger.info("Utilisateur non trouvé");
		}
		
		return user;
		
		
	}
	
	
}
