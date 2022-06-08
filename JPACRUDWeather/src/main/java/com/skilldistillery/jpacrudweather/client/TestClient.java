package com.skilldistillery.jpacrudweather.client;

import java.io.IOException;
import java.net.URL;
import java.time.OffsetDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.skilldistillery.jpacrudweather.data.ForecastDeserializer;
import com.skilldistillery.jpacrudweather.data.WeatherPointDeserializer;
import com.skilldistillery.jpacrudweather.entities.Forecast;
import com.skilldistillery.jpacrudweather.entities.WeatherPoint;

public class TestClient {

	public static void main(String[] args) {
		EntityManagerFactory emf =
			      Persistence.createEntityManagerFactory("JPACRUDWeather");
		EntityManager em = emf.createEntityManager();
		
		TestClient app = new TestClient();
		
		//works, gets from DB
//		Point point = em.find(Point.class, 1);
//		System.out.println(point);
		
		//works creates WeatherPoint
//		app.testWeatherPoint();
		
		app.testForecast();
		
		em.close();
		emf.close();

	}
	
	private void testForecast() {
		
		String url = "https://api.weather.gov/gridpoints/BOU/54,72/forecast";
		
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module =
				  new SimpleModule("ForecastDeserializer", new Version(1, 0, 0, null, null, null));
		module.addDeserializer(Forecast.class, new ForecastDeserializer());
		mapper.registerModule(module);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		Forecast fc = null;
		try {
			fc = mapper.readValue(new URL(url), Forecast.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("***** FORECAST from testForecast() *****");
		OffsetDateTime upd = fc.getUpdated();
		OffsetDateTime now = OffsetDateTime.now();
		System.out.println("Now ODT: " + now);
		System.out.println(fc.getUpdated());
		System.out.println("****************************************");
	}
	
	private void testWeatherPoint() {
		
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
		
		System.out.println("***** WeatherPoint from testWeatherPoint() *****");
		System.out.println(wp);
		System.out.println("************************************************");
	}
	
	

}
