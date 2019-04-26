package com.kwit.model;

import java.sql.Timestamp;

/**
 * FrequencyInformation entity. @author MyEclipse Persistence Tools
 */

public class FrequencyInformation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "FrequencyInformation [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", frequencyName=" + frequencyName + ", frequencyTimes=" + frequencyTimes + ", remark=" + remark
				+ ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}

	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String frequencyName;
	private String frequencyTimes;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public FrequencyInformation() {
	}

	/** minimal constructor */
	public FrequencyInformation(String socialCreditCode, String storeName, String frequencyName, String frequencyTimes,
			Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.frequencyName = frequencyName;
		this.frequencyTimes = frequencyTimes;
		this.createDate = createDate;
	}

	/** full constructor */
	public FrequencyInformation(String socialCreditCode, String storeName, String frequencyName, String frequencyTimes,
			String remark, Timestamp createDate, String temp1, String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.frequencyName = frequencyName;
		this.frequencyTimes = frequencyTimes;
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

	public String getFrequencyName() {
		return this.frequencyName;
	}

	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}

	public String getFrequencyTimes() {
		return this.frequencyTimes;
	}

	public void setFrequencyTimes(String frequencyTimes) {
		this.frequencyTimes = frequencyTimes;
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