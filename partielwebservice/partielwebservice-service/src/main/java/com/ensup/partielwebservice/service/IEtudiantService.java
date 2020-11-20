package com.ensup.partielwebservice.service;

import java.util.List;

import com.ensup.partielwebservice.domaine.Etudiant;

public interface IEtudiantService {

	void createEtudiant(Etudiant etudiant);

	Etudiant getEtudiant(Long id);

	void updateStudent(Long id, Etudiant nEtudiant);

	List<Etudiant> getAllStudent();
	
	List<Etudiant> getStudentByResearch(String firstName, String lastNameR);

	void deleteEtudiant(Long id);

}