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
    
    // Resource for searching the database
    @GET
    @Path("search")
    @Produces(MediaType.TEXT_PLAIN) 
    public Response search(@QueryParam("q") String q) {
    	// Extract search terms from querystring
    	List<String> params = Arrays.asList(q.split("\\s+"));
    	Boolean invalidParams = ((params.size() % 2) != 0);
    	//Bail if there is not a complete search string
    	if (invalidParams) {
    		return Response.status(400).entity("Invalid query submitted.").build();
    	}
    	Field f = new Field(params.get(0), params.get(1));
    	FieldSearch fs = new FieldSearch(f);
    	String[] s = fs.findEquals();
    	String results = Arrays.toString(s);
    	return Response.status(200).entity(results).build();
    //URL: http://127.0.0.1:8080/search?q=not%20riparia
    //response: "[1.txt, 4.txt, 0.txt]"
    }
    
    // Resource for indexing new data
    @PUT
    @Path("index")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response index(
    		@FormParam("id") String id,
    		@FormParam("field") String fields) {
    	// Extract index text from form submission
    	List<String> params = Arrays.asList(fields.split("\\s+"));
    	// Crude validation for parameters
    	Boolean invalidParams = ((params.size() % 2) != 0);
    	Boolean missingId = (id.length() == 0);
    	if (invalidParams || missingId ) {
    		return Response.status(400).entity("Invalid form data submitted.").build();
    	}
    	// Index the new object
    	Field f = new Field(params.get(0), params.get(1));
    	Indexer I = new Indexer(id);
    	I.addField(f);
    	return Response.status(201).build();
    }
}

