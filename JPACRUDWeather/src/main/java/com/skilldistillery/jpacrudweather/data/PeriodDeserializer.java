package com.skilldistillery.jpacrudweather.data;

import java.io.IOException;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.skilldistillery.jpacrudweather.entities.Forecast;
import com.skilldistillery.jpacrudweather.entities.Period;

public class PeriodDeserializer extends StdDeserializer<Period> {
	
	//Is this necessary?
    private static final long serialVersionUID = 1L;

	public PeriodDeserializer() {
        this(null);
    }

    public PeriodDeserializer(Class<?> vc) {
        super(vc);
    }
    
    @Override
	public Period deserialize(JsonParser parser, DeserializationContext deserializer) {
		Period pd = new Period();
		ObjectCodec codec = parser.getCodec();
        JsonNode node = null;
        try {
			node = codec.readTree(parser);
		} catch (JacksonException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
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
		
		return pd;
	}

}
