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

import service.CategoryService;

@Path("/categories")
public class CategoriesAPI {
	
	@GET
	@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listCategories() {
		
		JSONArray categories = CategoryService.listCategories();
		
		return categories.toString();
	}	

	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateCategories(String inputParms) {
		
		try {
			JSONObject result = CategoryService.updateCategory(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "updateCategoryAPI failed";
		}
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getCategory(@PathParam("id") Integer id) {
		
		JSONObject result = CategoryService.getCategory(id);
		
		return result.toString();
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addCategory(String inputParms) {
		
		try {
			JSONObject result = CategoryService.addCategory(new JSONObject(inputParms));
			
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
	public String deleteCategory(String inputParms) {
		
		try {
			JSONObject result = CategoryService.deleteCategory(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "deleteCategory API failed";
		}	
	}

}
