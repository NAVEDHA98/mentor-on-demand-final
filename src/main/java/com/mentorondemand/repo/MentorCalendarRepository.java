package com.mentorondemand.repo;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.MentorCalendar;

public interface MentorCalendarRepository extends CrudRepository<MentorCalendar, Long> {

	MentorCalendar findByMentorId(long mentorId);

}
