package com.ensup.partielwebservice.service;

import java.util.List;

import com.ensup.partielwebservice.dao.CoursDao;
import com.ensup.partielwebservice.dao.ICoursDao;
import com.ensup.partielwebservice.domaine.Cours;
import com.ensup.partielwebservice.domaine.Etudiant;

public class CoursService {
	
	ICoursDao coursDao = new CoursDao();
	
	public void createCours(Cours cours) {
		coursDao.createCours(cours);
	}
	
	/**
	 * getAllCours
	 * 
	 */
	public List<Cours> getAllCours() {
		return coursDao.getAllCours();
	}

}
