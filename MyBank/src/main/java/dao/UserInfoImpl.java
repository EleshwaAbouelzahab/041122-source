package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.BankUser;

public class UserInfoImpl  implements UserInfoDAO{
	//this method adds a new user to the database
public BankUser addUser(String username) {
		
		Connection connection = ConnectionManager.getConnection();
		
				try {
			String query = "INSERT into userinfo (email,firstname, lastname, streetaddress, city, state, phonenumber, username) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)" ;
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, BankUser.email);
			statement.setString(2, BankUser.firstname);
			statement.setString(3, BankUser.lastname);
			statement.setString(4, BankUser.streetaddress);
			statement.setString(5, BankUser.city);
			statement.setString(6, BankUser.state);
			statement.setString(7, BankUser.phonenumber);
			statement.setString(8, BankUser.username);

			statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
				return null;
	}

public BankUser get(String username) {
	// TODO Auto-generated method stub
	return null;
}

public void addUser(BankUser user) {
	// TODO Auto-generated method stub
	
}

	

	

}
