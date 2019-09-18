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

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mentorondemand.model.Login;
import com.mentorondemand.repo.LoginRepository;

@CrossOrigin(origins = "http://localhost:4321")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	LoginRepository loginRepo;

	@PostMapping(value = "/getRole/login")
	public List<Login> getLoginDetails(@RequestBody Login login) {

		System.out.println("hiii");
		String email = login.getEmail();
		System.out.println(email);
		String password = login.getPassword();
		List<Login> list = loginRepo.findByRole(email, password);
		return list;

	}

	@GetMapping("/getAdminLogin")
	public List<Login> getAdminLoginDetails() {

		System.out.println("admin email");
		List<Login> list = loginRepo.findByRole("admin");
		return list;

	}

}
