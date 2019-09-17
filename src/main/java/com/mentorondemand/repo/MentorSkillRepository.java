package com.mentorondemand.repo;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.MentorSkills;

public interface MentorSkillRepository extends CrudRepository<MentorSkills,Long> {

	MentorSkills save(MentorSkills mentorSkills);

}
