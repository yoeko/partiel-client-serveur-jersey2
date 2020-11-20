package com.ensup.partielwebservice.dao;

import java.util.List;

import com.ensup.partielwebservice.domaine.Cours;

public interface ICoursDao {

	void createCours(Cours cours);

	void getCours();

	List<Cours> getAllCours();

	void updateCours();

	void deleteCours();

}