package com.ensup.partielwebservice.service;

import java.util.List;

import com.ensup.partielwebservice.domaine.Etudiant;

public interface IEtudiantService {
	
	/**
	 * create Etudiant
	 * @param etudiant
	 */
	void createEtudiant(Etudiant etudiant);
	
	/**
	 * get Etudiant
	 * @param id
	 * @return
	 */
	Etudiant getEtudiant(Long id);
	
	/**
	 * update Student
	 * @param id
	 * @param nEtudiant
	 */
	void updateStudent(Long id, Etudiant nEtudiant);
	
	/**
	 * get All Student
	 * @return
	 */
	List<Etudiant> getAllStudent();
	
	/**
	 * get Student by Research
	 * @param firstName
	 * @param lastNameR
	 * @return
	 */
	List<Etudiant> getStudentByResearch(String firstName, String lastNameR);
	
	/**
	 * delete Student
	 * @param id
	 */
	void deleteEtudiant(Long id);

}