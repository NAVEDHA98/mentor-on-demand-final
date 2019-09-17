package com.mentorondemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="mentor_skills")
public class MentorSkills {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="mentor_id")
	private long mentorId;
	
	@Column(name="skill_id")
	private long skilId;
  
	
	
	@Column(name="years_of_exp")
	private String yearsOfExperience;
	
	
	@Column(name="self_rating")
	private String regDateTime;
	
	@Column(name="trainings_delivered")
	private String trainingsDelivered;
	
	@Column(name="facilities_offered")
	private String facilities; 

	public MentorSkills() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MentorSkills(long mentorId, long skilId, String yearsOfExperience, String regDateTime,
			String trainingsDelivered, String facilities) {
		super();
		this.mentorId = mentorId;
		this.skilId = skilId;
		this.yearsOfExperience = yearsOfExperience;
		this.regDateTime = regDateTime;
		this.trainingsDelivered = trainingsDelivered;
		this.facilities = facilities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public long getSkilId() {
		return skilId;
	}

	public void setSkilId(long skilId) {
		this.skilId = skilId;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getRegDateTime() {
		return regDateTime;
	}

	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}

	public String getTrainingsDelivered() {
		return trainingsDelivered;
	}

	public void setTrainingsDelivered(String trainingsDelivered) {
		this.trainingsDelivered = trainingsDelivered;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	@Override
	public String toString() {
		return "MentorSkills [id=" + id + ", mentorId=" + mentorId + ", skilId=" + skilId + ", yearsOfExperience="
				+ yearsOfExperience + ", regDateTime=" + regDateTime + ", trainingsDelivered=" + trainingsDelivered
				+ ", facilities=" + facilities + "]";
	}

}
