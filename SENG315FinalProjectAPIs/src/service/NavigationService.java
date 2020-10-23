package service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.Category;
import model.Navigation;

public class NavigationService {
	
	public static JSONArray listVisibleNavigations() {
		
		JSONArray navigations = new JSONArray();
		JSONArray categories = new JSONArray();
		
		Navigation navigation = new Navigation();
		navigations = navigation.listVisibleNavigations();
		
		for(int i = 0; i < navigations.length(); i++) {
			Category category = new Category();
			
			try {
				
			category.setNavigationID(navigations.getJSONObject(i).getInt("navigationID"));
			categories = category.listCatByNav();
			
			if(!categories.isNull(0)) {
				navigations.getJSONObject(i).put("categories", categories);
			}
			
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return navigations;		
	}
	
	public static JSONArray listNavigations() {
		
		JSONArray results = new JSONArray(); 
		
		Navigation navigation = new Navigation();
		results = navigation.listNavigations();
		
		return results;		
	}
	
	public static JSONObject getNavigation(int id) {
		
		JSONObject jo = new JSONObject();
		
		Navigation navigation = new Navigation();
		navigation.setNavigationID(id);
		
		jo = navigation.getNavigation();
		
		return jo;		
	}
	
	public static JSONObject updateNavigation(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();

		try {
		
			int navigationID = inputParms.getInt("navigationID");
			String navigationName = inputParms.getString("navigationName");
			String navigationURL = inputParms.getString("navigationURL");
			int navigationVisible = inputParms.getInt("navigationVisible");
			int navigationOrder = inputParms.getInt("navigationOrder");
			
			Navigation navigation = new Navigation();
			navigation.setNavigationID(navigationID);
			navigation.setNavigationName(navigationName);
			navigation.setNavigationURL(navigationURL);
			navigation.setNavigationVisible(navigationVisible);
			navigation.setNavigationOrder(navigationOrder);
			
			message = navigation.updateNavigation();
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject addNavigation(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();

		try {
			
			String navigationName = inputParms.getString("navigationName");
			String navigationURL = inputParms.getString("navigationURL");
			int navigationVisible = inputParms.getInt("navigationVisible");
			int navigationOrder = inputParms.getInt("navigationOrder");
			
			Navigation navigation = new Navigation();
			navigation.setNavigationName(navigationName);
			navigation.setNavigationURL(navigationURL);
			navigation.setNavigationVisible(navigationVisible);
			navigation.setNavigationOrder(navigationOrder);
				
		message = navigation.addNavigation();
				
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject deleteNavigation(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();

		try {
			
			int navigationID = inputParms.getInt("navigationID");
			
			Navigation navigation = new Navigation();
			navigation.setNavigationID(navigationID);
				
		message = navigation.deleteNavigation();
				
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
