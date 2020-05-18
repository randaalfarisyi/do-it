package com.doit.user.response;

public class BankSegmentsResponse {
    private long id;
    private String uuid;
    private String uuidBorrower;
    private String nameBorrower;
    private String code;
    private long accountNumber;
    private String accountHolderName;
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
	public String getUuidBorrower() {
		return uuidBorrower;
	}
	public void setUuidBorrower(String uuidBorrower) {
		this.uuidBorrower = uuidBorrower;
	}
	public String getNameBorrower() {
		return nameBorrower;
	}
	public void setNameBorrower(String nameBorrower) {
		this.nameBorrower = nameBorrower;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
    
    


}