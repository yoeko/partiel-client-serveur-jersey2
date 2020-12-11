package com.ensup.partielwebservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ensup.partielwebservice.dao.CoursDao;
import com.ensup.partielwebservice.dao.ICoursDao;
import com.ensup.partielwebservice.domaine.Cours;

public class CoursService implements ICoursService {
	
	private static final Logger serviceLogger = LogManager.getLogger(UserService.class);
	
	ICoursDao coursDao = new CoursDao();
	
	/**
	 * Constructeur
	 * @param coursDao
	 */
	public CoursService(ICoursDao coursDao) {
		super();
		this.coursDao = coursDao;
	}
	
	/**
	 * createCours
	 * @param cours
	 */
	public void createCours(Cours cours) {
		serviceLogger.info("Module Service, Méthode create Cours");
		coursDao.createCours(cours);
	}
	
	/**
	 * 
	 * @param id
	 * @return Cours
	 */
	@Override
	public Cours getCours(Long id) {
		serviceLogger.info("Module Service, Méthode get Cours");
		return coursDao.getCours(id);
	}
	
	/**
	 * 
	 * @param id
	 * @param nCours
	 */
	public void updateCours(Long id, Cours nCours) {
		serviceLogger.info("Module Service, Méthode update Cours");
		coursDao.updateCours(id, nCours);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void deleteCours(Long id) {
		serviceLogger.info("Module Service, Méthode delete Cours");
		coursDao.deleteCours(id);
	}
	
	/**
	 * getAllCours
	 * 
	 */
	public List<Cours> getAllCours() {
		serviceLogger.info("Module Service, Méthode get All Cours");
		return coursDao.getAllCours();
	}

}
