package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import model.APICall;

public class AuthenticationService {
	
	public static String authenticate(JSONObject inputParms,HttpServletRequest request) {
		
		APICall apiCall = new APICall();
		apiCall.setApiURL("http://localhost:8080/SENG315FinalProjectAPIs/rest/users/authenticate/");
		apiCall.setRequestMethod("POST");
		apiCall.setRequestProperty("application/json");
		
		String apiResult = apiCall.makeAPICall(inputParms);

		try {
			
			JSONObject results = new JSONObject(apiResult);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn", null);
			
			if(results.getString("message").contentEquals("success")) {
				session.setMaxInactiveInterval(-1); //-1 does not expire until page is closed. 43200 = (12*60*60) * hour login timeout.
				session.setAttribute("loggedIn", true);
				session.setAttribute("username", inputParms.getString("username"));
				session.setAttribute("userID", results.getString("userID"));
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return apiResult;
	}

}
