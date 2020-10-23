package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONArray;
import org.json.JSONObject;

public class Navigation {
	
	int navigationID;
	String navigationName;
	String navigationURL;
	int navigationVisible;
	int navigationOrder;
	
	public Navigation() {
		
	}
	
	public JSONArray listNavigations() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase() + ".dbo.navigations WITH (NOLOCK) " + 
		"ORDER BY navigationOrder";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray listVisibleNavigations() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase() + ".dbo.navigations WITH (NOLOCK) " + 
		"WHERE navigationVisible = '1' ORDER BY navigationOrder";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONObject getNavigation() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();		
		String sqlString = "SELECT * " +
		  		"FROM " + mssqlConnection.getDatabase() + ".dbo.navigations WITH (NOLOCK) " +
				"WHERE navigationID = "+navigationID+"";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();
		
	}
	
	public String updateNavigation() {
		
		String message = "Navigation Updated!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String update = "UPDATE " + mssqlConnection.getDatabase() + ".dbo.navigations SET " +
					"navigationName=IsNull(NullIf(?,''),navigationName), navigationURL=IsNull(NullIf(?,''),navigationURL),"+
					"navigationVisible=IsNull(?,navigationVisible),navigationOrder=IsNull(?,navigationOrder) "+
					"WHERE navigationID="+navigationID+"";
			
			PreparedStatement ps = connection.prepareStatement(update);
			
			ps.setString(1, navigationName);
			ps.setString(2, navigationURL);
			ps.setInt(3, navigationVisible);
			ps.setInt(4, navigationOrder);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}
	
	public String addNavigation() {
		
		String message = "Navigation Added!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String add = "INSERT " + mssqlConnection.getDatabase() + ".dbo.navigations " +
					"(navigationName, navigationURL, navigationVisible, navigationOrder) VALUES (?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(add);
			
			ps.setString(1, navigationName);
			ps.setString(2, navigationURL);
			ps.setInt(3, navigationVisible);
			ps.setInt(4, navigationOrder);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}
	
	public String deleteNavigation() {
		
		String message = "Navigation " + navigationID + " Deleted!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String delete = "DELETE FROM " + mssqlConnection.getDatabase() + ".dbo.navigations " +
					"WHERE navigationID = " + navigationID;
			
			PreparedStatement ps = connection.prepareStatement(delete);
			
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}

	
	//Getters & Setters
	public int getNavigationID() {
		return navigationID;
	}

	public void setNavigationID(int navigationID) {
		this.navigationID = navigationID;
	}

	public String getNavigationName() {
		return navigationName;
	}

	public void setNavigationName(String navigationName) {
		this.navigationName = navigationName;
	}

	public String getNavigationURL() {
		return navigationURL;
	}

	public void setNavigationURL(String navigationURL) {
		this.navigationURL = navigationURL;
	}

	public int getNavigationVisible() {
		return navigationVisible;
	}

	public void setNavigationVisible(int navigationVisible) {
		this.navigationVisible = navigationVisible;
	}

	public int getNavigationOrder() {
		return navigationOrder;
	}

	public void setNavigationOrder(int navigationOrder) {
		this.navigationOrder = navigationOrder;
	}

	
}
