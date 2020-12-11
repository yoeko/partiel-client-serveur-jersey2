package service;

import java.util.List;

import javax.ws.rs.core.Response;

import domaine.Cours;

public interface ICoursServiceClient {

	List<Cours> getAllCours();

	Cours getCoursById(Long id);

	Response createCours(Cours cours);

	Response updateCours(Long id, Cours cours);

	Response deleteCours(Long id);

}