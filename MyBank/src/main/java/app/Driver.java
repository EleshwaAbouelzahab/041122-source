package app;


import java.sql.Connection;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controller.UserController;
import controller.ApplicationController;
import controller.UserController3;
import controller.UserController4;
import dao.ConnectionManager;
import dao.UserDAOImpl;
import io.javalin.Javalin;
import models.UserModel;



public class Driver extends BankUser{
		
	static Scanner obj=new Scanner(System.in);
		static int amount;
		static int balance;
	    static int account;
	    static int sac;
	    static int ch;
	    static String username;
	
	     static Logger lg=LogManager.getLogger(Driver.class);
		 
	    
	   //Main Method
	   public static void main(String[] arguments) {

		 	 
		 Javalin app = Javalin.create().start(7075);
			
		 UserController userController = new UserController(app);
		 ApplicationController userController2 = new ApplicationController(app);
		 UserController3 userController3 = new UserController3(app);
		 UserController4 userController4 = new UserController4(app);


		
       	

		   	//Main Menu
		   	while(true) {
		   		
		   			System.out.println("*******WELCOME TO MYBANK********");
			    	System.out.println("1. Login.");
			    	System.out.println("2. Open an account.");
			    	System.out.println("3. Account Status.");
			    	System.out.println("4. Employee Login.");
			    	System.out.println("5. Exit.");
			    	System.out.println("Please enter your choice: ");
			    	
			        ch=obj.nextInt();
					   lg.info("Welcome to MyBank app");

			        switch(ch){
	        //Login case
	        case 1:
				Connection connection = ConnectionManager.getConnection();

				
				try {  
							
					System.out.println("Username: ");
      			  	BankUser.username = obj.next();
      			  	System.out.println("Password: ");
      			  	BankUser.password = obj.next();
  		    
	      			UserDAOImpl dao = new UserDAOImpl();
	      			UserModel user = dao.get(BankUser.username);
	      			  
				
						if(user==null) {
	      					 System.out.println("Your account can't be found");
	      					 lg.error("the usernanme is not found.");
						}
	      				 else if(BankUser.username.equals(user.username) && BankUser.password.equals(user.password)){
	      				 
	      					 System.out.println("<----------You Loged in SUCCESSFULLY------------>");
	      				 
	      			 	
	        	if(user !=null)
	        	Operations.menu();
							 
			      				 }
			      			      else {
			      			       System.out.println("Your account can't be found");
			      			      }
								
						}catch(Exception e){
			      				    e.printStackTrace();
			      				   }
						
			      			  
						
						return;
					 
			        //create an account choice
			        case 2:
			        	  BankUser.addUser();
			   		      lg.info("User was added");

			        	  
			        	  break;
			        
			       //to get account status choice
			        case 3:
			        	  BankUser.accstatus();
			   		      lg.info("An account status was asked for");

				          //Operations.menu();

			        	  continue;
			        
			      //employee login in choice
			        case 4:
			        	   BankEmployee.employee();
				   		      lg.info("an employee was loged in");

			        	   break;
			        
			        //exit choice
			        case 5:
			        	lg.info("Come Again soon!!");

			        	System.out.println("Hope to see you again soon.");

			        	System.exit(5);
			      
		        		

			        	break;
			        
			        //in case the choice wasn't a number from 1 to 5
			        default:
			        	lg.error("invalid choice");
			    		System.out.println("Invalid Option/ Please enter a vaild choice.");
			    }
		   	}
	   }
}
	   


   