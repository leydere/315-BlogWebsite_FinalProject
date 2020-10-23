package service;

import org.json.JSONObject;

import model.APICall;

public class ClientService {
	
	public static String update(JSONObject inputParms, String type) {
		
		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315FinalProjectAPIs/rest/"+type+"/update/");
		apiCall.setRequestMethod("POST");
		apiCall.setRequestProperty("application/json");
		
		String apiResult = apiCall.makeAPICall(inputParms);
		
		return apiResult;
	}
	
	public static String add(JSONObject inputParms, String type) {
		
		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315FinalProjectAPIs/rest/"+type+"/add/");
		apiCall.setRequestMethod("POST");
		apiCall.setRequestProperty("application/json");
		
		String apiResult = apiCall.makeAPICall(inputParms);
		
		return apiResult;
	}
	
	public static String delete(JSONObject inputParms, String type) {
		
		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315FinalProjectAPIs/rest/"+type+"/delete/");
		apiCall.setRequestMethod("POST");
		apiCall.setRequestProperty("application/json");
		
		String apiResult = apiCall.makeAPICall(inputParms);
		
		return apiResult;
	}

}
