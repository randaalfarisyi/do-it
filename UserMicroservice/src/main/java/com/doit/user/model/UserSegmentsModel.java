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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "userSegments")
public class UserSegmentsModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name = "fullName", nullable = false)
	private String fullName;
	
	@NotNull
	@Column(name = "email", nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "birthCity", nullable = false)
	private String birthCity;
	
	@NotNull
	@Column(name = "birthDate", nullable = false)
	private Date birthDate;
	
	@NotNull
	@Column(name = "religion", nullable = false)
	private String religion;
	
	@NotNull
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@NotNull
	@Column(name = "education", nullable = false)
	private String education;
	
	@OneToMany(mappedBy = "userSegments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<HomePhoneModel> homePhoneList;
	
	@OneToMany(mappedBy = "userSegments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AlternativeMobilePhoneModel> alternativeMobilePhoneList;
	
	@OneToMany(mappedBy = "userSegments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<HomeAddrRegionModel> homeAddrRegionList;
	
	@NotNull
	@Column(name = "homeAddrDetails", nullable = false)
	private String homeAddrDetails;
	
	@NotNull
	@Column(name = "createdTime", nullable = false)
	private Date createdTime;
	
	@NotNull
	@Column(name = "updatedTime", nullable = false)
	private Date updatedTime;
	
	@NotNull
	@Column(name = "disabled", nullable = false)
	private int disabled;
	
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public List<HomePhoneModel> getHomePhoneList() {
		return homePhoneList;
	}

	public void setHomePhoneList(List<HomePhoneModel> homePhoneList) {
		this.homePhoneList = homePhoneList;
	}

	public List<AlternativeMobilePhoneModel> getAlternativeMobilePhoneList() {
		return alternativeMobilePhoneList;
	}

	public void setAlternativeMobilePhoneList(List<AlternativeMobilePhoneModel> alternativeMobilePhoneList) {
		this.alternativeMobilePhoneList = alternativeMobilePhoneList;
	}

	public List<HomeAddrRegionModel> getHomeAddrRegionList() {
		return homeAddrRegionList;
	}

	public void setHomeAddrRegionList(List<HomeAddrRegionModel> homeAddrRegionList) {
		this.homeAddrRegionList = homeAddrRegionList;
	}

	public String getHomeAddrDetails() {
		return homeAddrDetails;
	}

	public void setHomeAddrDetails(String homeAddrDetails) {
		this.homeAddrDetails = homeAddrDetails;
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

	public BorrowerModel getBorrower() {
		return borrower;
	}

	public void setBorrower(BorrowerModel borrower) {
		this.borrower = borrower;
	}
}
