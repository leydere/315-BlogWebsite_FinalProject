package model;

import java.sql.Connection;
import java.sql.ResultSetMetaData;

import org.json.JSONArray;
import org.json.JSONObject;

public class SQLQuery {
	
	String sqlString;
	
	public SQLQuery(){
		
	}

	public JSONArray lstQuery() {
		
		//ResultSet=>JSON object=>JSON Array
        JSONObject jsonObject = null;
        JSONArray jsonArray = new JSONArray();
	    
 		try{
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
 		
		 	java.sql.Statement stmt = connection.createStatement(
		 			java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, 
		 			java.sql.ResultSet.CONCUR_READ_ONLY);
		    
		    java.sql.ResultSet lstResult = stmt.executeQuery(sqlString);
		   
            while (lstResult.next()) {
            	 
                ResultSetMetaData metaData = lstResult.getMetaData();
                jsonObject = new JSONObject();
                
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                	
                	String columnName = metaData.getColumnLabel(i + 1);
                	String fieldValue = lstResult.getString(columnName);
                	
                	if(lstResult.wasNull()) {
                		fieldValue = "";
                	}
 
                	jsonObject.put(columnName, fieldValue.trim()); //failing when database contains NULL values; potential fix 4/19/20 -ERL
                }
                
                jsonArray.put(jsonObject);
            }
		    
		    //Close Connections
            try { if (lstResult!= null) lstResult.close(); } catch (Exception e) {};
            try { if (stmt!= null) stmt.close(); } catch (Exception e) {};
            try { if (connection!= null) connection.close(); } catch (Exception e) {};
	    
 		} catch (Exception e) {
 		    e.printStackTrace();
 		}
 		

 		return jsonArray;
		
	}
	
	public JSONObject getQuery() {
		
		//ResultSet=>JSON object
        JSONObject jsonObject = new JSONObject();
	    
 		try{
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
 		
		 	java.sql.Statement stmt = connection.createStatement(
		 			java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, 
		 			java.sql.ResultSet.CONCUR_READ_ONLY);
		    
		    java.sql.ResultSet getResult = stmt.executeQuery(sqlString);
		   
            while (getResult.next()) {
            	 
                ResultSetMetaData metaData = getResult.getMetaData();
 
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                	
                	String columnName = metaData.getColumnLabel(i + 1);
                	String fieldValue = getResult.getString(columnName);
                	
                	if(getResult.wasNull()) {
                		fieldValue = "";
                	}
 
                    jsonObject.put(columnName, fieldValue.trim());
                }
            }
		    
		    //Close Connections
            try { if (getResult!= null) getResult.close(); } catch (Exception e) {};
            try { if (stmt!= null) stmt.close(); } catch (Exception e) {};
            try { if (connection!= null) connection.close(); } catch (Exception e) {};
	    
 		} catch (Exception e) {
 		    e.printStackTrace();
 		}
 		
 		return jsonObject;
	}
	
	//Getters and Setters
	public String getSqlString() {
		return sqlString;
	}

	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}
	
	

}
