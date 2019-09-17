package com.mentorondemand.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mentorondemand.model.PaymentHistory;

public interface PaymentHistoryRepository extends CrudRepository<PaymentHistory, Long>{

	List<PaymentHistory> findByPaymentId(Long selectedId);

}
