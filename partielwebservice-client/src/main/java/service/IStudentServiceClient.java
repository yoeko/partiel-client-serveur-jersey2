package service;

import java.util.List;

import javax.ws.rs.core.Response;

import domaine.Etudiant;

public interface IStudentServiceClient {

	/**
	 * Methode pour recuperer la liste des etudiants
	 * @return 
	 */
	List<Etudiant> getListStudent();

	/**
	 * Methode pour crée un étudiant
	 * @param student
	 * @return 
	 */

	Response createStudent(Etudiant student);

	/**
	 * Methode pour recuperer un etudiant par son id
	 * @param id
	 * @return
	 */
	Etudiant getStudentById(Long id);

	/**
	 * ethode de recherche d'etudiant par son nom et prenom
	 * @param first_name
	 * @param last_name
	 * @return
	 */
	List<Etudiant> getStudentByFirstAndLastName(String first_name, String last_name);

	/**
	 * Methode de suppression d'etudiant
	 * @param id
	 * @return
	 */
	Response deleteStudent(int id);

	/**
	 * Methode de mise a jour des informations d'un etudiant
	 * @param id
	 * @param etudiant
	 * @return
	 */
	Response updateStudent(Long id, Etudiant etudiant);

}