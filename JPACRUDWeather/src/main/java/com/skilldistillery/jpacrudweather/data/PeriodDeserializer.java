package com.skilldistillery.jpacrudweather.data;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.JsonNode;
import com.skilldistillery.jpacrudweather.entities.Period;

public class PeriodDeserializer  {
	
	public Period deserialize(JsonNode node) {
		Period pd = new Period();
		
        node.get("properties");
        
        pd.setNumber(node.get("number").asInt());
        pd.setName(node.get("name").asText());
        //TODO: test OffsetDateTime and adjusting time zones automatically or manually
        //2022-04-15T18:00:00-06:00
        pd.setStartTime(OffsetDateTime.parse(node.get("startTime").asText()));
        pd.setEndTime(OffsetDateTime.parse(node.get("endTime").asText()));
        pd.setDaytime(node.get("isDaytime").asBoolean());
        pd.setTemp(node.get("temperature").asInt());
        pd.setTempUnit(node.get("temperatureUnit").asText());
        pd.setWindSpeed(node.get("windSpeed").asText());
        pd.setWindDirection(node.get("windDirection").asText());
        pd.setIconUrl(node.get("icon").asText());
        pd.setIconUrl(node.get("shortForecast").asText());
        pd.setDetailedForecast(node.get("detailedForecast").asText());
        
		String temp = pd.getWindSpeed();
		String[] arr;
		if (temp.contains("to")) {
			arr = temp.split("to");
			
			try {
				temp = arr[0].trim();
				pd.setWindMin(Integer.parseInt(temp.toString()));
				temp = arr[1].trim();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (temp.contains("mph")) {
			arr = temp.split("mph");
			
			
			try {
				temp = arr[0].trim();
				pd.setWindMax(Integer.parseInt(temp.toString()));
			} catch (Exception e) {
				System.err.println("Period windspeed min/max formatting error");
				e.printStackTrace();
			}
		}
		
		return pd;
	}

}
