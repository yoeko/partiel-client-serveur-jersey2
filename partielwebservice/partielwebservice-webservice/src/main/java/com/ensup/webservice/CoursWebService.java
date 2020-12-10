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

import com.ensup.partielwebservice.dao.CoursDao;
import com.ensup.partielwebservice.dao.ICoursDao;
import com.ensup.partielwebservice.domaine.Cours;
import com.ensup.partielwebservice.service.CoursService;

@Path("/json/cours")
public class CoursWebService {

	private ICoursDao dao = new CoursDao();
	private CoursService coursService = new CoursService(dao);
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cours> getAll() {
		return coursService.getAllCours();
	}
	
	@GET
	@Path("/detail/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cours getById(@PathParam(value ="id") Long id) {
		return coursService.getCours(id);
	}
	
//	@GET
//	@Path("/research/{first_name}/{last_name}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Cours> getStudentByResearch(@PathParam(value ="first_name") String first_name, @PathParam(value ="last_name") String last_name) {
//		return coursService.getStudentByResearch(first_name, last_name);
//	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createCours(Cours Cours) {		
		coursService.createCours(Cours);
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCours(@PathParam(value ="id") Long id, Cours Cours) {		
		coursService.updateCours(id, Cours);
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteCours(@PathParam(value ="id") Long id) {		
		coursService.deleteCours(id);
	}
}
