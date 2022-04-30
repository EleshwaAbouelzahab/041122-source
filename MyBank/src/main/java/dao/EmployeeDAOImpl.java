package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.BankEmployee;

public abstract class EmployeeDAOImpl implements EmployeeDAO{

	
		
		public  BankEmployee employee(String employee){
			
			Connection connection = ConnectionManager.getConnection();

			try {
				
				PreparedStatement statement = connection.prepareStatement
						("SELECT * FROM employee WHERE id = ?");
				

				statement.setString(1, employee);
				
				ResultSet obj = statement.executeQuery();
				
				if (obj.next()) {
					BankEmployee bankemployee = new BankEmployee();
					BankEmployee.employeeid= obj.getInt("id"); 
					BankEmployee.name = obj.getString("name");
					BankEmployee.email = obj.getString("email");
					BankEmployee.password = obj.getString("password");
					
					return bankemployee;
					
				} 
				
				}
			
				catch (Exception e) {
				e.printStackTrace();
				}
			
				return null;
		}



}
