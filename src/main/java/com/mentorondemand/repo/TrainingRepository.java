package com.mentorondemand.repo;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Trainings;

public interface TrainingRepository extends CrudRepository<Trainings, Long>{

}
