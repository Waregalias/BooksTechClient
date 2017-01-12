package application;

import entities.*;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class App {

	public static void main(String[] args) throws Exception {
		
		Client client = Client.create(new DefaultClientConfig());
		ObjectMapper mapper = new ObjectMapper();
		ClientResponse response = null;
		URI uri = UriBuilder.fromUri("http://localhost:8080/BooksTech").build(); 
		
		response = client.resource(uri).path("library").path("authors/").get(ClientResponse.class);
		String GETlistAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : GETlistAuthor : \n" + GETlistAuthor);
		
		Author auth = new Author(5L, "lastnameAUTG", "surnameAUTG", "M", "picture.jpg", "email@test.email", new java.util.Date(), "about5", "nationality5", TypeAuthor.AUTHOR);
		response = client.resource(uri).path("library").path("authors/").type(MediaType.APPLICATION_JSON).post(ClientResponse.class, mapper.writeValueAsString(auth));
		String POSTaddAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : POSTAuthor : \n" + POSTaddAuthor);
		
		response = client.resource(uri).path("library").path("authors/").get(ClientResponse.class);
		GETlistAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : GETlistAuthor : \n" + GETlistAuthor);

				
	}

}
