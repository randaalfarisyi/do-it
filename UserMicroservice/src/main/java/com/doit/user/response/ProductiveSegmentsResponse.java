package com.doit.user.response;

import java.util.Date;
import java.util.List;

import com.doit.user.model.ProductPhotoModel;
import com.doit.user.model.TransactionHistoryModel;

public class ProductiveSegmentsResponse {
    private long id;
    private String uuid;
    private String uuidBorrower;
    private String nameBorrower;
    private String applicationName;
    private Date howLong;
    private List<ProductPhotoModel> productPhotoList;
    private List<TransactionHistoryModel> transactionHistoryList;
    
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
	public String getNameBorrower() {
		return nameBorrower;
	}
	public void setNameBorrower(String nameBorrower) {
		this.nameBorrower = nameBorrower;
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
	public String getUuidBorrower() {
		return uuidBorrower;
	}
	public void setUuidBorrower(String uuidBorrower) {
		this.uuidBorrower = uuidBorrower;
	}
    
    
    
}