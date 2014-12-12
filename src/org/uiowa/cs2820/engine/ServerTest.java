package org.uiowa.cs2820.engine;

import java.io.InputStream;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.internal.util.collection.MultivaluedStringMap;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ServerTest extends JerseyTest {
	
	private HttpServer server;
	private WebTarget target;
	
    
    @Override
    protected ResourceConfig configure() {
    	ResourceConfig rc = new ResourceConfig(Server.class);
    	DatabaseLoader.Load();
    	return rc;
    }
    
    @Test
    public void testSayHello() {
        String responseMsg = target("/").request().get(String.class);
        assertEquals("Hello, Jersey!", responseMsg);
    }
    
    @Test
    public void testSearch() {
    	String responseMsg = target("search")
    			.queryParam("q", "not%20riparia")
    			.request()
    			.get(String.class);
    	assertEquals("[1.txt, 4.txt, 0.txt]", responseMsg);
    	
    	
    }
    
}