package com.skilldistillery.jpacrudweather.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.skilldistillery.jpacrudweather.entities.Point;
import com.skilldistillery.jpacrudweather.entities.WeatherPoint;

public class WeatherPointDeserializer extends StdDeserializer<WeatherPoint> {
    
	//Is this necessary?
    private static final long serialVersionUID = 1L;

	public WeatherPointDeserializer() {
        this(null);
    }

    public WeatherPointDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WeatherPoint deserialize(JsonParser parser, DeserializationContext deserializer) {
    	WeatherPoint wp = new WeatherPoint();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = null;
        try {
			node = codec.readTree(parser);
		} catch (JacksonException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
        JsonNode propertiesNode = node.get("properties");
        
    	wp.setIdUrl(propertiesNode.get("@id").asText());
    	wp.setCwa(propertiesNode.get("cwa").asText());
    	wp.setGridId(propertiesNode.get("gridId").asText());
    	wp.setGridX(propertiesNode.get("gridX").asInt());
    	wp.setGridY(propertiesNode.get("gridY").asInt());
    	wp.setForecastUrl(propertiesNode.get("forecast").asText());
    	wp.setForecastHourly(propertiesNode.get("forecastHourly").asText());
    	wp.setrLatitude(propertiesNode.get("relativeLocation")
    			.get("geometry")
    			.get("coordinates")
    			.get(0).asDouble());
    	wp.setrLongitude(propertiesNode.get("relativeLocation")
    			.get("geometry")
    			.get("coordinates")
    			.get(1).asDouble());
    	wp.setrCity(propertiesNode.get("relativeLocation")
    			.get("properties")
    			.get("city").asText());
    	wp.setrState(propertiesNode.get("relativeLocation")
    			.get("properties")
    			.get("state").asText());
    	wp.setrDistance(propertiesNode.get("relativeLocation")
    			.get("properties")
    			.get("distance")
    			.get("value").asDouble());
    	wp.setrBearing(propertiesNode.get("relativeLocation")
    			.get("properties")
    			.get("bearing")
    			.get("value").asInt());
        	
        System.out.println(wp);
        return wp;
    }
}