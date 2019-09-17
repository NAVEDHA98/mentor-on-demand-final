package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Skills;

public interface SkillRepository extends CrudRepository<Skills,Long> {

	List<Skills> findBySkillName(String skillName);

}
