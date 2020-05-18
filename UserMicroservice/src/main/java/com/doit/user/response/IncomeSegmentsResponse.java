package com.doit.user.response;

public class IncomeSegmentsResponse {
    private long id;
    private String uuid;
    private String uuidBorrower;
    private String namaBorrower;
    private String companyName;
    private String industry;
    private String position;
    private long monthlyIncome;
    private String workAddrDetails;
    
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
	public String getNamaBorrower() {
		return namaBorrower;
	}
	public void setNamaBorrower(String namaBorrower) {
		this.namaBorrower = namaBorrower;
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

    

}