package com.mentorondemand.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Mentor;

public interface MentorRepository extends CrudRepository<Mentor, Long> {
    
	@Query(value = "SELECT mentor FROM Mentor mentor WHERE mentor.firstName=?1")
	List<Mentor> findByFirstName(String firstname);

	List<Mentor> findByMentorId(int mentorId);

	void deleteByMentorId(int mentorId);

}
