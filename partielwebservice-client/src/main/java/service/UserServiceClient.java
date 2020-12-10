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

public class UserServiceClient implements IUserServiceClient {
	
	
	private static final String url = "http://localhost:8080/partielwebservice-webservice/rest/json/user/";
		
	public UserServiceClient() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public User login(User user)  {
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url).path("login");
		
		Response response = webTarget.request("application/json").post(Entity.entity(user, MediaType.APPLICATION_JSON));
		 
		  User userResponse = response.readEntity(User.class);
		  
		  System.out.println("the user found"+userResponse.getLast_name()); 
		  return userResponse;
		 

		
	}
	
	
	@Override
	public User getUser() {
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(url).path("get");
		
		Response response = webTarget.request("application/json").get();
		
		return response.readEntity(User.class);
	}

}
