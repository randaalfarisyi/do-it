package com.doit.user.response;

import java.util.Date;
import java.util.List;

import com.doit.user.model.AlternativeMobilePhoneModel;
import com.doit.user.model.HomeAddrRegionModel;
import com.doit.user.model.HomePhoneModel;

public class UserSegmentsResponse {
    private long id;
    private String uuid;
    private String uuidBorrower;
    private String fullName;
    private String email;
    private String birthCity;
    private Date birthDate;
    private String religion;
    private String gender;
    private String education;
	private List<HomePhoneModel> homePhoneList;
	private List<String> kodeArea;
	private List<String> nomorRumah;
	private List<String> contactType;
    private List<AlternativeMobilePhoneModel> alternativeMobilePhoneList;
	private String homeAddrDetails;
	private List<HomeAddrRegionModel> homeAddrRegionList;
    private String province;
    private String city;
    private String district;
    private String subdistrict;
    private String village;

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
	public String getHomeAddrDetails() {
		return homeAddrDetails;
	}
	public void setHomeAddrDetails(String homeAddrDetails) {
		this.homeAddrDetails = homeAddrDetails;
	}
	public String getUuidBorrower() {
		return uuidBorrower;
	}
	public void setUuidBorrower(String uuidBorrower) {
		this.uuidBorrower = uuidBorrower;
	}
	public List<String> getKodeArea(){
		return kodeArea;
	}
	public void setKodeArea(List<String> kodeArea) {
		this.kodeArea = kodeArea;
	}
	public List<String> getNomorRumah(){
		return nomorRumah;
	}
	public void setNomorRumah(List<String> nomorRumah) {
		this.nomorRumah = nomorRumah;
	}
	public List<HomeAddrRegionModel> getHomeAddrRegionList() {
		return homeAddrRegionList;
	}
	public void setHomeAddrRegionList(List<HomeAddrRegionModel> homeAddrRegionList) {
		this.homeAddrRegionList = homeAddrRegionList;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSubdistrict() {
		return subdistrict;
	}
	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public List<String> getContactType() {
		return contactType;
	}
	public void setContactType(List<String> contactType) {
		this.contactType = contactType;
	}
	

}