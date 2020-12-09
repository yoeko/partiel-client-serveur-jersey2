package service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;



import domaine.User;

public class UserServiceClient {
	
	
	private String url = "http://localhost:8080/partielwebservice-webservice/rest/json/user/";
	
	
	public User login(User user)  {
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(url).path("login");
		
		Response response = webTarget.request("application/json").post(Entity.entity(user, MediaType.APPLICATION_JSON));
		 
		  User userResponse = response.readEntity(User.class);
		  
		  System.out.println("the user found"+userResponse.getLast_name()); 
		  return userResponse;
		 

		
	}
	
	
	public User getUser() {
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonJsonProvider.class);
		
		Client client = ClientBuilder.newClient(clientConfig);
		WebTarget webTarget = client.target(url).path("get");
		
		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(User.class);
	}

}
