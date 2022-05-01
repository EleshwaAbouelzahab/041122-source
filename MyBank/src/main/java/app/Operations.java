package app;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ApplicationIdDAOImpl;
import dao.ConnectionManager;
import dao.TransactionsDAOImpl;
import models.ApplicationIdModel;


public class Operations {
	static int balance;
	static int a;
	static int sac;
	static int account;
	static String str1="TO";
	static String str2="FROM";
	static String str3="pending";
	static int transactionid;
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
	static SimpleDateFormat sdf1=new SimpleDateFormat("HH:mm:ss");
    static Date date=new Date();
    static Scanner obj=new Scanner(System.in);
	public static int applicationid;
    
    
    public static void menu() {
        	
    		//login Menu
    		while(true) {
    			System.out.println("What would you like to do next?");
	        	System.out.println("1. Check Balance");
	        	System.out.println("2. Deposit");
	        	System.out.println("3. Withdrawl");
	        	System.out.println("4. Transfer Funds");
	        	System.out.println("5. Exit");

	        	int ch = obj.nextInt();
	        	
	        	
	        	Operations.search(BankUser.balance);
	        	
		 		  
	        	 Driver.lg.info("second menu!");
	        	switch(ch) {
	        				
			        	case 1: //to check balance
			        		Operations.checkBalance(balance);
			        		break;
			        	case 2://to deposit
			        		
			        		Operations.deposit(balance);
			        		break;
			        	case 3:// to withdraw
			        		Operations.withdrawl(balance);
			        		break;
			        	case 4://to transfer funds
			        		Operations.transfer();
			        		break;
			        	case 5:
			        		System.exit(1);
			        		break;
			        	default:
			        		Driver.lg.error("Please choose an option:");
			        		System.out.println("Please choose from the previous menu.");
			        	   }
    		}
   
			 
  				 }
    
   
    public static void request() {
  	  try {
  	  
  		  ResultSet ms=ConnectionManager.getConnection().prepareStatement
  			  ("select *from transactions where transactionid="+transactionid+"").executeQuery();
  	      
  		  while(ms.next()) {
  	         String username = ms.getString("username");
     	     balance=search(balance);
     	     int amount=ms.getInt("amount");
     	     System.out.println(username+" "+balance+" "+amount);
  	      
	     	     if(ms.getString("type").compareTo("TO")==0) {
	  	         balance=balance-amount;
	  	         System.out.println(balance);
	  			 update(balance);
	  	         }
		  	         else if(ms.getString("type").compareTo("FROM")==0) {
		  			 balance=balance+amount;
		  			 System.out.println(balance);
		  			 update(balance);
		  	         }
  	        }
  	  }catch (SQLException e) {
	        e.printStackTrace();}

  }
    

//    public static void moneytransaction() {
//    	System.out.println("TransactionID   AccountNo  Type   TransactionNo  TransactionAmount   Date "
//    			+ " Time Status");
//    	
//    	try {
//			ResultSet rs1 =ConnectionManager.getConnection().prepareStatement("select *from transactions "
//		        	+ "where username="+username+" and type='TO' or type='FROM'").executeQuery();
//	        
//	        while(rs1.next()) {
//		    System.out.println(rs1.getInt("transactionid")+"  | "+rs1.getString("username")+"  |  "+
//		    		rs1.getString("type")+"  |    "+rs1.getString("transaction")+"  | "+
//		    		rs1.getInt("amount")+"|"+rs1.getDate("date")+"|"+rs1.getTime("time")+"|"+
//		    		rs1.getString("status"));
//	        }
//    	  }   catch (SQLException e) {
//		        e.printStackTrace();
//		        }
//    	
//    	//ystem.out.println("<-------*-----------------*------------------*----------------*-----------------------*--------->");
//		    
//    	try {
//	        ResultSet rs=ConnectionManager.getConnection().prepareStatement("select *from transactions "
//	        		+ "where accno="+username+" and status='pending' and type='From'").executeQuery();
//	        
//	        while(rs.next()) {
//		        System.out.println(rs.getInt("transactionid")+"  | "+rs.getString("username")+"  |  "
//		        		+rs.getString("type")+"  |    "+rs.getString("transaction")+"  | "
//		        		+rs.getInt("amount")+"|"+rs.getDate("date")+"|"+rs.getTime("time")+"|"
//		        		+rs.getString("status"));	
//		        
//		        System.out.println("Enter 1 to approve the transaction.");
//		        System.out.println("Enter any number to cancel transaction.");
//		        
//			    a=obj.nextInt();
//			    
//			    if(a==1) {
//			     request();
//			     ConnectionManager.getConnection().prepareStatement("update transactions set status='accepted' "
//				     		+ "where transactionid="+rs.getInt("transactionid")+"").executeUpdate();
//			    }
//			    else {
//		    	
//			    	ConnectionManager.getConnection().prepareStatement("update transactions set "
//			    			+ "status='rejected' where transactionid="+rs.getInt("transactionid")+"").executeUpdate();
//			    }
//	        }
//	   }catch (SQLException e) {
//	        e.printStackTrace();}
//    }
//    
    //to search accounts
    public static int searchaccno(int applicationid) {
		try {
			ResultSet rs=ConnectionManager.getConnection().prepareStatement
					("select *from applications where applicationid="+applicationid+"").executeQuery();
			
			if(rs.next()==true) {
				a=1;
			}
			else{
				a=0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return a;
	}
    
    //to update the account
    public static void update(int balance) {
    	try {
    		
    		ApplicationIdDAOImpl dao = new ApplicationIdDAOImpl();
    		ApplicationIdModel update = dao.getapplication(BankUser.username);
		    
			update.balance = Operations.balance;
			
			dao.updateapplication(update);
    	
			
			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static int transfermation(int balance) {
    	try {
    		transactionid=(int)(Math.random()*(100000-1000+1)+1000);
    		
    		
			if(sac==1||sac==0) {
    			str3="sucsess";
    			if(sac==0) {
    					str1="withdraw";
    			}
    			else if(sac==1) {
    				str1="deposit";
    			}
    		
    			ConnectionManager.getConnection().prepareStatement
		    			("insert into transactions (transactionid,username,type,amount,date,time,status)"+ 
		    			" values("+transactionid+",'"+BankUser.username+"','"+str1+"',"+balance+",'"+sdf.format(date)+
		    			"','"+sdf1.format(date)+"','"+str3+"')").executeUpdate();	
    		
    			TransactionsDAOImpl dao = new TransactionsDAOImpl();
        		Transactions update = dao.updateTransaction(BankUser.username);
    		    Operations.search(balance);
    		
			}
  		else {
			
    			ConnectionManager.getConnection().prepareStatement
		    			("insert into transactions values("+transactionid+","+sac+",'"+str1+"','"+
		    					BankUser.username+"',"+balance+",'"+sdf.format(date)+"','"+sdf1.format(date)+"','"
    					+str3+"')").executeUpdate();
    			
    			ConnectionManager.getConnection().prepareStatement
		    			("insert into transactions values("+transactionid+","+BankUser.username+",'"+str2+"','"+
		    	    	Integer.toString(sac)+"',"+balance+",'"+sdf.format(date)+"','"+sdf1.format(date)+"','"
		    			+str3+"')").executeUpdate();
    			
    			TransactionsDAOImpl dao = new TransactionsDAOImpl();
        		Transactions update = dao.updateTransaction(BankUser.username);
    		    Operations.search(balance);
    			
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
			}
    	return transactionid;
    }
    
    //account serach
    public static int search(int balance) {
		try {
			
//			
//			ResultSet rs=ConnectionManager.getConnection().prepareStatement
//					("select * from applications where username=BankUser.username").executeQuery();
//		    rs.next();
//	    
		    ApplicationIdDAOImpl dao = new ApplicationIdDAOImpl();
		    ApplicationIdModel get = dao.getapplication(BankUser.username);
		  //  ApplicationIdModel update = dao.updateapplication();
		    
		    
			Operations.balance =get.balance;
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return balance;
    }
	
	//withdrawl method
	public static void withdrawl(int balance) {
		System.out.println("Amount to withdraw");
		int withamount = obj.nextInt();
		obj.nextLine();
		balance=Operations.search(balance);
		
		
		if(withamount<=balance) {
		Operations.balance=balance-withamount;
		    Operations.update(balance);
		    sac=0;
		    Operations.transfermation(withamount);
			System.out.println("Your withdrawl of $ " +withamount+ " was successful" + "/-");
			System.out.println("Your availabe balance is $ "+Operations.balance+"/-");
		}else {
			System.out.println("You don't have sufficient funds.");
			}
		
	      Driver.lg.info("Withdrawal happened here.");

	   }
	
	//checkbalance method
	public static void checkBalance(int balance) {
		balance=Operations.search(balance);
		System.out.println("Your availabe balance is:  $ "+balance);
	      Driver.lg.info("Checkbalance happened here.");

	}
	
	//Deposit method
	public static void deposit(int balance) {
			System.out.println("Enter the amount you want to deposit:");
			int depamount = obj.nextInt();
			balance =search(balance);
			Operations.balance = balance+depamount;
			Operations.update(balance);
			sac=1;
			Operations.transfermation(depamount);
			System.out.println("<------Your deposit was successful----->");
			System.out.println("Your availabe balance is:  $ "+Operations.balance);
		      Driver.lg.info("Deposit happened here.");

		}
	
	
	
	
	//To transfer funds
	public static void transfer() {
			
			sac=account;
			System.out.println("Enter the amount to transfer:");
			int transamount=obj.nextInt();
			balance=Operations.search(balance);
			if(balance>=transamount) {
			System.out.println("Enter the account number to transfer to:");
			Operations.applicationid=obj.nextInt();
			int a= Operations.searchaccno(applicationid);
			
			if(a==1) {
				int transactionid=Operations.transfermation(transamount);
				System.out.println("      Your transaction ID is : "+transactionid);
			} else {
				System.out.println("This account number is not vaild.");
				}
		    }else {
				System.out.println("You don't have sufficient funds.");
		    }
		}
		
		
}
