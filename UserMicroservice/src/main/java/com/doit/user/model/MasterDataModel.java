package com.doit.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "masterData")
public class MasterDataModel implements Serializable{
	@Column(name = "id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String uuid;
	
	@Column(name = "parentUuid")
	private String parentUuid;
	
	@Column(name = "remark")
	private String remark;
	
	@NotNull
	@Column(name = "groupData", nullable = false)
	private String groupData;
	
	@NotNull
	@Column(name = "code", nullable = false)
	private String code;
	
	@NotNull
	@Column(name = "idValue", nullable = false)
	private String idValue;
	
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

	public String getParentUuid() {
		return parentUuid;
	}

	public void setParentUuid(String parentUuid) {
		this.parentUuid = parentUuid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroupData() {
		return groupData;
	}

	public void setGroupData(String groupData) {
		this.groupData = groupData;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
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
