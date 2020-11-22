package com.birlasoft.customrportal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.birlasoft.customerportal.dao.CustomerDatabaseException;

public class ConnectionDB {
	
	private static Connection  con;
	public static void loadDrivers() throws CustomerDatabaseException
	{
		 try
		 {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 }
		 catch(ClassNotFoundException e)
		 {
			 throw new CustomerDatabaseException("problem in loading drivers");
			 
		 }
	}
	
  public static  Connection  getDBConnection() throws CustomerDatabaseException 
  {
	  try
	  {
	  String url="jdbc:oracle:thin:@localhost:1521:orcl" ;
	  con = DriverManager.getConnection(url,"hr","12");
	  }
	  catch(SQLException e)
	  {
		  throw new CustomerDatabaseException("problem in loading drivers");
			 
		  
	  }
	  return con;
  }
	
  public static void closeDBConnection(Connection con)  
  {
	  try
	  {
	   if(con!=null)
	   {
		   con.close();
	   }
	  }
	  catch(SQLException e)
	  {
		  System.out.println("problem in closing connection"+e);
	  }
  }
  
  
  
	
}
