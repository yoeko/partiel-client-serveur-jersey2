package service;

import java.util.List;

import domaine.Etudiant;

public interface IStudentServiceClient {

	List<Etudiant> getListStudent();

	void createStudent(Etudiant student);

	Etudiant getStudentById(Long id);

	List<Etudiant> getStudentByFirstAndLastName(String first_name, String last_name);

	void deleteStudent(int id);

	void updateStudent(Long id, Etudiant etudiant);

}