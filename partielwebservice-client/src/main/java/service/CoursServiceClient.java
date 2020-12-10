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

public class CoursServiceClient implements ICoursServiceClient {
	
	private static final String url = "http://localhost:8080/partielwebservice-webservice/rest/json/cours/";
	
	
	@Override
	public List<Cours> getAllCours(){
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("get");
		Response response = webTarget.request("application/json").get();
		return response.readEntity(new GenericType<List<Cours>>() {});
		
	}
	
	@Override
	public Cours getCoursById(Long id) {
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("detail/"+id);
		
		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(Cours.class);
		
	}
	
	@Override
	public void createCours(Cours cours) {
		
		Client client  = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("create");
		Response response = webTarget.request("application/json").post(Entity.entity(cours, MediaType.APPLICATION_JSON));
	}
	
	@Override
	public void updateCours(Long id , Cours cours) {
		
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget = client.target(url).path("update/"+id);
		
		Response response = webTarget.request("application/json").put(Entity.entity(cours, MediaType.APPLICATION_JSON));
	}
	
	@Override
	public void deleteCours(Long id) {
		
		
		Client client = ClientBuilder.newClient();
		
		WebTarget webTarget =  client.target(url).path("delete/"+id);
		Response response = webTarget.request("application/json").delete();
		
	}


}
