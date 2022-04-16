package com.skilldistillery.jpacrudweather.client;

import java.io.IOException;
import java.net.URL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.skilldistillery.jpacrudweather.data.WeatherPointDeserializer;
import com.skilldistillery.jpacrudweather.entities.Point;
import com.skilldistillery.jpacrudweather.entities.WeatherPoint;

public class TestClient {

	public static void main(String[] args) {
		EntityManagerFactory emf =
			      Persistence.createEntityManagerFactory("JPACRUDWeather");
		EntityManager em = emf.createEntityManager();
		
//		Point point = em.find(Point.class, 1);
		
//		System.out.println(point);
		
		TestClient app = new TestClient();
		app.testDeserialize();
		em.close();
		emf.close();

	}
	
	private void testDeserialize() {
		
		double latitude = 39.9886008;
		double longitude = -105.2336229;
		
		String url = "https://api.weather.gov/points/" + latitude + "," + longitude;
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module =
				  new SimpleModule("WeatherPointDeserializer", new Version(1, 0, 0, null, null, null));
		module.addDeserializer(WeatherPoint.class, new WeatherPointDeserializer());
		mapper.registerModule(module);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		WeatherPoint wp = null;
		try {
			wp = mapper.readValue(new URL(url), WeatherPoint.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(wp);
//		
////		String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
//		
//		
//		
//		SimpleModule module =
//		  new SimpleModule("PointDeserializer", new Version(1, 0, 0, null, null, null));
//		module.addDeserializer(Point.class, new PointDeserializer());
//		mapper.registerModule(module);
//		
//		Point point = null;
//		Map<String, Object> map = null;
//		try {
////			point = mapper.readValue(json, Point.class);
////			obj = mapper.readValue(new URL(url), WeatherPoint.class);
//			map = mapper.readValue(new URL(url), new TypeReference<Map<String,Object>>(){});
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(map);
//		
//		JsonNode jsonNodeRoot = mapper.readValue(new URL(url));
//		
////		byte[] jsonData = responseToByteArray("https://api.weather.gov/points/" + latitude + "," + longitude);
//		
//		System.out.println(point);
	}
	
//	private byte[] responseToByteArray(String url) {
//		
//		Object obj = mapper.readValue(new URL("http://jsonplaceholder.typicode.com/posts/7"), Post.class);
//		
//		HttpResponse<InputStream> response = null;
//		
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create(url))
//				.header("X-RapidAPI-Host", "national-weather-service.p.rapidapi.com")
//				.header("X-RapidAPI-Key", "ed8dc25befmsh9fd7e2eb57593c1p1f9683jsn0a5c8b0dbf4c")
//				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
//		
//		try {
//			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofInputStream());
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		if (response == null) {
//			System.out.println("ERROR: HttpResponse is null");
//		}
//		
//		//convert to byte array
//		byte[] output = null;
//		
//		try {
//			output = response.body().readAllBytes();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return output;
//	}

}
