package com.github.bennymcbenben;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring/application-config.xml", "classpath:spring/mvc-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MockMvcTest {
	
	private Logger logger = LoggerFactory.getLogger(MockMvcTest.class);
	
	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	private MyController controller;

	private MockMvc mockMvc;
	private MyObjectMapper mapper = new MyObjectMapper();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
	
	@Test
	public void test() throws Exception {
		Pojo pojo = new Pojo();
		pojo.setDateTime(DateTime.now());
		
		String json = mapper.writeValueAsString(pojo);
		logger.debug("json={}", json);

		mockMvc.perform(put("/").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isCreated());
	}
}
