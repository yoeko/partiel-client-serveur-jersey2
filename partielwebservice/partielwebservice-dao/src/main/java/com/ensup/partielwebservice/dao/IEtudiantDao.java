package com.ensup.partielwebservice.dao;

import java.util.List;

import com.ensup.partielwebservice.domaine.Etudiant;

public interface IEtudiantDao {

	/**
	 * Methode de creation d'etudiant
	 * @param etudiant
	 */
	void createEtudiant(Etudiant etudiant);

	/**
	 * Methode de recherche d'etudiant par son id
	 * @param id
	 * @return un etudiant
	 */
	Etudiant getEtudiant(Long id);

	/**
	 * Methode de recherche d'etudiant par son email
	 * @param email
	 * @return
	 */
	Etudiant getEtudiantByEmail(String email);

	/**
	 * Methode de recherche d'etudiant par son firstName et lastName
	 * @param firstNameR
	 * @param lastNameR
	 * @return
	 */
	List<Etudiant> getStudentByResearch(String firstNameR, String lastNameR);

	/**
	 * Methode modifier un etudiant
	 * @param id
	 * @param nEtudiant
	 */
	void updateStudent(Long id, Etudiant nEtudiant);

	/**
	 * Methode recuperer tous les etudiants
	 * @return
	 */
	List<Etudiant> getAllStudent();

	/**
	 * Methode pour supprimer un etudiant
	 * @param id
	 */
	void deleteEtudiant(Long id);

}