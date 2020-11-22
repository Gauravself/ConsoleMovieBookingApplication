package com.birlasoft.customrportal.service;

import com.birlasoft.customrportal.model.CustomerVO;

public class CustomerBO {

	public static  boolean validateCustomer(CustomerVO  customer)
	{
		boolean result=false;
		
		String cId = customer.getCustomerId();
		
		if(cId.substring(0,2).equals("C-"))
		{
			result=true;
			
		}
		
		return result;
	}
	
}
