package com.skilldistillery.jpacrudweather.data;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        pd.setShortForecast(node.get("shortForecast").asText());
        pd.setDetailedForecast(node.get("detailedForecast").asText());
        
        List<Integer> windSpeeds = new ArrayList<Integer>();
        Matcher m = Pattern.compile("\\d+")
        	     .matcher(pd.getWindSpeed());
        
        while (m.find()) {
        	try {
        		windSpeeds.add(Integer.parseInt(m.group()));
        	} catch (NumberFormatException e) {
        		System.err.println("PeriodDeserializer - Cannot parse windspeed string to Integer");
        		e.printStackTrace();
        	}
        }
        
		if (windSpeeds.size() == 1) {
			pd.setWindMin(windSpeeds.get(0));
			pd.setWindMax(windSpeeds.get(0));
		} else if (windSpeeds.size() == 2) {
			pd.setWindMin(windSpeeds.get(0));
			pd.setWindMax(windSpeeds.get(1));
		} else {
			System.err.println("Period windspeed min/max formatting error - not 1 or 2 numbers in API windspeed string");
		}
		
		return pd;
	}

}
