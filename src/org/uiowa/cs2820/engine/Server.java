package org.uiowa.cs2820.engine;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.collection.MultivaluedStringMap;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONTokener;
import org.codehaus.jettison.json.JSONException;


//Root resource (exposed at "/" path, i.e., at "http://localhost:8080/" )
@Path("/")
public class Server { 

    
    // Current state: only uses the first two search terms
    @GET
    @Path("search")
    @Produces(MediaType.TEXT_PLAIN) //TODO: change to actually useful type
    public Response search(@QueryParam("q") String q) {
//    	System.out.println(q);
    	// Extract search terms from querystring
    	List<String> params = Arrays.asList(q.split("\\s+"));
//    	for (String elem : params) {
//    		System.out.println(elem);
//    	}
    	Field f = new Field(params.get(0), params.get(1)); //TODO: limit q terms to 2
    	FieldSearch fs = new FieldSearch(f);
    	String[] s = fs.findEquals();
    	String results = Arrays.toString(s);
//    	System.out.println(results);
    	return Response
    			.status(200)
    			.entity(results).build();
    //URL: http://localhost:8080/search?q=not%20riparia
    //response: "[1.txt, 4.txt, 0.txt]"
    }
    
    // What should be allowed to be indexed?
    // Using a two-string field for now, similar to searching
    @PUT
    @Path("index")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response index(
    		@FormParam("id") String id,
    		@FormParam("field") String fields) {
    	
    	// Extract index text from querystring
    	List<String> params = Arrays.asList(fields.split("\\s+"));
    	
    	// Crude validation for parameters
    	Boolean invalidParams = ((params.size() % 2) != 0);
    	Boolean missingId = (id.length() == 0);
    	if (invalidParams || missingId ) {
    		return Response.status(400).entity("Invalid form data submitted.").build();
    	}
    	
    	// Index the new object
    	Field f = new Field(params.get(0), params.get(1)); //TODO: limit q terms to 2
    	Indexer I = new Indexer(id);
    	I.addField(f);
    	return Response
    			.status(201)
    			.build();
    }
}

