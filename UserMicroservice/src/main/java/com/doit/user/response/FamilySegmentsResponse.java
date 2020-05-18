package com.doit.user.response;

public class FamilySegmentsResponse {
    private long id;
    private String uuid;
    private String uuidBorrower;
    private String namaBorrower;
    private String status;
    private String relationship;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
    
    

}