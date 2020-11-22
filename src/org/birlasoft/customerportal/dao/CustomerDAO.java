package org.birlasoft.customerportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.birlasoft.customrportal.model.BookingsVO;
import com.birlasoft.customrportal.model.CustomerVO;
import com.birlasoft.customrportal.util.ConnectionDB;

public class CustomerDAO {

	public static int addCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		
		 int result=0;
			Connection con =null;
			String QUERY="insert into consumer_info values(?,?,?,?,?)";
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
			
			
			PreparedStatement pStat = con.prepareStatement(QUERY);
			                 pStat.setString(1, customer.getCustomerId());
			                 pStat.setString(2, customer.getCustomerName());
			                 pStat.setString(3, customer.getContactEmail());
			                 pStat.setString(4, customer.getCustomerContact());
			                 pStat.setString(5, customer.getCustomerCity());
			                result= pStat.executeUpdate();
			                
			                 
			
			}
			catch(CustomerDatabaseException e)
			{
				System.out.println("problem in connection:"+e);
			}
			catch(SQLException e)
			{
				System.out.println("problem in connection:"+e);
			}
			finally
			{
				ConnectionDB.closeDBConnection(con);
			}
			
			return result;
	}

	public static void getAllLang() {
		// TODO Auto-generated method stub
		ResultSet rs;
		Connection con =null;
		String QUERY="select*from language_select";
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
		
		
		PreparedStatement pStat = con.prepareStatement(QUERY);
	     rs = pStat.executeQuery(QUERY);
	     if(rs.next()) {
				do {
					System.out.println(rs.getString(1));
				}while(rs.next());
				
			}
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:" +e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}		
	}

	public static void getAllmovies(String lName) {
		// TODO Auto-generated method stub
		Connection con =null;
		String QUERY="select * from movie_selection where lang_name = ?";
		String lang_name = lName;
		 
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
		
		
		PreparedStatement pStat = con.prepareStatement(QUERY);
		pStat.setString(1,lang_name);
		ResultSet result= pStat.executeQuery();
		
		if(result.next()) {
			do {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}while(result.next());
			
		}
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:" +e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
		
	}

	

	public static void addbookings(BookingsVO bookings) {
		 Connection con =null;
		String QUERY="insert into MOVIE_BOOKINGS (con_id,movie_id) values(?,?)";
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
		
		
		PreparedStatement pStat = con.prepareStatement(QUERY);
		                 pStat.setString(1, bookings.getCustomerID());
		                 pStat.setString(2, bookings.getMovieID());
		                 pStat.executeUpdate();                 
		
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:"+e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
	}

	public static void searchbookings(String custID) {
		// TODO Auto-generated method stub
		
		ResultSet rs;
		Connection con =null;
		String QUERY="select * from movie_bookings b join consumer_info c on b.con_id = c.con_id join movie_selection m on b.movie_id = m.movie_id where b.con_id=?";
		String con_id = custID;
		
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
		
		
		PreparedStatement pStat = con.prepareStatement(QUERY);
		pStat.setString(1, con_id);
	     rs = pStat.executeQuery();
	     if(rs.next()) {
				do {
					System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12));
				}while(rs.next());
				
			}
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:" +e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}		
		
		
	}

	public static void deletebooking(String bookid) {
		// TODO Auto-generated method stub
		Connection con =null;
		String QUERY="Delete from movie_bookings where bookings_id=?";
		String bookings_id=bookid;
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
		
		
		PreparedStatement pStat = con.prepareStatement(QUERY);
		pStat.setString(1, bookings_id);
		pStat.executeQuery();
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:" +e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
	}

	public static void updatebookings(String custid, String mid) {
		// TODO Auto-generated method stub
		Connection con =null;
		String QUERY="update movie_bookings set movie_id = ? where con_id = ?";
		String movie_id=mid;
		String con_id=custid;
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
		
		
		PreparedStatement pStat = con.prepareStatement(QUERY);
		pStat.setString(1, movie_id);
		pStat.setString(2, con_id);
		pStat.executeQuery();
		}
		catch(CustomerDatabaseException e)
		{
			System.out.println("problem in connection:"+e);
		}
		catch(SQLException e)
		{
			System.out.println("problem in connection:" +e);
		}
		finally
		{
			ConnectionDB.closeDBConnection(con);
		}
	}
	

	

}
