package com.mentorondemand.repo;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Commission;

public interface CommissionRepository extends CrudRepository<Commission, Long> {

}
