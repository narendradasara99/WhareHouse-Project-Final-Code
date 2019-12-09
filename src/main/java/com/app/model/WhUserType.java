package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whusertab")
public class WhUserType {
	@Id
	@Column(name="id")
	@GeneratedValue
	private Integer  id;
	@Column(name="userType")
	private String  whuserType;
	@Column(name="userCode")
	private String  whuserCode;
	@Column(name="userFor")
	private String  whuserFor;
	@Column(name="userEmail")
	private String  whuserEmail;
	@Column(name="userContact")
	private String  whuserContact;
	@Column(name="userId")
	private String  whuserIdType;
	@Column(name="userIdOther")
	private String  whuserIdOther;
	@Column(name="userIdNumber")
	private String  whuserIdNumber;
	public WhUserType() {
		super();
	}
	public WhUserType(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWhuserType() {
		return whuserType;
	}
	public void setWhuserType(String whuserType) {
		this.whuserType = whuserType;
	}
	public String getWhuserCode() {
		return whuserCode;
	}
	public void setWhuserCode(String whuserCode) {
		this.whuserCode = whuserCode;
	}
	public String getWhuserFor() {
		return whuserFor;
	}
	public void setWhuserFor(String whuserFor) {
		this.whuserFor = whuserFor;
	}
	public String getWhuserEmail() {
		return whuserEmail;
	}
	public void setWhuserEmail(String whuserEmail) {
		this.whuserEmail = whuserEmail;
	}
	public String getWhuserContact() {
		return whuserContact;
	}
	public void setWhuserContact(String whuserContact) {
		this.whuserContact = whuserContact;
	}
	public String getWhuserIdType() {
		return whuserIdType;
	}
	public void setWhuserIdType(String whuserIdType) {
		this.whuserIdType = whuserIdType;
	}
	public String getWhuserIdOther() {
		return whuserIdOther;
	}
	public void setWhuserIdOther(String whuserIdOther) {
		this.whuserIdOther = whuserIdOther;
	}
	public String getWhuserIdNumber() {
		return whuserIdNumber;
	}
	public void setWhuserIdNumber(String whuserIdNumber) {
		this.whuserIdNumber = whuserIdNumber;
	}
	@Override
	public String toString() {
		return "WhUserType [id=" + id + ", whuserType=" + whuserType + ", whuserCode=" + whuserCode + ", whuserFor="
				+ whuserFor + ", whuserEmail=" + whuserEmail + ", whuserContact=" + whuserContact + ", whuserIdType="
				+ whuserIdType + ", whuserIdOther=" + whuserIdOther + ", whuserIdNumber=" + whuserIdNumber + "]";
	}




	
	

}
