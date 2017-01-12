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
		
		// Voici un Exemple d'appel des web services REST
		// RESULTAT de l'exécution de l'application:
//		 RESTService : GETlistAuthor : on liste
//		 {"author":[{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"1","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about","nationality":"nationality","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"2","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about2","nationality":"nationality2","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"3","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about3","nationality":"nationality3","type":"AUTHOR"}]}
//		  RESTService : POSTAuthor : on ajoute un auteur et on affiche la liste pour confirmer
//		 <?xml version="1.0" encoding="UTF-8" standalone="yes"?><author><birthday>48350408-04-09T19:17:34.848+01:00</birthday><email>email@test.email</email><id>5</id><lastname>lastnameAUTG</lastname><picture>picture.jpg</picture><sex>M</sex><surname>surnameAUTG</surname><about>about5</about><nationality>nationality5</nationality><type>AUTHOR</type></author>
//		  RESTService : GETlistAuthor :
//		 {"author":[{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"1","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about","nationality":"nationality","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"2","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about2","nationality":"nationality2","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"3","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about3","nationality":"nationality3","type":"AUTHOR"},{"birthday":"48350408-04-09T19:17:34.848+01:00","email":"email@test.email","id":"5","lastname":"lastnameAUTG","picture":"picture.jpg","sex":"M","surname":"surnameAUTG","about":"about5","nationality":"nationality5","type":"AUTHOR"}]}
//		  RESTService : GETlistAuthor : on l'édite et on affiche la liste pour confirmer
//		 {"author":[{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"1","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about","nationality":"nationality","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"2","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about2","nationality":"nationality2","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"3","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about3","nationality":"nationality3","type":"AUTHOR"},{"birthday":"48350249-04-09T19:17:34.848+01:00","email":"emailV2@test.email","id":"5","lastname":"lastnameAUTGV2","picture":"pictureV2.jpg","sex":"M","surname":"surnameAUTGV2","about":"about5V2","nationality":"nationality5V2","type":"AUTHOR"}]}
//		  RESTService : GETlistAuthor : on le supprime et on affiche la liste pour confirmer
//		 {"author":[{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"1","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about","nationality":"nationality","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"2","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about2","nationality":"nationality2","type":"AUTHOR"},{"birthday":"2017-01-12T22:31:43.439+01:00","email":"email@ynov.com","id":"3","lastname":"lastnameA","picture":"picture.jpg","sex":"M","surname":"surname","about":"about3","nationality":"nationality3","type":"AUTHOR"}]}

		
		// Liste les auteurs
		response = client.resource(uri).path("library").path("authors/").get(ClientResponse.class);
		String GETlistAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : GETlistAuthor : \n" + GETlistAuthor);
		
		// ajoute un auteur
		Author auth = new Author(5L, "lastnameAUTG", "surnameAUTG", "M", "picture.jpg", "email@test.email", new java.util.Date(), "about5", "nationality5", TypeAuthor.AUTHOR);
		response = client.resource(uri).path("library").path("authors/").type(MediaType.APPLICATION_JSON).post(ClientResponse.class, mapper.writeValueAsString(auth));
		String POSTaddAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : POSTAuthor : \n" + POSTaddAuthor);
		
		// affiche pour vérifier
		response = client.resource(uri).path("library").path("authors/").get(ClientResponse.class);
		GETlistAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : GETlistAuthor : \n" + GETlistAuthor);

		// ajoute ce même auteur
		auth = new Author(5L, "lastnameAUTGV2", "surnameAUTGV2", "M", "pictureV2.jpg", "emailV2@test.email", new java.util.Date(), "about5V2", "nationality5V2", TypeAuthor.AUTHOR);
		response = client.resource(uri).path("library").path("authors/").type(MediaType.APPLICATION_JSON).put(ClientResponse.class, mapper.writeValueAsString(auth));
				
		// affiche pour vérifier
		response = client.resource(uri).path("library").path("authors/").get(ClientResponse.class);
		GETlistAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : GETlistAuthor : \n" + GETlistAuthor);
		
		// supprime ce même auteur
		response = client.resource(uri).path("library").path("authors/").path("5").delete(ClientResponse.class);
		
		// affiche pour vérifier
		response = client.resource(uri).path("library").path("authors/").get(ClientResponse.class);
		GETlistAuthor = response.getEntity(String.class);
		System.out.println(" RESTService : GETlistAuthor : \n" + GETlistAuthor);
	}

}
