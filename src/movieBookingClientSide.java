import java.util.Scanner;

import org.birlasoft.customerportal.dao.CustomerDAO;
import org.birlasoft.customerportal.dao.LoginCheckException;
import org.birlasoft.customerportal.dao.LoginDAO;

import com.birlasoft.customrportal.model.BookingsVO;
import com.birlasoft.customrportal.model.CustomerVO;
import com.birlasoft.customrportal.model.LoginVO;
import com.birlasoft.customrportal.service.CustomerBO;
import com.birlasoft.customrportal.service.LoginBO;

public class movieBookingClientSide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner input= new Scanner(System.in);
		   //Login Check for user authentication
	         String loginReq="yes";
	         int loginCheck=0;
	         
 LoginDAO loginDAO = new LoginDAO();
	         
		     while(loginReq.equalsIgnoreCase("yes"))
		     {
	System.out.println("\n Login ");	     
		     
	System.out.println("\n\n Please Enter your Credientials ");	
		  
	System.out.println("\nUser Name:");
	         String userName=input.nextLine();
	System.out.println("\nPassword:");   
	         String password=input.nextLine();
	         
	     LoginVO login = new LoginVO(userName,password);    
	         
		 boolean  loginValidate= LoginBO.loginValidate(login);
		  
		 if(loginValidate) // business logic success LoginBO
		 {
			 try
			 {
			 loginCheck = LoginDAO.loginCheck(login);
			 }
			 catch(LoginCheckException e)
			 {
				 System.out.println(e);
			 }
			 if(loginCheck==1)
			 {
				 System.out.println("login check sucesss");
				 break;
			 }
		 }
		 
		   System.out.println("Login Failed. please enter correct credentials ");

	}
		     boolean customerMenu=true;
		     while (customerMenu)
		     {
		     System.out.println("Customer Services Available :\n\n");
		     System.out.println("**************************************");
		     System.out.println("Customer Information :press 1");
		     System.out.println("Language Selection :press 2");
		     System.out.println("Movie Selection : press 3");
		     System.out.println("Create a Booking : press 4");
		     System.out.println("Search Bookings : press 5");
		     System.out.println("Update Bookings : press 6");
		     System.out.println("Delete Bookings : press 7");
		     System.out.println("Exit Application : press 8");
		     System.out.println("************************************** \n");
		    
		     System.out.println("ENTER CHOICE:");
		     int userSelection =Integer.parseInt(input.nextLine());
	         
		     switch(userSelection)
		     {
		     
		     case 1:
		     {
		     System.out.println("Add customer : press 1");
		     int customerCheck =Integer.parseInt(input.nextLine());
	                  
	         
		               if(customerCheck==1)
		               {
		    	 System.out.println("add customer details: \n");
		    	 System.out.println("**************************************");
		    	 System.out.println("Enter Customer Id: \n");
		    	   String cid= input.nextLine();
		    	   System.out.println("Enter Customer Name: \n");
		    	   String cName= input.nextLine();
		    	   System.out.println("Enter Customer Email: \n");
		    	   String cEmail= input.nextLine();
		    	   System.out.println("Enter Customer Contact: \n");
		    	   String cContact= input.nextLine();
		    	   System.out.println("Enter Customer City: \n");
		    	   String cCity= input.nextLine();
		    	   System.out.println("**************************************");
		    	   
		    	   
		    	   
		    	   CustomerVO customer = new CustomerVO(cid,cName,cEmail,cContact,cCity);
		    	   
		    	boolean result=   CustomerBO.validateCustomer(customer);
		    	   
		    	   if(result)
		    	   {
		    		  
		    		   //sending data to database
		    		   int daoResult=CustomerDAO.addCustomer(customer);
		    		   
		    		   if(daoResult>=1)
		    		   {
		    		   System.out.println("customer added in database");
		    		   }
		    		   else
		    		   {
		    			   System.out.println("  problem in adding customer");
		    		   }
		    		   }
		    	   else
		    	   {
		    		   System.out.println("prolem in validating customer");
		    	   }
		       
		               } //end of customer if
		               break;
		     }//end of case
		     
		     
		     case 2:System.out.println("Language Available \n");
		     {
		    	 System.out.println("**************************************");
		    	 CustomerDAO.getAllLang();
		    	 System.out.println("**************************************");
		    	 break;
		     }
		     
		     case 3:System.out.println("Enter Language Name to see Movies Available \n");
		     {
		    	 System.out.println("**************************************");
		    	 String lName= input.nextLine();
		    	 CustomerDAO.getAllmovies(lName);
		    	 System.out.println("**************************************");
		    	 break;
		     }
		     case 4:System.out.println("Enter Required Details to make a Booking \n");
		     {
		    	 System.out.println("**************************************");
		    	 System.out.println("Enter Customer ID");
		    	 String custid= input.nextLine();
		    	 System.out.println("Enter Movie ID");
		    	 String Mid= input.nextLine();
		    	 BookingsVO bookings = new BookingsVO(custid,Mid); 	    	   
		    	 CustomerDAO.addbookings(bookings);
		    	 System.out.println("**************************************");
		    	 System.out.println("Booking Successful");
		    	 break;
		     }
		     case 5:System.out.println("Enter CustomerID to search Booking \n");
		     {
		    	 System.out.println("**************************************");
		    	 String custID = input.nextLine();
		    	 CustomerDAO.searchbookings(custID);
		    	 System.out.println("**************************************");
		    	 break;
		    	 
		     }
		     case 6:System.out.println("Enter Details to be Updated : \n");
		     {
		    	 System.out.println("**************************************");
		    	 System.out.println("Enter Customer ID");
		    	 String custid= input.nextLine();
		    	 System.out.println("Enter Movie ID");
		    	 String Mid= input.nextLine();
		    	 CustomerDAO.updatebookings(custid,Mid);
		    	 System.out.println("**************************************");
		    	 break;
		    	 
		     }
		     case 7:System.out.println("Enter BookingId to be deleted : \n");
		     {
		    	 System.out.println("**************************************");
		    	 String bookid = input.nextLine();
		    	 CustomerDAO.deletebooking(bookid);
		    	 System.out.println("**************************************");
		    	 System.out.println("Deletion Successful");
		    	 break;
		     }
		     case 8:
		     {
		    	 System.out.println("exit  customer menu");
		    	 System.out.println("**************************************");
				    customerMenu=false;
				    break;
		    	 
		     }
		     
		     } //end of switch
		     
		     }
		     input.close();
		  	   


	}
}
