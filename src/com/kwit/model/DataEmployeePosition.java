package com.kwit.model;

import java.sql.Timestamp;

public class DataEmployeePosition  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields    

     
     @Override
	public String toString() {
		return "DataEmployeePosition [id=" + id + ", socialCreditCode=" + socialCreditCode + ", storeName=" + storeName
				+ ", positionTitle=" + positionTitle + ", basicWage=" + basicWage + ", createDate=" + createDate
				+ ", temp1=" + temp1 + ", temp2=" + temp2 + "]";
	}
     private Integer id;
	 private String socialCreditCode;
     private String storeName;
     private String positionTitle;
     private String basicWage;
     private Timestamp createDate;
     private String temp1;
     private String temp2;


    // Constructors

    /** default constructor */
    public DataEmployeePosition() {
    }

    
    /** full constructor */
    public DataEmployeePosition(String socialCreditCode, String storeName, String positionTitle, String basicWage, Timestamp createDate, String temp1, String temp2) {
        this.socialCreditCode = socialCreditCode;
        this.storeName = storeName;
        this.positionTitle = positionTitle;
        this.basicWage = basicWage;
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

    public String getPositionTitle() {
        return this.positionTitle;
    }
    
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getBasicWage() {
        return this.basicWage;
    }
    
    public void setBasicWage(String basicWage) {
        this.basicWage = basicWage;
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