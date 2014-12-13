package org.uiowa.cs2820.engine;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.junit.Assert.*;


public class ServerTest extends JerseyTest {
		
    private void Load() {	
    	CheckPoint.reset();
    	DiskSpace.reset();
    	Indexer I = new Indexer("0.txt");
    	I.addField(new Field("not", "riparia"));
    	I = new Indexer("4.txt");
    	I.addField(new Field("not", "riparia"));
    	I = new Indexer("1.txt");
    	I.addField(new Field("not", "riparia"));
    }
	
    @Override
    protected ResourceConfig configure() {
    	ResourceConfig rc = new ResourceConfig(Server.class);
    	Load();
    	return rc;
    }
    
    @Test
    public void testSearchWithResults() {
    	String responseMsg = target("search")
    			.queryParam("q", "not%20riparia")
    			.request()
    			.get(String.class);
    	assertEquals("[1.txt, 4.txt, 0.txt]", responseMsg);
    }
    
    @Test
    public void testSearchNoResults() {
    	String responseMsg = target("search")
    			.queryParam("q", "notes%20riparia")
    			.request()
    			.get(String.class);
    	assertEquals("[]", responseMsg);
    }
    
    @Test
    public void testSearchWithBadQuery() {
    	Response response = target("search")
    			.queryParam("q", "not")
    			.request()
    			.get();
    	assertEquals(400, response.getStatus());
    }
    
    @Test
    public void testIndexWithValidSubmission() {
    	Response response = target("index")
    			.request()
    			.put(Entity.entity("id=file.txt&field=some%20words", 
    					MediaType.APPLICATION_FORM_URLENCODED));
    	assertEquals(response.getStatus(), 201);
    }    
    
    @Test
    public void testIndexWithNoId() {
    	Response response = target("index")
    			.request()
    			.put(Entity.entity("id=&field=some%20words", 
    					MediaType.APPLICATION_FORM_URLENCODED));
    	assertEquals(response.getStatus(), 400);
    }
    
    @Test
    public void testIndexWithBadField() {
    	Response response = target("index")
    			.request()
    			.put(Entity.entity("id=file.txt&field=some", 
    					MediaType.APPLICATION_FORM_URLENCODED));
    	assertEquals(response.getStatus(), 400);
    }
}