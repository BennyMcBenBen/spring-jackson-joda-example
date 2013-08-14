package com.github.bennymcbenben;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class MyObjectMapper extends ObjectMapper {
	private static final long serialVersionUID = -9016624260762945387L;

	public MyObjectMapper() {
		super();
		registerModule(new JodaModule());
		disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}
}
