package service;

import java.util.List;

import domaine.Cours;

public interface ICoursServiceClient {

	List<Cours> getAllCours();

	Cours getCoursById(Long id);

	void createCours(Cours cours);

	void updateCours(Long id, Cours cours);

	void deleteCours(Long id);

}