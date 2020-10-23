package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Article {

	int articleID;
	int articleAuthorID;
	String articleTitle;
	String articleContent;
	Date articleCreateDate;
	int articleVisible;
	int categoryID;
	String articleImage;
	
	public Article() {
		
	}
	
	public JSONArray listArticles() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase() + ".dbo.articles WITH (NOLOCK) ";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public JSONArray listArticlesByCategory() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();
		
		String sqlString = "SELECT * " +
		"FROM " + mssqlConnection.getDatabase() + ".dbo.articles WITH (NOLOCK) " +
		"WHERE categoryID=" +categoryID;
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.lstQuery();
	}
	
	public String updateArticle() {
		
		String message = "Article Updated!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String updateArticle = "UPDATE " + mssqlConnection.getDatabase() + ".dbo.articles SET " +
					"articleTitle=IsNull(NullIf(?,''),articleTitle), articleContent=IsNull(NullIf(?,''),articleContent),"+
					"articleImage=IsNull(NullIf(?,''),articleImage),categoryID=IsNull(?,categoryID) "+
					"WHERE articleID="+articleID+"";
			
			PreparedStatement ps = connection.prepareStatement(updateArticle);
			
			ps.setString(1, articleTitle);
			ps.setString(2, articleContent);
			ps.setString(3, articleImage);
			ps.setInt(4, categoryID);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}
	
	public JSONObject getArticle() {
		
		MSSQLConnection mssqlConnection = new MSSQLConnection();		
		String sqlString = "SELECT * " +
		  		"FROM " + mssqlConnection.getDatabase() + ".dbo.articles WITH (NOLOCK) " +
				"WHERE articleID = "+articleID+"";
		
		SQLQuery sqlQuery = new SQLQuery();
		sqlQuery.setSqlString(sqlString);
		
		return sqlQuery.getQuery();
		
	}
	
	public String addArticle() {
		
		String message = "Article Added!";
		
		try {
			
			MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			
			String addArticle = "INSERT " + mssqlConnection.getDatabase() + ".dbo.articles " +
					"(articleAuthorID, articleTitle, articleContent, articleCreateDate, articleVisible, categoryID, articleImage) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = connection.prepareStatement(addArticle);
			
			Date date = new Date();
			
			ps.setInt(1, articleAuthorID);
			ps.setString(2, articleTitle);
			ps.setString(3, articleContent);
			ps.setTimestamp(4, new java.sql.Timestamp(date.getTime()));
			ps.setInt(5, articleVisible);
			ps.setInt(6, categoryID);
			ps.setString(7, articleImage);
			ps.executeUpdate();
			
			try { if (ps!= null) ps.close(); } catch (Exception e) {};
			try { if (connection != null) connection.close(); } catch (Exception e) {};
    	
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		} 
		
		return message;
	}
	
	
	//Getters and Setters
	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getArticleAuthorID() {
		return articleAuthorID;
	}

	public void setArticleAuthorID(int articleAuthorID) {
		this.articleAuthorID = articleAuthorID;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public Date getArticleCreateDate() {
		return articleCreateDate;
	}

	public void setArticleCreateDate(Date articleCreateDate) {
		this.articleCreateDate = articleCreateDate;
	}

	public int getArticleVisible() {
		return articleVisible;
	}

	public void setArticleVisible(int articleVisible) {
		this.articleVisible = articleVisible;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getArticleImage() {
		return articleImage;
	}

	public void setArticleImage(String articleImage) {
		this.articleImage = articleImage;
	}
	
	
}
