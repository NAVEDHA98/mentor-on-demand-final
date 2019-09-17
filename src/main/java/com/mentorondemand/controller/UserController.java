package com.mentorondemand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.model.Login;
import com.mentorondemand.model.Payments;
import com.mentorondemand.model.ProposalRequest;
import com.mentorondemand.model.Skills;
import com.mentorondemand.model.User;
import com.mentorondemand.repo.LoginRepository;
import com.mentorondemand.repo.PaymentRepository;
import com.mentorondemand.repo.ProposalRequestRepository;
import com.mentorondemand.repo.SkillRepository;
import com.mentorondemand.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:4321")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepo;

	@Autowired
	SkillRepository skillRepo;

	@Autowired
	ProposalRequestRepository proposalRequestRepo;

	@Autowired
	PaymentRepository paymentRepo;
	
	@Autowired
	  LoginRepository loginRepo;


	@PostMapping(value = "/user/register")
	public User postCustomer(@RequestBody User user) {

		User userInsert = userRepo.save(new User(user.getUserName(), user.getPassword(), user.getFirstName(),
				user.getLastName(), user.getGender(), user.getEmail(), user.getContactNumber(), user.getRegcode(),
				user.getActiveStatus(), user.getAddress(),user.getRole()));
		System.out.println(user.getRegcode());
		Login loginDetails= loginRepo.save(new Login(user)); 
		return userInsert;

	}

	@GetMapping(value = "user/searchSkill/{skillName}/")
	public List<Skills> findBySkillName(@PathVariable String skillName) {

		List<Skills> skillList = skillRepo.findBySkillName(skillName);
		return skillList;
	}

	@PostMapping(value = "/user/proposeTraining")
	public ProposalRequest proposeTraining(@RequestBody ProposalRequest proposalRequest) {

		ProposalRequest proposalRequestInsert = proposalRequestRepo.save(new ProposalRequest(proposalRequest.getUserId(), proposalRequest.getMentorId(),
						proposalRequest.getTechnologyId(), proposalRequest.getStatus()));
		return proposalRequestInsert;

	}

	

}
