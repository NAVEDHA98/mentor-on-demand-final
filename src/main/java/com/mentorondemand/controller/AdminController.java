package com.mentorondemand.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mentorondemand.model.Admin;
import com.mentorondemand.model.Commission;
import com.mentorondemand.model.Login;
import com.mentorondemand.model.Mentor;
import com.mentorondemand.model.PaymentHistory;
import com.mentorondemand.model.Payments;
import com.mentorondemand.model.Skills;
import com.mentorondemand.model.User;
import com.mentorondemand.repo.AdminRepository;
import com.mentorondemand.repo.CommissionRepository;
import com.mentorondemand.repo.LoginRepository;
import com.mentorondemand.repo.MentorRepository;
import com.mentorondemand.repo.PaymentHistoryRepository;
import com.mentorondemand.repo.PaymentRepository;
import com.mentorondemand.repo.SkillRepository;
import com.mentorondemand.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:4321")
@RestController
@RequestMapping("/api")
public class AdminController {
	 @Autowired
	  AdminRepository adminRepo;
     @Autowired 
       LoginRepository loginRepo;
     @Autowired 
     SkillRepository skillRepo;
     @Autowired
     CommissionRepository commissionRepo;
     @Autowired
     PaymentRepository paymentRepo;
     @Autowired
     PaymentHistoryRepository paymentHistoryRepo;
     @Autowired
     MentorRepository mentorRepo;
     @Autowired
     UserRepository userRepo;
		
        @PostMapping(value="/adminDetails")
		public void getAdminDetails(@RequestBody Admin admin) {
			Admin adminDetails = adminRepo.save(new Admin(admin.getName(),admin.getEmail(),admin.getPassword(),admin.getContact(),admin.getStatus(),admin.getRole()));
		    System.out.println(admin.getRole());
			Login loginDetails= loginRepo.save(new Login(admin)); 	
		}
		@PostMapping(value = "/addSkill")
		public Skills addskill(@RequestBody Skills skill) {
            System.out.print("skill");
			Skills addSkill = skillRepo.save(new Skills(skill.getSkillName(),skill.getBaseAmount()));
			return addSkill;
		}
		@PostMapping(value = "/UpdateCommission")
		public Commission updateCommission(@RequestBody Commission commission) {

		Commission updateCommission = commissionRepo.save(new Commission(commission.getCommissionPercentage()));
			return updateCommission;
		}
		@PostMapping(value = "/payment")
		public Payments paymentDetails(@RequestBody  Payments payments) {
			System.out.print(payments.getMentorPaymentId());
			payments.setMentorId(1);
		Payments paymentList = paymentRepo.save(new Payments(payments.getMentorPaymentId(),payments.getMentorId(),payments.getSkillId(),payments.getSlot1(),payments.getSlot2(),payments.getSlot3(),payments.getSlot4() ));
	   return paymentList;
		}
		@PostMapping(value = "/paymentHistory")
		public PaymentHistory paymentHistory(@RequestBody  PaymentHistory paymentHistory) {

		PaymentHistory paymentHistoryList = paymentHistoryRepo.save(new PaymentHistory(paymentHistory.getUserId(),paymentHistory.getSkillId(),paymentHistory.getPaymentAmount()));
	    return paymentHistoryList;
		}
		@GetMapping("/paymentHistoryList")
		public List<PaymentHistory> getAllPaymentHistory() {
			System.out.println("Get all PaymentHistory...");

			List<PaymentHistory> paymentHistory = new ArrayList<>();
			paymentHistoryRepo.findAll().forEach(paymentHistory::add);

			return paymentHistory;
		}
		@GetMapping("/paymentDetails")
		public List<Payments> getAllPaymentDetails() {
			System.out.println("Get all PaymentHistory...");

			List<Payments> payment = new ArrayList<>();
			paymentRepo.findAll().forEach(payment::add);

			return payment;
		}
		@GetMapping("/paymentSlotWithId/{selectedId}")
		public List<Payments> getPaymentSlotWithId(@PathVariable Long selectedId) {
			System.out.println("Get all PaymentHistory...");

			List<Payments> payment = paymentRepo.findByMentorPaymentId(selectedId);
			System.out.println(payment);
			return payment;
		}
		@GetMapping("/paymentHistoryId/{selectedId}")
		public List<PaymentHistory> getAllPaymentHistory(@PathVariable Long selectedId) {
		
			System.out.println("Get all PaymentHistory...");
			

			List<PaymentHistory> paymentHistory = paymentHistoryRepo.findByPaymentId(selectedId);
			System.out.println(paymentHistory.get(0).getPaymentAmount());
			return paymentHistory;
            
		}
		@GetMapping("/mentorList")
		public List<Mentor> getAllMentor() {
			System.out.println("Get all Mentors.");

			List<Mentor> mentor = new ArrayList<>();
			mentorRepo.findAll().forEach(mentor::add);

			return mentor;
		}
		@GetMapping("/userList")
		public List<User> getAllUser() {
			System.out.println("Get all users.");

			List<User> user = new ArrayList<>();
			userRepo.findAll().forEach(user::add);

			return user;
		}
		
		@GetMapping("/userSearchList/{firstname}")
		public List<User> getUser(@PathVariable String firstname) {
			
			List<User> users = userRepo.findByFirstName(firstname);
			
			return users;
		}
		
		@GetMapping("/mentorSearchList/{firstname}")
		public List<Mentor> getMentor(@PathVariable String firstname) {
			
			List<Mentor> mentor = mentorRepo.findByFirstName(firstname);
			
			return mentor;
		}
		@DeleteMapping("/deleteMentor/{mentorId}")
        public void deleteMentor(@PathVariable int mentorId) {
			
			 mentorRepo.deleteByMentorId(mentorId);
			
			
		}
		@DeleteMapping("/deleteUser/{userId}")
        public void deleteUser(@PathVariable int userId) {
			
			 userRepo.deleteByUserId(userId);
			
			
		}
		@PostMapping(value="/updateSlot")
		public Payments updateCustomer( @RequestBody Payments payment) {
			System.out.println("******************update");
			System.out.println("Update Customer with ID = " + payment.getMentorPaymentId() + "...");

			List<Payments> updateData = paymentRepo.findByMentorPaymentId(payment.getMentorPaymentId());

			if (!(updateData.isEmpty())) {
				Payments updateSlot = updateData.get(0);
				updateSlot.setSlot2(payment.getSlot2());
				updateSlot.setSlot3(payment.getSlot3());
				updateSlot.setSlot4(payment.getSlot4());
				Payments paymentList = paymentRepo.save(new Payments(updateSlot));
			  
				   return paymentList;
				
			} else {
				return null;
			}
		}
		
}
