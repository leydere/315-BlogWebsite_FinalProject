package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import service.ArticleService;

@Path("/articles")
public class ArticlesAPI {

	@GET
	@Path("/list/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listArticles() {
		
		JSONArray articles = ArticleService.listArticles();
		
		return articles.toString();
	}
	
	@GET
	@Path("/listByCategory/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String listArticlesByCategory(@PathParam("id") Integer id) {
		
		JSONArray articles = ArticleService.listArticlesByCategory(id);
		
		return articles.toString();
	}
	
	
	@POST
	@Path("/update/")
	@Produces("application/json")
	@Consumes("application/json")
	public String updateArticle(String inputParms/*, @HeaderParam("apiKey") String apiKey*/) {
		
		//System.out.println("key: " + apiKey);
		
		try {
			JSONObject result = ArticleService.updateArticle(new JSONObject(inputParms));
			
			return result.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "updateArticleAPI failed";
		}
		
	}
	
	@GET
	@Path("/{id}/")
	@Produces("application/json")
	@Consumes("application/json")
	public String getArticle(@PathParam("id") Integer id) {
		
		JSONObject article = ArticleService.getArticle(id);
		
		return article.toString();
	}
	
	@POST
	@Path("/add/")
	@Produces("application/json")
	@Consumes("application/json")
	public String addArticle(String inputParms) {
		
		try {
			JSONObject result = ArticleService.addArticle(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "addArticle API failed";
		}	
	}
	
}
