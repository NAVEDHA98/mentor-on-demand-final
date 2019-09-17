package com.mentorondemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_history")
public class PaymentHistory {
	public PaymentHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="payment_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	@Column(name="user_id")
	private long userId;
	@Column(name="skill_id")
	private long skillId;
	
	@Column(name="payment_amount")
	private String paymentAmount;

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	@Override
	public String toString() {
		return "PaymentHistory [paymentId=" + paymentId + ", userId=" + userId + ", skillId=" + skillId
				+ ", paymentAmount=" + paymentAmount + "]";
	}

	public PaymentHistory(long userId, long skillId, String paymentAmount) {
		super();
		this.userId = userId;
		this.skillId = skillId;
		this.paymentAmount = paymentAmount;
	}
	
    
}
