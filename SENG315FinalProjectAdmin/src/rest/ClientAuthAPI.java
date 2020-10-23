package rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.json.JSONException;
import org.json.JSONObject;

import service.AuthenticationService;

@Path("/authenticate/")
public class ClientAuthAPI {
	
	@Context private HttpServletRequest request;
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String authenticate(String inputParms) {
		
		try {
			
			String result = AuthenticationService.authenticate(new JSONObject(inputParms),request);
			
			return result;
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "ClientAuthenticateAPI failed";
		}	
	}

}
