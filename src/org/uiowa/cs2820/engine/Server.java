package org.uiowa.cs2820.engine;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

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
}

