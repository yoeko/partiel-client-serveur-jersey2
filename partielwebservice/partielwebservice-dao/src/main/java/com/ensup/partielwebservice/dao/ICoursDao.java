package com.ensup.partielwebservice.dao;

import java.util.List;

import com.ensup.partielwebservice.domaine.Cours;

public interface ICoursDao {

	void createCours(Cours cours);

	Cours getCours(Long id);

	List<Cours> getAllCours();

	void updateCours(Long id, Cours nCours);

	void deleteCours(Long id);

}