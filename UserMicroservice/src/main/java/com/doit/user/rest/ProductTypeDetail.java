package com.doit.user.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductTypeDetail {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("uuid")
	private String uuid;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("amountAplly")
	private long amountApply;
	
	@JsonProperty("amountDisbursed")
	private long amountDisbursed;
	
	@JsonProperty("installment")
	private long installment;
	
	@JsonProperty("borrowingTerm")
	private int borrowingTerm;
	
	@JsonProperty("tenor")
	private int tenor;
	
	@JsonProperty("serviceFeeRate")
	private double serviceFeeRate;
	
	@JsonProperty("interestRate")
	private double interestRate;
	
	@JsonProperty("overdueRate")
	private long overdueRate;
	
	@JsonProperty("penaltyRate")
	private double penaltyRate;
	
	@JsonProperty("targetNpl")
	private double targetNpl;
	
	@JsonProperty("disabled")
	private int disabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAmountApply() {
		return amountApply;
	}

	public void setAmountApply(long amountApply) {
		this.amountApply = amountApply;
	}

	public long getAmountDisbursed() {
		return amountDisbursed;
	}

	public void setAmountDisbursed(long amountDisbursed) {
		this.amountDisbursed = amountDisbursed;
	}

	public long getInstallment() {
		return installment;
	}

	public void setInstallment(long installment) {
		this.installment = installment;
	}

	public int getBorrowingTerm() {
		return borrowingTerm;
	}

	public void setBorrowingTerm(int borrowingTerm) {
		this.borrowingTerm = borrowingTerm;
	}

	public int getTenor() {
		return tenor;
	}

	public void setTenor(int tenor) {
		this.tenor = tenor;
	}

	public double getServiceFeeRate() {
		return serviceFeeRate;
	}

	public void setServiceFeeRate(double serviceFeeRate) {
		this.serviceFeeRate = serviceFeeRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public long getOverdueRate() {
		return overdueRate;
	}

	public void setOverdueRate(long overdueRate) {
		this.overdueRate = overdueRate;
	}

	public double getPenaltyRate() {
		return penaltyRate;
	}

	public void setPenaltyRate(double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	public double getTargetNpl() {
		return targetNpl;
	}

	public void setTargetNpl(double targetNpl) {
		this.targetNpl = targetNpl;
	}

	public int getDisabled() {
		return disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}
}
