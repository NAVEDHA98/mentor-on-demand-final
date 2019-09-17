package com.mentorondemand.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.Payments;

public interface PaymentRepository extends CrudRepository<Payments, Long>{

	List<Payments> findByMentorPaymentId(Long selectedId);
    
	

}
