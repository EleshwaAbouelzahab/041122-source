package app;

import java.util.*;

import dao.ConnectionManager;

import java.sql.*;

public class BankEmployee {

	static Scanner obj = new Scanner(System.in);

	public static int employeeid;
	public static String name;
	public static String email;
	public static String password;
	static String pending = "pending";
	static int ch;

	public static void employee() {

		
		 try { 
			 
			 System.out.println("ID number: ");
			 employeeid = obj.nextInt();
			 System.out.println("Name: ");
			 name = obj.next();
			 System.out.println("Email: ");
			 email = obj.next();
			 System.out.println("Password: ");
			 password=obj.next();
		  
			 ResultSet rs1=ConnectionManager.getConnection().
		  
			 prepareStatement("select *from employee").executeQuery(); rs1.next();
		  
		  if(employeeid==rs1.getInt("employeeid")){
		  
			  System.out.println("Login Successfuly");

		while (true) {

			System.out.println("1. Application ");
			System.out.println("2. Customers Details ");
			System.out.println("3. Cusomter Transactions");
			System.out.println("4.Exit ");
			System.out.println(" Please, Enter your choice: ");
			ch = obj.nextInt();

			switch (ch) {
			case 1:
				try {
					ResultSet sr = ConnectionManager.getConnection().prepareStatement("select *from applications")
							.executeQuery();
					
					while (sr.next()) {
						System.out.println(sr.getInt("applicationid")+ "|"+ sr.getString("status") + "|"+ sr.getInt("balance") + "|" + sr.getString("accounttype") + "|" + sr.getString("username"));
					}

					System.out.println(
							"<----------*--------------*--------->");

					ResultSet rs = ConnectionManager.getConnection()
							.prepareStatement("select *from applications where status='" + pending + "'")
							.executeQuery();

					while (rs.next()) {
						System.out.println(rs.getInt("applicationid") + "      |   " + rs.getString("status") + "|"
								+ rs.getString("balance") + "|" + rs.getInt("accounttype") + "|" + rs.getString("username"));

						System.out.println("Enter 1 to accept, other to reject.");
						int n = obj.nextInt();

						if (n == 1) {
							BankUser.accreation();
							ConnectionManager.getConnection()
									.prepareStatement("update applications set status="
											+ "'accepted' where applicationid=" + rs.getInt("applicationid") + "")
									.executeUpdate();
						} else {
							ConnectionManager.getConnection().prepareStatement("update applications set "
									+ "status='rejected' where applicationid=" + rs.getInt("applicationid") + "")
									.executeUpdate();
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;

			// customer details
			case 2:
				try {
					ResultSet rs = ConnectionManager.getConnection().prepareStatement("select *from userinfo")
							.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString("email")+ "|"+ rs.getString("firstname") + "|"+ rs.getString("lastname") + "|" + rs.getString("streetaddress") + "|" + rs.getString("city")
						 +"|"+ rs.getString("state")+ "|" + rs.getString("phonenumber"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			// customer transactions (needs edit)
			case 3:
				try {
					
							
					ResultSet rs = ConnectionManager.getConnection().prepareStatement("select *from transactions")
							.executeQuery();
					
					
			
					while (rs.next()) {
						
						
						
						System.out.println(rs.getInt("transactionid") + "  | " + rs.getString("username") + "  |  "
								+ rs.getString("type") + "  |    " + rs.getInt("amount") + "  | "
								+" | " + rs.getString("date") + "|" + rs.getString("time") + "|"
								+ rs.getString("status") + "");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;

			// exit
			case 4:
				System.exit(0);
			default:
				System.out.println("Please, Enter a vaild entry");
			}
		}
	}else

	{
		System.out.println("Your details are not correct");
	}}catch(SQLException e){
			            e.printStackTrace();
		              }
}

	@Override
	public String toString() {
		return "BankEmployee []";
	}}
