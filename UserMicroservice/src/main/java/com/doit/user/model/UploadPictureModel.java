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
@Table(name = "uploadPicture")
public class UploadPictureModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name = "idCard", nullable = false)
	private String idCard;
	
	@NotNull
	@Column(name = "selfie", nullable = false)
	private String selfie;
	
	@NotNull
	@Column(name = "selfieIdCard", nullable = false)
	private String selfieIdCard;
	
	@NotNull
	@Column(name = "taxCard", nullable = false)
	private String taxCard;
	
	@NotNull
	@Column(name = "paySlip", nullable = false)
	private String paySlip;
	
	@OneToMany(mappedBy = "uploadPicture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BankMutationModel> bankMutationList;
	
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSelfie() {
		return selfie;
	}

	public void setSelfie(String selfie) {
		this.selfie = selfie;
	}

	public String getSelfieIdCard() {
		return selfieIdCard;
	}

	public void setSelfieIdCard(String selfieIdCard) {
		this.selfieIdCard = selfieIdCard;
	}

	public String getTaxCard() {
		return taxCard;
	}

	public void setTaxCard(String taxCard) {
		this.taxCard = taxCard;
	}

	public String getPaySlip() {
		return paySlip;
	}

	public void setPaySlip(String paySlip) {
		this.paySlip = paySlip;
	}

	public List<BankMutationModel> getBankMutationList() {
		return bankMutationList;
	}

	public void setBankMutationList(List<BankMutationModel> bankMutationList) {
		this.bankMutationList = bankMutationList;
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
