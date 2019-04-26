package com.kwit.model;

import java.sql.Timestamp;

/**
 * UserTable entity. 
 * @author MyEclipse Persistence Tools
 */

public class UserTable implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "UserTable [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", userName=" + userName + ", password=" + password + ", userRole=" + userRole + ", remark=" + remark
				+ ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String userName;
	private String password;
	private String userRole;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public UserTable() {
	}

	/** minimal constructor */
	public UserTable(String socialCreditCode, String storeName, String userName, String password, String userRole,
			Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.createDate = createDate;
	}

	/** full constructor */
	public UserTable(String socialCreditCode, String storeName, String userName, String password, String userRole,
			String remark, Timestamp createDate, String temp1, String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.remark = remark;
		this.createDate = createDate;
		this.temp1 = temp1;
		this.temp2 = temp2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSocialCreditCode() {
		return this.socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}

	public String getStoreName() {
		return this.storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getTemp1() {
		return this.temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return this.temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

}