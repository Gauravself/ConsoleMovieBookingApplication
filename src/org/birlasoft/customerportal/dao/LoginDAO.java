package org.birlasoft.customerportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.birlasoft.customrportal.model.LoginVO;
import com.birlasoft.customrportal.util.ConnectionDB;

public class LoginDAO {
	public static int loginCheck(LoginVO login) throws LoginCheckException
	{    int result=0;
		Connection con =null;
		String QUERY="select user_name, password from login where user_name=? and password=?";
		try
		{
		ConnectionDB.loadDrivers();
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in loading connection"+e);
		}
		
		try
		{
		con= ConnectionDB.getDBConnection();
		
		System.out.println("in login dao:"+login);
		PreparedStatement pStat = con.prepareStatement(QUERY);
		                 pStat.setString(1, login.getUserName().trim());
		                 pStat.setString(2, login.getPassword().trim());
		                  
		                ResultSet loginResult= pStat.executeQuery();
		                
		                if(loginResult.next())
		                	
		                {
		                	result=1;
		                }
		                else
		                {
		                	System.out.println("no record found");
		                }
		                 
		
		}
		catch(CustomerDatabaseException e)
		{
			
			 throw new LoginCheckException(e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:"+e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
		System.out.println("result :"+result);
		return result;
	}

}
