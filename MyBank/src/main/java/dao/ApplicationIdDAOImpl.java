package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.Application;

import models.ApplicationIdModel;


public class ApplicationIdDAOImpl implements ApplicationIdDAO {

	
	public ApplicationIdModel newapplication(ApplicationIdModel applicationid) {
		
		Connection connection = ConnectionManager.getConnection();
		
				try {
			String query = "INSERT into applications (applicationid, status, balance, accounttype, username) "
					+ "values (?, ?, ?, ?, ?)" ;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, applicationid.applicationid);
			statement.setString(2, "pending");
			statement.setInt(3, applicationid.balance);
			statement.setString(4, "new account");
			statement.setString(5, applicationid.username);
			

			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
				return null;
	}
	

public ApplicationIdModel getapplication(String username){
		
		Connection connection = ConnectionManager.getConnection();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement
					("SELECT * FROM applications WHERE username = ?");
			

			statement.setString(1, username);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {

				ApplicationIdModel n = new ApplicationIdModel();
				n.applicationid= rs.getInt("applicationid"); 
				n.status= rs.getString("status"); 
				n.balance = rs.getInt("balance");
				n.accounttype = rs.getString("accounttype");
				n.username = rs.getString("username");
				
				return n;
				
				
			}
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		
			return null;

}



	public void updateapplication(ApplicationIdModel user) {
        
	Connection connection = ConnectionManager.getConnection();

        try {
        	PreparedStatement statement = connection.prepareStatement
        			("update applications set balance =? where applicationid=?");
			
        	statement.setInt(1,user.balance);
            statement.setInt(2, user.applicationid);
			
			
             
  
			statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
                 }
         
	return;
}



}




