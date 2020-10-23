package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {
	
	int userID;
	String firstName;
	String lastName;
	String email;
	String username;
	String password;
	int active;
	Date userCreateDate;

	public User() {
		
	}

	public JSONArray listUsers() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase() + ".dbo.users WITH (NOLOCK) ";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}

	public JSONObject getUser() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();		
		String sqlString = "SELECT * " +
		  		"FROM " + mssqlConnection.getDatabase() + ".dbo.users WITH (NOLOCK) " +
				"WHERE userID = "+userID+"";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();
	}

	public String updateUser() {
		
		String message = "User Updated!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String updateUser = "UPDATE " + mssqlConnection.getDatabase() + ".dbo.users SET " +
					"firstName=IsNull(NullIf(?,''),firstName), lastName=IsNull(NullIf(?,''),lastName),"+
					"email=IsNull(NullIf(?,''),email), username=IsNull(NullIf(?,''),username),"+
					"password=IsNull(NullIf(?,''),password), active=IsNull(?,active) " + 
					"WHERE userID="+userID+"";
			
			PreparedStatement ps = connection.prepareStatement(updateUser);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setInt(6, active);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}

	public String addUser() {
		
		String message = "User Added!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addUser = "INSERT " + mssqlConnection.getDatabase() + ".dbo.users " +
					"(firstName, lastName, email, username, password, active, userCreateDate) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addUser);
			
			Date date = new Date();
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setInt(6, active);
			ps.setTimestamp(7, new java.sql.Timestamp(date.getTime()));
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}

	public JSONObject authenticate() {
		
		JSONObject result = new JSONObject();
		
		String message = "Username or Password is incorrect.";
		
		try {
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
		 	java.sql.Statement stmt = connection.createStatement(
		 			java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, 
		 			java.sql.ResultSet.CONCUR_READ_ONLY);		
			
			String sqlString = "SELECT * " +
			  		"FROM " + mssqlConnection.getDatabase() + ".dbo.users WITH (NOLOCK) " +
					"WHERE username = '"+username.replace("'", "''")+"'";
			
			ResultSet lstResult = stmt.executeQuery(sqlString);
			
			while (lstResult.next()) {
				
				String dbPassword = lstResult.getString("password");
				String dbActive = lstResult.getString("active");
				String dbUserID = lstResult.getString("userID");
				result.put("userID", dbUserID);
				
				if(dbPassword.contentEquals(password)) {
					if(dbActive.equals("0")) {
						message = "This User is currently deactivated.  Please contact a System Administrator.";
					}else {
						message = "success";
					}
				}
			}
			
			result.put("message", message);
			
		    //Close Connections
	        try { if (lstResult!= null) lstResult.close(); } catch (Exception e) {};
	        try { if (stmt!= null) stmt.close(); } catch (Exception e) {};
	        try { if (connection!= null) connection.close(); } catch (Exception e) {};
	    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		System.out.println(result);
		return result;
	}
	
	// Getters & Setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getUserCreateDate() {
		return userCreateDate;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDate = userCreateDate;
	}
	
}




