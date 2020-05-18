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
@Table(name="productiveSegments")
public class ProductiveSegmentsModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@NotNull
	@Column(name ="applicationName", nullable=false)
	private String applicationName;
	
	@NotNull
	@Column (name="howLong", nullable=false)
	private Date howLong;
	
	@OneToMany(mappedBy = "productiveSegments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductPhotoModel> productPhotoList;
	
	@OneToMany(mappedBy = "productiveSegments", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TransactionHistoryModel> transactionHistoryList;
	
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

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public Date getHowLong() {
		return howLong;
	}

	public void setHowLong(Date howLong) {
		this.howLong = howLong;
	}

	public List<ProductPhotoModel> getProductPhotoList() {
		return productPhotoList;
	}

	public void setProductPhotoList(List<ProductPhotoModel> productPhotoList) {
		this.productPhotoList = productPhotoList;
	}

	public List<TransactionHistoryModel> getTransactionHistoryList() {
		return transactionHistoryList;
	}

	public void setTransactionHistoryList(List<TransactionHistoryModel> transactionHistoryList) {
		this.transactionHistoryList = transactionHistoryList;
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
