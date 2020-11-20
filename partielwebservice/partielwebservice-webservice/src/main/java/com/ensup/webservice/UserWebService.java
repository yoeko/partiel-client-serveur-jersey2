package com.ensup.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ensup.partielwebservice.domaine.User;
import com.ensup.partielwebservice.service.UserService;



@Path("/json/user")
public class UserWebService {
	
	private UserService userService = new UserService();
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserInJson() {

		User user = new User();
		user.setLogin("admin");
		user.setPassword("admin");

		return user;

	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(User user) {

		User result = userService.getUser(user.getLogin(), user.getPassword());
		return result;

	}

}
