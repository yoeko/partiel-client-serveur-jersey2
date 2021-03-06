package service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domaine.Cours;

public class CoursServiceClient implements ICoursServiceClient  {
	
	private static final String url = "http://localhost:8080/partielwebservice-webservice/rest/json/cours/";
	
	public CoursServiceClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Methode pour recupere la liste des cours
	 * @return
	 */
	@Override
	public List<Cours> getAllCours(){
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("get");
		Response response = webTarget.request("application/json").get();
		return response.readEntity(new GenericType<List<Cours>>() {});
		
	}
	
	/**
	 * Methode pour rechercher un cours par son id
	 * @param id
	 * @return
	 */
	@Override
	public Cours getCoursById(Long id) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("detail/"+id);
		
		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(Cours.class);
		
	}
	
	/**
	 * Methode pour créer un cours
	 * @param cours
	 * @return
	 */
	@Override
	public Response createCours(Cours cours) {
		
		Client client  = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("create");
		Response response = webTarget.request("application/json").post(Entity.entity(cours, MediaType.APPLICATION_JSON));
		return response;
	}
	
	/**
	 * Methode pour modifie un cours
	 * @param id
	 * @param cours
	 * @return
	 */
	@Override
	public Response updateCours(Long id , Cours cours) {
		
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("update/"+id);
		Response response = webTarget.request("application/json").put(Entity.entity(cours, MediaType.APPLICATION_JSON));
		return response;
	}
	
	/**
	 * Methode pour supprimer un cours
	 * @param id
	 * @return
	 */
	@Override
	public Response deleteCours(Long id) {
		
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget =  client.target(url).path("delete/"+id);
		Response response = webTarget.request("application/json").delete();
		return response;
		
	}


}
