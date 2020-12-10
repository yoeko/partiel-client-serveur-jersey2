package com.ensup.partielwebservice.service;

import java.util.List;

import com.ensup.partielwebservice.dao.CoursDao;
import com.ensup.partielwebservice.dao.ICoursDao;
import com.ensup.partielwebservice.domaine.Cours;

public class CoursService implements ICoursService {
	
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
	@Override
	public void createCours(Cours cours) {
		coursDao.createCours(cours);
	}
	
	/**
	 * 
	 * @param id
	 * @return Cours
	 */
	@Override
	public Cours getCours(Long id) {
		return coursDao.getCours(id);
	}
	
	/**
	 * 
	 * @param id
	 * @param nCours
	 */
	@Override
	public void updateCours(Long id, Cours nCours) {
		coursDao.updateCours(id, nCours);
	}
	
	/**
	 * 
	 * @param id
	 */
	@Override
	public void deleteCours(Long id) {
		coursDao.deleteCours(id);
	}
	
	/**
	 * getAllCours
	 * 
	 */
	@Override
	public List<Cours> getAllCours() {
		return coursDao.getAllCours();
	}

}
