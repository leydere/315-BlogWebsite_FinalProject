package rest;

import java.io.IOException;
import java.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String apiKey = "1234567890";
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		if(requestContext.getUriInfo().getPath().contains("add") || requestContext.getUriInfo().getPath().contains("update")
				|| requestContext.getUriInfo().getPath().contains("delete")) {
			String receivedAPI = requestContext.getHeaderString(AUTHORIZATION_HEADER);
			System.out.println("receivedAPI: " + receivedAPI);
			
			if(receivedAPI != null) {
				
				String decodedAPI = new String(Base64.getDecoder().decode(receivedAPI));
				System.out.println(decodedAPI);
			
				if(apiKey.contentEquals(decodedAPI)) {
					return;
				}
			}
			
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User does not have access to this resource").build();
			
			requestContext.abortWith(unauthorizedStatus);
		}
	}
}
