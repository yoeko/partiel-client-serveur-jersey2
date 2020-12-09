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


import com.fasterxml.jackson.databind.ObjectMapper;

import domaine.User;

public class UserServiceClient {
	
	
	private String url = "http://localhost:8080/partielwebservice/rest/json/user/";
	ObjectMapper mapper =  new ObjectMapper();
	
	
	public User login(User user)  {
		
		/*
		 * System.out.println("dans le service" + user.getLogin());
		 * 
		 * String userMapper = "{\"login\":\"" + user.getLogin() + "\", \"password\":\""
		 * + user.getPassword() + "\"}";
		 * 
		 * Response response = invocationBuilder.post(Entity.entity(userMapper,
		 * MediaType.APPLICATION_JSON));
		 * 
		 * User userResponse = response.readEntity(User.class);
		 * 
		 * System.out.println("the user found"+userResponse.getLast_name()); return
		 * userResponse;
		 */
		
		return user;
		
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
