package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;

import service.ClientService;

@Path("/{type}")
public class ClientAPI {
	
	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String update(String inputParms, @PathParam("type") String type) {
		
		try {
			String result = ClientService.update(new JSONObject(inputParms), type);
			
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "updateCategoryAPI failed";
		}
		
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String add(String inputParms, @PathParam("type") String type) {
		
		try {
			String result = ClientService.add(new JSONObject(inputParms), type);
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "addCategory API failed";
		}	
	}
	
	@POST
	@Path("/delete/")
	@Produces("application/json")
	@Consumes("application/json")
	public String delete(String inputParms, @PathParam("type") String type) {
		
		try {
			String result = ClientService.delete(new JSONObject(inputParms), type);
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "deleteCategory API failed";
		}	
	}

}
