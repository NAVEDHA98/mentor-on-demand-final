package com.mentorondemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "mentor")
public class Mentor {
 
	public Mentor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="mentorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long mentorId;
	@Column(name="firstname")
	 private String firstName;
	@Column(name="lastname")
	 private String  lastName;
	@Column(name="email")
	 private String email;
	@Column(name="password")
	 private String password;
	@Column(name="contact_number")
	 private String contactNumber;
	@Column(name="linkedin_url")
	 private String linkedinUrl;
	 @Column(name="reg_date_time")
	 private String regDateTime;
	 
	 @Column(name="skills")
	 private String skills;
	 @Column(name="current_course")
	 private String currentCourse;
	 @Column(name="year_of_experience")
     private String yearOfExperience;
	 @Column(name="role")
     private String role="mentor";
	
	 @Column(name="status")
     private String status="active";
	public long getMentorId() {
		return mentorId;
	}
	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getLinkedinUrl() {
		return linkedinUrl;
	}
	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}
	public String getRegDateTime() {
		return regDateTime;
	}
	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}
	
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCurrentCourse() {
		return currentCourse;
	}
	public void setCurrentCourse(String currentCourse) {
		this.currentCourse = currentCourse;
	}
	public String getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Mentor(long mentorId, String firstName, String lastName, String email, String password, String contactNumber,
			String linkedinUrl, String regDateTime, String regCode, String skills, String currentCourse,
			String yearOfExperience, String rating, String selfRating, String status) {
		super();
		this.mentorId = mentorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.linkedinUrl = linkedinUrl;
		this.regDateTime = regDateTime;
		
		this.skills = skills;
		this.currentCourse = currentCourse;
		this.yearOfExperience = yearOfExperience;
		
		this.status = status;
	}
	
	public Mentor(String firstName2, String lastName2, String email2, String password2, String contactNumber2,
			String linkedinUrl2, String regDateTime2, String skills2, String currentCourse2, String yearOfExperience2,
			String status2,String role ) {
	
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.email = email2;
		this.password = password2;
		this.contactNumber = contactNumber2;
		this.linkedinUrl = linkedinUrl2;
		this.regDateTime = regDateTime2;
		
		this.skills = skills2;
		this.currentCourse = currentCourse2;
		this.yearOfExperience = yearOfExperience2;
		this.role=role;
		
		this.status = status2;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Mentor [mentorId=" + mentorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", contactNumber=" + contactNumber + ", linkedinUrl=" + linkedinUrl
				+ ", regDateTime=" + regDateTime + ",  skills=" + skills + ", currentCourse="
				+ currentCourse + ", yearOfExperience=" + yearOfExperience + ",  status=" + status + ",role="+role+"]";
	}
	 
	 
}
