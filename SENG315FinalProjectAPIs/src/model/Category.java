package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.json.JSONArray;
import org.json.JSONObject;

public class Category {
	
	int categoryID;
	int navigationID;
	String categoryName;
	String categoryImage;
	String categoryContent;
	int categoryOrder;
	int categoryVisible;
	
	public Category() {
		
	}
	
	public JSONArray listCategories() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase() + ".dbo.categories WITH (NOLOCK) ";
				
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONObject getCategory() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();		
		String sqlString = "SELECT * " +
		  		"FROM " + mssqlConnection.getDatabase() + ".dbo.categories WITH (NOLOCK) " +
				"WHERE categoryID = "+categoryID+"";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();
		
	}
	
	public String updateCategory() {
		
		String message = "Category Updated!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String update = "UPDATE " + mssqlConnection.getDatabase() + ".dbo.categories SET " +
					"navigationID=IsNull(?,navigationID), categoryName=IsNull(NullIf(?,''),categoryName), "+
					"categoryImage=IsNull(NullIf(?,''),categoryImage), categoryContent=IsNull(NullIf(?,''),categoryContent), "+
					"categoryOrder=IsNull(?,categoryOrder), categoryVisible=IsNull(?,categoryVisible) "+
					"WHERE categoryID="+categoryID+"";
			
			PreparedStatement ps = connection.prepareStatement(update);
			
			ps.setInt(1, navigationID);
			ps.setString(2, categoryName);
			ps.setString(3, categoryImage);
			ps.setString(4, categoryContent);
			ps.setInt(5, categoryOrder);
			ps.setInt(6, categoryVisible);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}
	
	public String addCategory() {
		
		String message = "Category Added!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String add = "INSERT " + mssqlConnection.getDatabase() + ".dbo.categories " +
					"(navigationID, categoryName, categoryImage, categoryContent, categoryOrder, categoryVisible) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(add);
			
			ps.setInt(1, navigationID);
			ps.setString(2, categoryName);
			ps.setString(3, categoryImage);
			ps.setString(4, categoryContent);
			ps.setInt(5, categoryOrder);
			ps.setInt(6, categoryVisible);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}
	
	public String deleteCategory() {
		
		String message = "Category " + categoryID + " Deleted!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String delete = "DELETE FROM " + mssqlConnection.getDatabase() + ".dbo.categories " +
					"WHERE categoryID = " + categoryID;
			
			PreparedStatement ps = connection.prepareStatement(delete);
			
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}
	
	public JSONArray listCatByNav() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase() + ".dbo.categories WITH (NOLOCK) " + 
		"WHERE categoryVisible = '1' AND navigationID = '"+navigationID+"' ORDER BY categoryOrder";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}

	
	//Getters & Setters
	
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getNavigationID() {
		return navigationID;
	}

	public void setNavigationID(int navigationID) {
		this.navigationID = navigationID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	public String getCategoryContent() {
		return categoryContent;
	}

	public void setCategoryContent(String categoryContent) {
		this.categoryContent = categoryContent;
	}

	public int getCategoryOrder() {
		return categoryOrder;
	}

	public void setCategoryOrder(int categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	public int getCategoryVisible() {
		return categoryVisible;
	}

	public void setCategoryVisible(int categoryVisible) {
		this.categoryVisible = categoryVisible;
	}
	


}
