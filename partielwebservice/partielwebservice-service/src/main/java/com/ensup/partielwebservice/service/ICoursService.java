package com.ensup.partielwebservice.service;

import java.util.List;

import com.ensup.partielwebservice.domaine.Cours;

public interface ICoursService {

	/**
	 * createCours
	 * @param cours
	 */
	void createCours(Cours cours);

	/**
	 * 
	 * @param id
	 * @return Cours
	 */
	Cours getCours(Long id);

	/**
	 * 
	 * @param id
	 * @param nCours
	 */
	void updateCours(Long id, Cours nCours);

	/**
	 * 
	 * @param id
	 */
	void deleteCours(Long id);

	/**
	 * getAllCours
	 * 
	 */
	List<Cours> getAllCours();

}