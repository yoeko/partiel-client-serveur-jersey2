package com.ensup.jerseyconfig;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class JerseyConfiguration extends ResourceConfig{
		
	public JerseyConfiguration() {
		
		packages("com.ensup.webservice");
	}
	
}
