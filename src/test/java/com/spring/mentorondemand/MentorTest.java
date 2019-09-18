package com.spring.mentorondemand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mentorondemand.model.Mentor;
import com.mentorondemand.model.MentorCalendar;
import com.mentorondemand.model.MentorSkills;
import com.mentorondemand.model.ProposalRequest;
import com.mentorondemand.model.Trainings;

public class MentorTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getMentorSkills() throws Exception {
		String uri = "/mentorSkills";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		MentorSkills[] mentorSkillList = super.mapFromJson(content, MentorSkills[].class);
		assertTrue(mentorSkillList.length > 0);
	}

	@Test
	public void registerMentor() throws Exception {
		String uri = "/mentor/register";
		Mentor mentor = new Mentor(1, "dummy", "dummy", "dummy@gmail.com", "password", "9876543210",
				"www.linkedin.com/dummy", "23/03/2019 05:00", "mentor101", "angular", "fse", "6", "8", "9", "ACTIVE");

		String inputJson = super.mapToJson(mentor);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, mentor.toString());
	}

	@Test
	public void addSkill() throws Exception {
		String uri = "/mentor/addSkill";
		MentorSkills mentorSkill = new MentorSkills(1, 1, "9", "01/01/2019 05:00", "505", "Online");

		String inputJson = super.mapToJson(mentorSkill);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, mentorSkill.toString());
	}

	@Test
	public void mentorConfirmation() throws Exception {
		String uri = "/mentor/confirmation";
		MentorCalendar mentorCalendar = new MentorCalendar(1, "05:00", "10:00");
		ProposalRequest proposalRequest = new ProposalRequest(1, 1, 1, 1, "ACTIVE");

		Trainings training = new Trainings(proposalRequest.getTechnologyId(), proposalRequest.getMentorId(),
				mentorCalendar.getStartTime(), mentorCalendar.getEndTime());

		String inputJson = super.mapToJson(training);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, training.toString());
	}

	@Test
	public void addCalendar() throws Exception {
		String uri = "/mentor/addCalendar";

		MentorCalendar mentorCalendar = new MentorCalendar(1, "05:00", "10:00");

		String inputJson = super.mapToJson(mentorCalendar);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, mentorCalendar.toString());
	}

	@Test
	public void rejectMentor() throws Exception {
		String uri = "/mentor/rejection/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		assertEquals(new ResponseEntity<>(" ", HttpStatus.OK),
				new ResponseEntity<>(" ", HttpStatus.OK));
	}

}
