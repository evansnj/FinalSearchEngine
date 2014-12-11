package org.uiowa.cs2820.engine;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
    	return "Hello, Jersey!\n";
    }
    
    // Should this return a JSON array of results? Or some structure fit for a template?
    @GET
    @Path("search")
    @Produces(MediaType.TEXT_PLAIN) //TODO: change to actually useful type
    public Response search(@QueryParam("q") String q) {
//    	System.out.println(q);
    	//Make the whitespace-separated query into a list
    	List<String> ql = Arrays.asList(q.split("\\s+"));
//    	for (String elem : ql) {
//    		System.out.println(elem);
//    	}
    	Field f = new Field(ql.get(0), ql.get(1)); //TODO: limit q terms to 2
    	FieldSearch fs = new FieldSearch(f);
    	String[] s = fs.findEquals();
    	String results = Arrays.toString(s);
    	System.out.println(results);
    	return Response //TODO: change to a useful response
    			.status(200)
    			.entity("search query: " + ql.toString() +
    					"\n     results: " + results).build();
    //URL: http://localhost:8080/search?q=not%20riparia
    //response: "search query: [not riparia]
    //                results: [1.txt, 4.txt, 0.txt]"
    
    }
}

