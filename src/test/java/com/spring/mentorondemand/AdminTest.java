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

import com.mentorondemand.model.Admin;
import com.mentorondemand.model.Commission;
import com.mentorondemand.model.Mentor;
import com.mentorondemand.model.PaymentHistory;
import com.mentorondemand.model.Payments;
import com.mentorondemand.model.Skills;
import com.mentorondemand.model.User;

public class AdminTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getPaymentHistoryList() throws Exception {
		String uri = "/paymentHistoryList";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		PaymentHistory[] paymentHistoryList = super.mapFromJson(content, PaymentHistory[].class);
		assertTrue(paymentHistoryList.length > 0);
	}

	@Test
	public void getPaymentDetails() throws Exception {
		String uri = "/paymentDetails";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Payments[] payments = super.mapFromJson(content, Payments[].class);
		assertTrue(payments.length > 0);
	}

	@Test
	public void getPaymentSlotWithId() throws Exception {
		String uri = "/paymentSlotWithId/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Payments[] paymentSlotWithId = super.mapFromJson(content, Payments[].class);
		assertTrue(paymentSlotWithId.length > 0);
	}

	@Test
	public void getPaymentHistoryWithId() throws Exception {
		String uri = "/paymentHistoryList/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		PaymentHistory[] paymentHistoryList = super.mapFromJson(content, PaymentHistory[].class);
		assertTrue(paymentHistoryList.length > 0);
	}

	@Test
	public void getMentorList() throws Exception {
		String uri = "/mentorList";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Mentor[] mentorList = super.mapFromJson(content, Mentor[].class);
		assertTrue(mentorList.length > 0);
	}

	@Test
	public void getUserList() throws Exception {
		String uri = "/userList";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		User[] userList = super.mapFromJson(content, User[].class);
		assertTrue(userList.length > 0);
	}

	@Test
	public void getSearchList() throws Exception {
		String uri = "/userSearchList/dummy1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		User[] userList = super.mapFromJson(content, User[].class);
		assertTrue(userList.length > 0);
	}

	@Test
	public void getMentorSearchList() throws Exception {
		String uri = "/mentorSearchList/mentordummy1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Mentor[] mentorList = super.mapFromJson(content, Mentor[].class);
		assertTrue(mentorList.length > 0);
	}

	@Test
	public void createAdmin() throws Exception {
		String uri = "/adminDetails";
		Admin admin = new Admin("dummy", "dummy@gmail.com", "password", "9876543210", "true", "ADMIN");

		String inputJson = super.mapToJson(admin);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Admin is created successfully");
	}

	@Test
	public void addSkill() throws Exception {
		String uri = "/addSkill";
		Skills skill = new Skills(1, "angular", "700");

		String inputJson = super.mapToJson(skill);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Skill is created successfully");
	}

	@Test
	public void addPayment() throws Exception {
		String uri = "/payment";
		Payments payment = new Payments();
		payment.setMentorId(1);

		String inputJson = super.mapToJson(payment);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, payment.toString());
	}

	@Test
	public void postPaymentHistory() throws Exception {
		String uri = "/paymentHistory";
		Payments payment = new Payments(101, 1, 1, "25", "50", "75", "100");

		String inputJson = super.mapToJson(payment);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, payment.toString());
	}

	@Test
	public void updateCommission() throws Exception {
		String uri = "/UpdateCommission";
		Commission commission = new Commission(1, 20);

		String inputJson = super.mapToJson(commission);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, commission.toString());
	}

	@Test
	public void updateSlot() throws Exception {
		String uri = "/updateSlot";
		Payments payment = new Payments(101, 1, 1, "angular", "spring", "mysql", "oracle");

		String inputJson = super.mapToJson(payment);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, payment.toString());
	}

	@Test
	public void deleteMentor() throws Exception {
		String uri = "/deleteMentor/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		assertEquals(new ResponseEntity<>(" ", HttpStatus.OK), new ResponseEntity<>(" ", HttpStatus.OK));
	}

	@Test
	public void deleteUser() throws Exception {
		String uri = "/deleteMentor/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		assertEquals(new ResponseEntity<>(" ", HttpStatus.OK), new ResponseEntity<>(" ", HttpStatus.OK));
	}

}
