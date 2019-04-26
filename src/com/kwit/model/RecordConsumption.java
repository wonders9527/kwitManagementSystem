package com.kwit.model;

import java.sql.Timestamp;

public class RecordConsumption implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "RecordConsumption [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", consumptionNumber=" + consumptionNumber + ", department=" + department + ", operator=" + operator
				+ ", customerType=" + customerType + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", consumptionAmount=" + consumptionAmount + ", accountBalance=" + accountBalance
				+ ", paymentMethod=" + paymentMethod + ", paymentAccount=" + paymentAccount + ", refundStatus="
				+ refundStatus + ", refundTime=" + refundTime + ", coupon=" + coupon + ", consumptionTime="
				+ consumptionTime + ", status=" + status + ", remark=" + remark + ", createDate=" + createDate
				+ ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}
	private Integer id;
	private String socialCreditCode;
	private String storeName;
	private String consumptionNumber;
	private String department;
	private String operator;
	private String customerType;
	private String customerName;
	private String customerPhone;
	private String consumptionAmount;
	private String accountBalance;
	private String paymentMethod;
	private String paymentAccount;
	private String refundStatus;
	private Timestamp refundTime;
	private String coupon;
	private Timestamp consumptionTime;
	private String status;
	private String remark;
	private Timestamp createDate;
	private String temp1;
	private String temp2;

	// Constructors

	/** default constructor */
	public RecordConsumption() {
	}

	/** minimal constructor */
	public RecordConsumption(String socialCreditCode, String storeName, String consumptionNumber, String department,
			Timestamp createDate) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.consumptionNumber = consumptionNumber;
		this.department = department;
		this.createDate = createDate;
	}

	/** full constructor */
	public RecordConsumption(String socialCreditCode, String storeName, String consumptionNumber, String department,
			String operator, String customerType, String customerName, String customerPhone, String consumptionAmount,
			String accountBalance, String paymentMethod, String paymentAccount, String refundStatus,
			Timestamp refundTime, String coupon, Timestamp consumptionTime, String status, String remark,
			Timestamp createDate, String temp1, String temp2) {
		this.socialCreditCode = socialCreditCode;
		this.storeName = storeName;
		this.consumptionNumber = consumptionNumber;
		this.department = department;
		this.operator = operator;
		this.customerType = customerType;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.consumptionAmount = consumptionAmount;
		this.accountBalance = accountBalance;
		this.paymentMethod = paymentMethod;
		this.paymentAccount = paymentAccount;
		this.refundStatus = refundStatus;
		this.refundTime = refundTime;
		this.coupon = coupon;
		this.consumptionTime = consumptionTime;
		this.status = status;
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

	public String getConsumptionNumber() {
		return this.consumptionNumber;
	}

	public void setConsumptionNumber(String consumptionNumber) {
		this.consumptionNumber = consumptionNumber;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getConsumptionAmount() {
		return this.consumptionAmount;
	}

	public void setConsumptionAmount(String consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

	public String getAccountBalance() {
		return this.accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}                                    

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentAccount() {
		return this.paymentAccount;
	}

	public void setPaymentAccount(String paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

	public String getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Timestamp getRefundTime() {
		return this.refundTime;
	}

	public void setRefundTime(Timestamp refundTime) {
		this.refundTime = refundTime;
	}

	public String getCoupon() {
		return this.coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public Timestamp getConsumptionTime() {
		return this.consumptionTime;
	}

	public void setConsumptionTime(Timestamp consumptionTime) {
		this.consumptionTime = consumptionTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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