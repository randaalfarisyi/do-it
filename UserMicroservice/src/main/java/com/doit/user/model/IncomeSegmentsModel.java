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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "incomeSegments")
public class IncomeSegmentsModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name = "companyName", nullable = false)
	private String companyName;
	
	@NotNull
	@Column(name = "industry", nullable = false)
	private String industry;
	
	@NotNull
	@Column(name = "position", nullable = false)
	private String position;
	
	@NotNull
	@Column(name = "monthlyIncome", nullable = false)
	private long monthlyIncome;
	
	@NotNull
	@Column(name = "workAddrDetails", nullable = false)
	private String workAddrDetails;
	
	@NotNull
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;
	
	@NotNull
	@Column(name = "updatedTime", nullable = false)
	private Date updatedTime;
	
	@NotNull
	@Column(name = "disabled", nullable = false)
	private int disabled;
	
	@OneToMany(mappedBy = "incomeSegments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<WorkAddrRegionModel> workAddrRegionList;
	
	@OneToMany(mappedBy = "incomeSegments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<WorkPhoneModel> workPhoneList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uuidBorrower", referencedColumnName = "uuid", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private BorrowerModel borrower;

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public long getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getWorkAddrDetails() {
		return workAddrDetails;
	}

	public void setWorkAddrDetails(String workAddrDetails) {
		this.workAddrDetails = workAddrDetails;
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

	public List<WorkAddrRegionModel> getWorkAddrRegionList() {
		return workAddrRegionList;
	}

	public void setWorkAddrRegionList(List<WorkAddrRegionModel> workAddrRegionList) {
		this.workAddrRegionList = workAddrRegionList;
	}

	public List<WorkPhoneModel> getWorkPhoneList() {
		return workPhoneList;
	}

	public void setWorkPhoneList(List<WorkPhoneModel> workPhoneList) {
		this.workPhoneList = workPhoneList;
	}

	public BorrowerModel getBorrower() {
		return borrower;
	}

	public void setBorrower(BorrowerModel borrower) {
		this.borrower = borrower;
	}
}
