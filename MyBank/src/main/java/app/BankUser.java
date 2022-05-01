package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dao.ApplicationIdDAOImpl;
import dao.ConnectionManager;
import dao.UserDAOImpl;
import dao.UserInfoDAO;
import dao.UserInfoImpl;
import models.ApplicationIdModel;
import models.UserModel;

public class BankUser{
	
	public static int applicationid;
	public static String firstname;
	public static String lastname;
	public static String streetaddress;
	public static String city;
	public static String state;
	public static String phonenumber;
	public static String email;
	public static String password;
	public static String status="pending";
	public static int accno;
	public static int balance;
	public static int transferid;
	public static String username;
	public static String accounttype;
	public static String contact_id;
	int ch;

	
	
	static Scanner obj=new Scanner(System.in);
	
	

	
	
	public static  void transfermation() {
		transferid=(int)(Math.random()*(10000-100+1)+100);
		
	}
	
	
		   
	//THIS IS TO CREATE AN ACCOUNT
	public static void accreation() {
		try {
			accno=(int)(Math.random()*(1000000-10000+1)+10000);
			
			
			ResultSet rs=ConnectionManager.getConnection().prepareStatement("select *from applications "
					+ "where status='"+status+"'").executeQuery();
			
			rs.next();
			
	
			UserInfoImpl dao = new UserInfoImpl();
			BankUser user = dao.addUser(email);
			
			ConnectionManager.getConnection().prepareStatement("insert into applications values("+rs.getInt("applicationid")
					+","+ ""+username+")").execute();
			
//			ApplicationIdDAOImpl dao1 = new ApplicationIdDAOImpl();
//			Application user1 = dao1.newapplication(applicationid);
//			
		
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	
	//TO CHECK ACCOUNT STATUS
	public static void accstatus() {
		 try {
			System.out.println("Enter your username: ");
			username=obj.next();
			
			ApplicationIdDAOImpl dao = new ApplicationIdDAOImpl();
			ApplicationIdModel user = dao.getapplication(username);	
			
			
			if(user==null) {
				System.out.println("Account can't be found!");
			}else if(user.status.equals("accepted")) {
			 
				ApplicationIdDAOImpl dao1 = new ApplicationIdDAOImpl();
				ApplicationIdModel user1 = dao.getapplication(username);
				
    			System.out.println("Congratualtions your account was created SUCCESSFULLY");
			}
			else{
				if(user.status.equals("pending")) {
					System.out.println("Your Appication still pending");
					System.out.println("Please Check again later.");
				
				}else {
					System.out.println("Your application is rejected.");
					}
		} }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//TO CREATE A NEW USER
	public static void addUser() {
			System.out.println("First Name: ");
		    firstname=obj.next();
		    System.out.println("Last Name: ");
		    lastname=obj.next();
			System.out.println("Street Address: ");
			streetaddress=obj.next();
			System.out.println("City: ");
			city=obj.next();
			System.out.println("State: ");
			state=obj.next();
			System.out.println("Phone Number: ");
			phonenumber=obj.next();
			System.out.println("Email: ");
			email=obj.next();
			System.out.println("PLEASE CHOOSE YOUR ACCOUNT TYPE:");
			System.out.println("CHECKING, SAVING, OR JOINT ");
			accounttype=obj.next();
			System.out.println("Username: ");
			username=obj.next();
			System.out.println("Password: ");
			password=obj.next();
			System.out.println("Retype Password: ");
			String password1=obj.next();
			status = "pending";
							
			if(password.compareTo(password1)==0){
				
				applicationid=(int)(Math.random()*(1000000-50000+1)+50000);
				try {
					
						UserDAOImpl dao = new UserDAOImpl();
						dao.addUser();
					
					
						UserInfoImpl dao1 = new UserInfoImpl();
						 dao1.addUser(username);
										
//					ApplicationIdDAOImpl dao2 = new ApplicationIdDAOImpl();
//					dao2.updateapplication(username);
//				 
					
//					ConnectionManager.getConnection().prepareStatement
//					("insert into applications values ('"+username+"','"+accounttype+"''"+balance+"','"+status+"','"+
//					applicationid+"', )").executeUpdate();
						 
							
						 
					System.out.println("Your application is submitted for review");
					System.out.println("Your application ID is :  "+applicationid);
					System.out.println("Please Keep your application ID for further refenece");
				    
				} catch (Exception e) {
					     e.printStackTrace();
				      }
			 }else {
			                    	System.out.println("Password doesn't match.");
			                    	
			                    }
			}
	}


