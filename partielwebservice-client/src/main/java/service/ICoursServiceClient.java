package service;

import java.util.List;

import javax.ws.rs.core.Response;

import domaine.Cours;

public interface ICoursServiceClient {

	/**
	 * Methode pour recupere la liste des cours
	 * @return
	 */
	List<Cours> getAllCours();

	/**
	 * Methode pour rechercher un cours par son id
	 * @param id
	 * @return
	 */
	Cours getCoursById(Long id);

	/**
	 * Methode pour créer un cours
	 * @param cours
	 * @return
	 */
	Response createCours(Cours cours);

	/**
	 * Methode pour modifie un cours
	 * @param id
	 * @param cours
	 * @return
	 */
	Response updateCours(Long id, Cours cours);

	/**
	 * Methode pour supprimer un cours
	 * @param id
	 * @return
	 */
	Response deleteCours(Long id);

}