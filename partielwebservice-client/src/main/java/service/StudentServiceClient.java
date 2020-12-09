package service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import domaine.Etudiant;
import domaine.User;

public class StudentServiceClient {

	
	private String url = "http://localhost:8080/partielwebservice-webservice/rest/json/student/";
	
	public List<Etudiant> getListStudent(){
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(url).path("get");
		
		Response response = webTarget.request("application/json").get();
		 
		  List<Etudiant> listEtudiant = response.readEntity(new GenericType<List<Etudiant>>() {});
		  
		  return listEtudiant;
		
	}

	public Etudiant getStudentById(int id) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(url).path("detail/"+id);
		
		Response response = webTarget.request("application/json").get();
 
		  return response.readEntity(Etudiant.class);
		
	}
	
	public List<Etudiant> getStudentByFirstAndLastName(String first_name , String last_name) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(url).path("research/"+first_name+"/"+last_name);
		
		Response response = webTarget.request("application/json").get();
		  List<Etudiant> listEtudiant = response.readEntity(new GenericType<List<Etudiant>>() {});
 
		  return listEtudiant;
		
	}
	
	
	
}
