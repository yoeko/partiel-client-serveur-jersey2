package service;

import java.util.List;

import javax.ws.rs.core.Response;

import domaine.Etudiant;

public interface IStudentServiceClient {

	List<Etudiant> getListStudent();

	Response createStudent(Etudiant student);

	Etudiant getStudentById(Long id);

	List<Etudiant> getStudentByFirstAndLastName(String first_name, String last_name);

	Response deleteStudent(int id);

	Response updateStudent(Long id, Etudiant etudiant);

}