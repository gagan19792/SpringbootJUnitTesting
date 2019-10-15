package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)

public class HelloWorldApiTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private HelloWordApi helloWordApi;
	
	@Before
	public void SetUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(helloWordApi).build();
	}
	

	@Test
	public void testHelloWorld() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello World!...."));//MockMvcResultMatchers.content()
	}
	
	@Test
	public void testHelloWorldJson() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello/json").accept(MediaType.APPLICATION_STREAM_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.fName", Matchers.is("Gagan")))
		.andExpect(jsonPath("$.lName", Matchers.is("Ubbey")))
		.andExpect(jsonPath("$.age", Matchers.is(40)));
	}
}
