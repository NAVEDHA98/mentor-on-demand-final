package com.mentorondemand.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commission")
public class Commission {

	public Commission() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="commission_percentage")
	private int commissionPercentage;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCommissionPercentage() {
		return commissionPercentage;
	}
	public void setCommissionPercentage(int commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	public Commission(long id, int commissionPercentage) {
		super();
		this.id = id;
		this.commissionPercentage = commissionPercentage;
	}
	public Commission( int commissionPercentage) {
		super();
		this.commissionPercentage = commissionPercentage;
	}
	
	
	
}
