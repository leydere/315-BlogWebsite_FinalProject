package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Category;

public class CategoryService {
	
	public static JSONArray listCategories() {
		
		JSONArray results = new JSONArray(); 
		
		Category category = new Category();
		results = category.listCategories();
		
		return results;
		
	}
	
	public static JSONObject getCategory(int id) {
		
		JSONObject jo = new JSONObject();
		
		Category category = new Category();
		category.setCategoryID(id);
		
		jo = category.getCategory();
		
		return jo;
		
	}
	
	public static JSONObject updateCategory(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();

		try {
		
			int categoryID = inputParms.getInt("categoryID");
			int navigationID = inputParms.getInt("navigationID");
			String categoryName = inputParms.getString("categoryName");
			String categoryImage = inputParms.getString("categoryImage");
			String categoryContent = inputParms.getString("categoryContent");
			int categoryOrder = inputParms.getInt("categoryOrder");
			int categoryVisible = inputParms.getInt("categoryVisible");
						
			Category category = new Category();
			category.setCategoryID(categoryID);
			category.setNavigationID(navigationID);
			category.setCategoryName(categoryName);
			category.setCategoryImage(categoryImage);
			category.setCategoryContent(categoryContent);
			category.setCategoryOrder(categoryOrder);
			category.setCategoryVisible(categoryVisible);
			
			message = category.updateCategory();
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject addCategory(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();

		try {
			
			int navigationID = inputParms.getInt("navigationID");
			String categoryName = inputParms.getString("categoryName");
			String categoryImage = inputParms.getString("categoryImage");
			String categoryContent = inputParms.getString("categoryContent");
			int categoryOrder = inputParms.getInt("categoryOrder");
			int categoryVisible = inputParms.getInt("categoryVisible");
			
			
			Category category = new Category();
			category.setNavigationID(navigationID);
			category.setCategoryName(categoryName);
			category.setCategoryImage(categoryImage);
			category.setCategoryContent(categoryContent);
			category.setCategoryOrder(categoryOrder);
			category.setCategoryVisible(categoryVisible);
			
			message = category.addCategory();
				
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject deleteCategory(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();

		try {
			
			int categoryID = inputParms.getInt("categoryID");
			
			Category category = new Category();
			category.setCategoryID(categoryID);
				
		message = category.deleteCategory();
				
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
