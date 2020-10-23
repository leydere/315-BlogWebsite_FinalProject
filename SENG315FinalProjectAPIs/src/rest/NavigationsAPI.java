package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import service.NavigationService;

@Path("/navigations")
public class NavigationsAPI {

	@GET
	@Path("/listvisible/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listVisibleNavigations() {
		
		JSONArray navigations = NavigationService.listVisibleNavigations();
		
		return navigations.toString();
	}	
	
	@GET
	@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listNavigations() {
		
		JSONArray navigations = NavigationService.listNavigations();
		
		return navigations.toString();
	}	

	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateNavigations(String inputParms) {
		
		try {
			JSONObject result = NavigationService.updateNavigation(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "updateNavigationAPI failed";
		}
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getNavigation(@PathParam("id") Integer id) {
		
		JSONObject navigation = NavigationService.getNavigation(id);
		
		return navigation.toString();
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addNavigation(String inputParms) {
		
		try {
			JSONObject result = NavigationService.addNavigation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "addNavigation API failed";
		}	
	}
	
	@POST
	@Path("/delete/")
	@Produces("application/json")
	@Consumes("application/json")
	public String deleteNavigation(String inputParms) {
		
		try {
			JSONObject result = NavigationService.deleteNavigation(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "deleteNavigation API failed";
		}	
	}
}
