package com.doit.user.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "borrower")
public class BorrowerModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "mobilePhoneNumber", nullable = false)
	private String mobilePhoneNumber;
	
	@NotNull
	@Column(name = "pin", nullable = false)
	private String pin;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UserSegmentsModel> userSegmentsList;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<IncomeSegmentsModel> incomeSegmentsList;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductiveSegmentsModel> productiveSegmentsList;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FamilySegmentsModel> familySegmentsList;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmergencyContactSegmentsModel> emergencyContactSegmentsList;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BankSegmentsModel> bankSegmentsList;
	
	@OneToMany(mappedBy = "borrower", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UploadPictureModel> uploadPictureList;
	
	@NotNull
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;
	
	@NotNull
	@Column(name = "updatedTime", nullable = false)
	private Date updatedTime;
	
	@NotNull
	@Column(name = "disabled", nullable = false)
	private int disabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<UserSegmentsModel> getUserSegmentsList() {
		return userSegmentsList;
	}

	public void setUserSegmentsList(List<UserSegmentsModel> userSegmentsList) {
		this.userSegmentsList = userSegmentsList;
	}

	public List<IncomeSegmentsModel> getIncomeSegmentsList() {
		return incomeSegmentsList;
	}

	public void setIncomeSegmentsList(List<IncomeSegmentsModel> incomeSegmentsList) {
		this.incomeSegmentsList = incomeSegmentsList;
	}

	public List<ProductiveSegmentsModel> getProductiveSegmentsList() {
		return productiveSegmentsList;
	}

	public void setProductiveSegmentsList(List<ProductiveSegmentsModel> productiveSegmentsList) {
		this.productiveSegmentsList = productiveSegmentsList;
	}

	public List<FamilySegmentsModel> getFamilySegmentsList() {
		return familySegmentsList;
	}

	public void setFamilySegmentsList(List<FamilySegmentsModel> familySegmentsList) {
		this.familySegmentsList = familySegmentsList;
	}

	public List<EmergencyContactSegmentsModel> getEmergencyContactSegmentsList() {
		return emergencyContactSegmentsList;
	}

	public void setEmergencyContactSegmentsList(List<EmergencyContactSegmentsModel> emergencyContactSegmentsList) {
		this.emergencyContactSegmentsList = emergencyContactSegmentsList;
	}

	public List<BankSegmentsModel> getBankSegmentsList() {
		return bankSegmentsList;
	}

	public void setBankSegmentsList(List<BankSegmentsModel> bankSegmentsList) {
		this.bankSegmentsList = bankSegmentsList;
	}

	public List<UploadPictureModel> getUploadPictureList() {
		return uploadPictureList;
	}

	public void setUploadPictureList(List<UploadPictureModel> uploadPictureList) {
		this.uploadPictureList = uploadPictureList;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getDisabled() {
		return disabled;
	}

	public void setDisabled(int disabled) {
		this.disabled = disabled;
	}
}
