package com.spring.mentorondemand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mentorondemand.model.ProposalRequest;
import com.mentorondemand.model.Skills;
import com.mentorondemand.model.User;

public class UserTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getSkills() throws Exception {
		String uri = "/user/searchSkill/angular";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Skills[] skillList = super.mapFromJson(content, Skills[].class);
		assertTrue(skillList.length > 0);
	}

	@Test
	public void registerUser() throws Exception {
		String uri = "/user/register";

		User user = new User("dummy", "password", "dummy", "dummy", "male", "dummy@gmail.com", "9876543210", "user101",
				"ACTIVE", "Chennai", "USER");

		String inputJson = super.mapToJson(user);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, user.toString());
	}

	@Test
	public void proposeTraining() throws Exception {
		String uri = "/user/proposeTraining";
		ProposalRequest proposalRequest = new ProposalRequest(1, 1, 1, 1, "ACTIVE");

		String inputJson = super.mapToJson(proposalRequest);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, proposalRequest.toString());
	}

}
