package com.mentorondemand.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.model.Login;
import com.mentorondemand.model.Mentor;
import com.mentorondemand.model.MentorCalendar;
import com.mentorondemand.model.MentorSkills;
import com.mentorondemand.model.ProposalRequest;
import com.mentorondemand.model.Trainings;
import com.mentorondemand.model.User;
import com.mentorondemand.repo.LoginRepository;
import com.mentorondemand.repo.MentorCalendarRepository;
import com.mentorondemand.repo.MentorRepository;
import com.mentorondemand.repo.MentorSkillRepository;
import com.mentorondemand.repo.ProposalRequestRepository;
import com.mentorondemand.repo.TrainingRepository;

@CrossOrigin(origins = "http://localhost:4321")
@RestController
@RequestMapping("/api")
public class MentorController {

	@Autowired
	MentorRepository mentorRepo;
	
	@Autowired
	MentorCalendarRepository mentorCalendarRepo;
	
	@Autowired
	MentorSkillRepository skillRepo;

	@Autowired
	MentorCalendarRepository calendarRepo;
	
	@Autowired
	ProposalRequestRepository proposalRequestRepo;

	@Autowired
	TrainingRepository trainingRepo;
	
	@Autowired
	  LoginRepository loginRepo;

	@PostMapping(value = "/mentor/register")
	public Mentor postCustomer(@RequestBody Mentor mentor) {

		Mentor mentorInsert = mentorRepo.save(new Mentor(mentor.getFirstName(),mentor.getLastName(),mentor.getEmail(),mentor.getPassword(),mentor.getContactNumber(),mentor.getLinkedinUrl(),mentor.getRegDateTime(),mentor.getSkills(),mentor.getCurrentCourse(),mentor.getYearOfExperience(),mentor.getStatus(),mentor.getRole()));
		System.out.println(mentor.getYearOfExperience());
		Login loginDetails= loginRepo.save(new Login(mentor)); 
		System.out.println(loginDetails);
		return mentorInsert;

	}
	
	@PostMapping(value = "/mentor/addSkill")
	public MentorSkills mentorAddSkill(@RequestBody MentorSkills mentorSkills) {

		MentorSkills mentorSkillInsert = skillRepo.save(new MentorSkills(mentorSkills.getMentorId(),
				mentorSkills.getSkilId(), mentorSkills.getYearsOfExperience(), mentorSkills.getRegDateTime(),
				mentorSkills.getTrainingsDelivered(), mentorSkills.getFacilities()));
		return mentorSkillInsert;

	}
	@GetMapping(value = "/mentorSkills")
	public List<MentorSkills> mentorAddSkill() {


		List<MentorSkills> user = new ArrayList<>();
		skillRepo.findAll().forEach(user::add);

		return user;
		

	}

	@PostMapping(value = "/mentor/confirmation")
	public Trainings mentorconfirmation(@RequestBody ProposalRequest proposalRequest) {

MentorCalendar mentorCalendar=mentorCalendarRepo.findByMentorId(proposalRequest.getMentorId());
		Trainings trainingsInsert = trainingRepo.save(new Trainings(proposalRequest.getTechnologyId(),proposalRequest.getMentorId(),mentorCalendar.getStartTime(),mentorCalendar.getEndTime()));
		return trainingsInsert;

	}

	@DeleteMapping("/mentor/rejection/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		proposalRequestRepo.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}
	
	@PostMapping(value = "/mentor/addCalendar")
	public MentorCalendar mentorAddCalendar(@RequestBody MentorCalendar mentorCalendar) {

		MentorCalendar mentorCalendarInsert = calendarRepo.save(new MentorCalendar(mentorCalendar.getMentorId(),mentorCalendar.getStartTime(),mentorCalendar.getEndTime()));
		return mentorCalendarInsert;

	}
}
