package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.BankUser;
import models.UserModel;

public  class UserDAOImpl implements UserDAO {
	
	//this method checks if the user exists
	public  UserModel get(String username){
		
		Connection connection = ConnectionManager.getConnection();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement
					("SELECT * FROM users WHERE username = ?");
			

			statement.setString(1, username);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {

				UserModel user = new UserModel();
				user.username= rs.getString("username"); // also just the username variable
				user.password = rs.getString("password");
				user.email = rs.getString("email");
				
				return user;
				
				
			}
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		
			return null;
		
	}


public void addUser() {
		
		Connection connection = ConnectionManager.getConnection();
		
				try {
			String query = "INSERT into users (username, password, email) "
					+ "values (?, ?, ?)" ;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, BankUser.username);
			statement.setString(2, BankUser.password);
			statement.setString(3, BankUser.email);
			

			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
				return;
	}








public void create(UserModel user) {
	// TODO Auto-generated method stub
	
}



@Override
public BankUser get() {
	// TODO Auto-generated method stub
	return null;
}


	


}



