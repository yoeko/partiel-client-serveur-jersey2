package service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	
	public void createStudent(Etudiant student)
	{

		Client client = ClientBuilder.newClient();

		WebTarget webTarget = client.target(url).path("create");

		ObjectMapper objectMapper = new ObjectMapper();
		String input;
		
		try {
			input = objectMapper.writeValueAsString(student);
			System.out.println(input);
			Response response = webTarget.request("application/json").post(Entity.json(input));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	
}
