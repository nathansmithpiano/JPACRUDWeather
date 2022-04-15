package com.skilldistillery.jpacrudweather.data;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.skilldistillery.jpacrudweather.entities.Point;

public class PointDeserializer extends StdDeserializer<Point> {
    
//    private static final long serialVersionUID = 1L;

	public PointDeserializer() {
        this(null);
    }

    public PointDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Point deserialize(JsonParser parser, DeserializationContext deserializer) {
        Point point = new Point();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = null;
        try {
			node = codec.readTree(parser);
		} catch (JacksonException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
        // try catch block
//        JsonNode colorNode = node.get("color");
//        String color = colorNode.asText();
//        car.setColor(color);
        return point;
    }
}