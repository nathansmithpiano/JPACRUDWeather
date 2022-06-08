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

public class ForecastDeserializer extends StdDeserializer<Forecast> {
	
	//Is this necessary?
    private static final long serialVersionUID = 1L;

	public ForecastDeserializer() {
        this(null);
    }

    public ForecastDeserializer(Class<?> vc) {
        super(vc);
    }

	@Override
	public Forecast deserialize(JsonParser parser, DeserializationContext deserializer) {
		Forecast fc = new Forecast();
		ObjectCodec codec = parser.getCodec();
        JsonNode node = null;
        try {
			node = codec.readTree(parser);
		} catch (JacksonException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
        JsonNode pn = node.get("properties");
        
        //TODO: test OffsetDateTime and adjusting time zones automatically or manually
        //2022-04-15T18:00:00-06:00
        fc.setUpdated(OffsetDateTime.parse(pn.get("updated").asText()));
        fc.setGeneratedAt(OffsetDateTime.parse(pn.get("generatedAt").asText()));
        fc.setUpdateTime(OffsetDateTime.parse(pn.get("updateTime").asText()));
        fc.setElevation(pn.get("elevation").get("value").asDouble());
        fc.setNumPeriods(pn.get("periods").size());
        
        JsonNode periods = pn.get("periods");
        PeriodDeserializer pds = new PeriodDeserializer();
        for (JsonNode subnode : periods) {
        	Period period = new Period();
        	period = pds.deserialize(subnode);
        	System.out.println("***** period from ForecastDeserializer.period() *****");
        	System.out.println(period);
        	System.out.println("*****************************************************");
        }
		
		return fc;
	}
	
}
