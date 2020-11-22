package com.birlasoft.customrportal.model;

public class CustomerVO implements Comparable<CustomerVO>{
	private String customerId;
	private String customerName;
	private String contactEmail;
	private String customerContact;
	private String customerCity;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerCity() {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	public CustomerVO(String customerId, String customerName, String contactEmail, String customerContact,
			String customerCity) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactEmail = contactEmail;
		this.customerContact = customerContact;
		this.customerCity = customerCity;
	}
	public CustomerVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CustomerVO [customerId=" + customerId + ", customerName=" + customerName + ", contactEmail="
				+ contactEmail + ", customerContact=" + customerContact + ", customerCity=" + customerCity + "]";
	}
	@Override
	public int compareTo(CustomerVO secondObj	) {
		
		int result=0;
		String firstObjName= this.getCustomerName();
		   String secondObjName= secondObj.getCustomerName();
		
		   result=  firstObjName.compareTo(secondObjName);
		   
		return result;
	}
	
}
