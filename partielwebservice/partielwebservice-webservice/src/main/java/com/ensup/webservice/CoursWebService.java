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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ensup.partielwebservice.dao.CoursDao;
import com.ensup.partielwebservice.dao.ICoursDao;
import com.ensup.partielwebservice.domaine.Cours;
import com.ensup.partielwebservice.service.CoursService;
import com.ensup.partielwebservice.service.UserService;

@Path("/json/cours")
public class CoursWebService {

	private ICoursDao dao = new CoursDao();
	private CoursService coursService = new CoursService(dao);
	private static final Logger webServiceLogger = LogManager.getLogger(CoursWebService.class);
	
	/**
	 * Method get All Cours
	 * @return
	 */
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cours> getAll() {
		webServiceLogger.info("Module WebService, Méthode get All Cours");
		return coursService.getAllCours();
	}
	
	/**
	 * Method get Cours by id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/detail/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cours getById(@PathParam(value ="id") Long id) {
		webServiceLogger.info("Module WebService, Méthode get Cours By Id");
		return coursService.getCours(id);
	}
	
//	@GET
//	@Path("/research/{first_name}/{last_name}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Cours> getStudentByResearch(@PathParam(value ="first_name") String first_name, @PathParam(value ="last_name") String last_name) {
//		return coursService.getStudentByResearch(first_name, last_name);
//	}
	
	/**
	 * Method for create Cours
	 * @param Cours
	 */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createCours(Cours Cours) {		
		webServiceLogger.info("Module WebService, Méthode get create Cours");
		coursService.createCours(Cours);
	}
	
	/**
	 * Method for update Cours
	 * @param id
	 * @param Cours
	 */
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCours(@PathParam(value ="id") Long id, Cours Cours) {		
		webServiceLogger.info("Module WebService, Méthode get update Cours");
		coursService.updateCours(id, Cours);
	}
	
	/**
	 * Method for delete cours
	 * @param id
	 */
	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteCours(@PathParam(value ="id") Long id) {	
		webServiceLogger.info("Module WebService, Méthode get delete Cours");
		coursService.deleteCours(id);
	}
}
