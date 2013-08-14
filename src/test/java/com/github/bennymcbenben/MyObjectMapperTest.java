package com.github.bennymcbenben;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyObjectMapperTest {

	private Logger logger = LoggerFactory.getLogger(MyObjectMapperTest.class);
	
	@Test
	public void test() throws Exception {
		MyObjectMapper mapper = new MyObjectMapper();

		Pojo original = new Pojo();
		original.setDateTime(DateTime.now(DateTimeZone.UTC));

		String json = mapper.writeValueAsString(original);
		logger.debug("json={}", json);
		
		Pojo deserialized = mapper.readValue(json, Pojo.class);
		assertEquals(original, deserialized);
	}
}
