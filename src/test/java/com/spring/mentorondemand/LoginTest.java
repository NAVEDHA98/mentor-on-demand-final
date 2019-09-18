package com.spring.mentorondemand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mentorondemand.model.Login;

public class LoginTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testLogin1() throws Exception {
		String uri = "/getRole/login";
		Login login = new Login();
		login.setEmail("dummy@gmail.com");
		login.setEmail("password");

		String inputJson = super.mapToJson(login);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, login.toString());
	}

	@Test
	public void testLogin2() throws Exception {
		String uri = "/getAdminLogin";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Login[] loginList = super.mapFromJson(content, Login[].class);
		assertTrue(loginList.length > 0);
	}
}
