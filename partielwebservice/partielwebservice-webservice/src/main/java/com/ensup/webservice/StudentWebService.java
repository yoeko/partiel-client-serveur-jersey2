package com.ensup.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ensup.partielwebservice.dao.EtudiantDao;
import com.ensup.partielwebservice.dao.IEtudiantDao;
import com.ensup.partielwebservice.domaine.Etudiant;
import com.ensup.partielwebservice.service.EtudiantService;
import com.ensup.partielwebservice.service.IEtudiantService;

@Path("/json/student")
public class StudentWebService {
	
	private IEtudiantDao dao = new EtudiantDao();
	private EtudiantService studentService = new EtudiantService(dao);
	
	/**
	 * Method for get All Student
	 * @return
	 */
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> getAll() {
		return studentService.getAllStudent();
	}
	
	/**
	 * Method for get a Student by id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/detail/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getById(@PathParam(value ="id") Long id) {
		return studentService.getEtudiant(id);
	}
	
	/**
	 * Method for get Student by firstname and lastname
	 * @param first_name
	 * @param last_name
	 * @return
	 */
	@GET
	@Path("/research/{first_name}/{last_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> getStudentByResearch(@PathParam(value ="first_name") String first_name, @PathParam(value ="last_name") String last_name) {
		return studentService.getStudentByResearch(first_name, last_name);
	}
	
	/**
	 * Method for create Student 
	 * @param etudiant
	 */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createStudent(Etudiant etudiant) {		
		studentService.createEtudiant(etudiant);
	}
	
	/**
	 * Method for update Student
	 * @param id
	 * @param etudiant
	 */
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createStudent(@PathParam(value ="id") Long id, Etudiant etudiant) {		
		studentService.updateStudent(id, etudiant);
	}
	
	/**
	 * Method for delete Student
	 * @param id
	 */
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteStudent(@PathParam(value ="id") Long id) {		
		studentService.deleteEtudiant(id);
	}
}
