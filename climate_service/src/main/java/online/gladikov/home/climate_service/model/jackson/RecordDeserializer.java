package online.gladikov.home.climate_service.model.jackson;


import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import online.gladikov.home.climate_service.model.Sensor;
import online.gladikov.home.climate_service.model.SensorRecord;

public class RecordDeserializer extends StdDeserializer<SensorRecord>{

	private static final long serialVersionUID = 5797717683278079442L;

	protected RecordDeserializer(Class<?> vc) {
		super(vc);
	}

	@Override
	public SensorRecord deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
		 JsonNode node = jp.getCodec().readTree(jp);
		 String name = node.get("name").asText();
		 Double temperature =  (node.get("temperature")).doubleValue();
		 Double pressure =  (node.get("pressure")).doubleValue();
		 Double humidity =  (node.get("humidity")).doubleValue();
		return SensorRecord.builder().sensor(new Sensor()).temperature(temperature).pressure(pressure).humidity(humidity).build();
	}
}