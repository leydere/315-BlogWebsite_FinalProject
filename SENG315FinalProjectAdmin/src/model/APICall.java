package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.json.JSONObject;

public class APICall {
	
	String apiURL;
	String requestMethod;
	String requestProperty;
	String apiKey = "1234567890";
	
	public APICall() {
		
	}
	
	public String makeAPICall(JSONObject inputParms) {
		
		String apiResult = "";
		
		byte[] encodedKey = Base64.getEncoder().encode(apiKey.getBytes(StandardCharsets.UTF_8));
		
		System.out.println("encodedKey: " + new String(encodedKey));

		 try {
				URL url = new URL(apiURL);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod(requestMethod);
				connection.setRequestProperty("Content-Type", requestProperty);
				//connection.setRequestProperty("apiKey",apiKey); //connected to ArticlesAPI.java updateArticle() function commented out lines -ERL
				connection.setDoOutput(true);
				connection.setRequestProperty("Authorization", new String(encodedKey));
				
				byte[] outputBytes = inputParms.toString().getBytes("UTF-8");
				OutputStream os = connection.getOutputStream();
				os.write(outputBytes);
				os.close();

				if (connection.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
				}

				BufferedReader reader = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));

				String line;
				
				while ((line = reader.readLine()) != null) {
					apiResult += line; 
				}

				connection.disconnect();
				
			  } catch (MalformedURLException e) {
				  e.printStackTrace();
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
		 
		 return apiResult;	
	}

	public String getApiURL() {
		return apiURL;
	}

	public void setApiURL(String apiURL) {
		this.apiURL = apiURL;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestProperty() {
		return requestProperty;
	}

	public void setRequestProperty(String requestProperty) {
		this.requestProperty = requestProperty;
	}
	
	

}

