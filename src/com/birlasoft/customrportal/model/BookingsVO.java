package com.birlasoft.customrportal.model;

public class BookingsVO {
	private String customerID;
	private String movieID;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getMovieID() {
		return movieID;
	}
	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}
	public BookingsVO(String customerID, String movieID) {
		super();
		this.customerID = customerID;
		this.movieID = movieID;
	}
	public BookingsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookingsVO [customerID=" + customerID + ", movieID=" + movieID + "]";
	}
	

}
