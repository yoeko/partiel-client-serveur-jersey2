package com.ensup.partielwebservice.dao;

import java.util.List;

import com.ensup.partielwebservice.domaine.Etudiant;

public interface IEtudiantDao {

	void createEtudiant(Etudiant etudiant);

	Etudiant getEtudiant(Long id);

	void updateStudent(Long id, Etudiant nEtudiant);

	List<Etudiant> getAllStudent();

	void deleteEtudiant(Long id);

	Etudiant getEtudiantByEmail(String email);

	List<Etudiant> getStudentByResearch(String firstNameR, String lastNameR);

}