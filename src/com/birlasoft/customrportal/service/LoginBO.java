package com.birlasoft.customrportal.service;

import com.birlasoft.customrportal.model.LoginVO;

public class LoginBO {
	
	public static boolean loginValidate(LoginVO  login)
	{
		boolean loginCheck=false;
		 
			if((login.getPassword()).length()<=10)
				{
				loginCheck=true;
				
				}
					
			System.out.println("value:"+loginCheck);
		 
	return loginCheck;	
	}

}
