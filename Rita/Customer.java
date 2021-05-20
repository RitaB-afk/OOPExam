package com.exam.OOPGroup14;

import java.math.BigDecimal;

public class Customer {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private int salesRepEmployeeNumber;
    private BigDecimal creditLimit;

    public Customer(int customerNumber,String customerName,String contactLastName,String contactFirstName,
            String phone,
            String addressLine1,
            String addressLine2,
            String city,
            String state,
            String postalCode,
            String country,
            int salesRepEmployeeNumber,
            BigDecimal creditLimit) {
        super();
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.contactFirstName = contactFirstName;
        this.phone = phone;
        this.addressLine1=addressLine1;
        this.addressLine2=addressLine2;
        this.city=city;
        this.state=state;
        this.postalCode=postalCode;
        this.country=country;
        this.salesRepEmployeeNumber=salesRepEmployeeNumber;
        this.creditLimit=creditLimit;
    }
    //getter and setter methods
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }
    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String  city) {
        this.city= city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
		return String.format("Customer[ CustomerNumber: " + this.getCustomerNumber() + ", customerName: " + this.getCustomerName() + ", contactLastName: " + this.getContactLastName() + ", contactFirstName: " + this.getContactFirstName() + ", phone: " + this.getPhone() + ", addressLine1: " + this.getAddressLine1() + ", addressLine2: " + this.getAddressLine2() + ", city: " + this.getCity() + ", state: " + this.getState() + ", postalCode: " + this.getPostalCode() + ", country: " + this.getCountry() + ", salesRepEmployeeNumber: " + this.getSalesRepEmployeeNumber() + ", creditLimit: " + this.getCreditLimit());
		
	}

}
