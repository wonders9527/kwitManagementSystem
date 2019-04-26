package com.kwit.model;

import java.sql.Timestamp;
import java.util.Date;


public class RecordMemberRecharge implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "RecordMemberRecharge [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", memberName=" + memberName + ", memberPhone=" + memberPhone + ", memberIdNumber=" + memberIdNumber
				+ ", rechargeDate=" + rechargeDate + ", paymentMethod=" + paymentMethod + ", rechargeAmount="
				+ rechargeAmount + ", remark=" + remark + ", createDate=" + createDate + ", temp1=" + temp1 + ", temp2="
				+ temp2 + "]";
	}
	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String memberName;
	private String memberPhone;
	private String memberIdNumber;
	private Date rechargeDate;
	private String paymentMethod;
	private Double rechargeAmount;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public RecordMemberRecharge() {
	}

	/** minimal constructor */
	public RecordMemberRecharge(String socialCreditCode, String storeName, String memberName, String memberPhone,
			String memberIdNumber, Date rechargeDate, String paymentMethod, Double rechargeAmount,
			Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberIdNumber = memberIdNumber;
		this.rechargeDate = rechargeDate;
		this.paymentMethod = paymentMethod;
		this.rechargeAmount = rechargeAmount;
		this.createDate = createDate;
	}

	/** full constructor */
	public RecordMemberRecharge(String socialCreditCode, String storeName, String memberName, String memberPhone,
			String memberIdNumber, Date rechargeDate, String paymentMethod, Double rechargeAmount, String remark,
			Timestamp createDate, String temp1, String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberIdNumber = memberIdNumber;
		this.rechargeDate = rechargeDate;
		this.paymentMethod = paymentMethod;
		this.rechargeAmount = rechargeAmount;
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

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return this.memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberIdNumber() {
		return this.memberIdNumber;
	}

	public void setMemberIdNumber(String memberIdNumber) {
		this.memberIdNumber = memberIdNumber;
	}

	public Date getRechargeDate() {
		return this.rechargeDate;
	}

	public void setRechargeDate(Date rechargeDate) {
		this.rechargeDate = rechargeDate;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getRechargeAmount() {
		return this.rechargeAmount;
	}

	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
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