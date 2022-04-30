package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.BankAdmin;

public class AdminDAOImpl  implements AdminDAO{
	
	public  BankAdmin admin(String admin){
		
			
			Connection connection = ConnectionManager.getConnection();

			try {
				
				PreparedStatement statement = connection.prepareStatement
						("SELECT * FROM admin WHERE id = ?");
				

				statement.setString(1, admin);
				
				ResultSet obj = statement.executeQuery();
				
				if (obj.next()) {
					BankAdmin bankadmin = new BankAdmin();
					bankadmin.id= obj.getInt("id"); 
					bankadmin.name = obj.getString("name");
					bankadmin.email = obj.getString("email");
					bankadmin.password = obj.getString("password");
					
					return bankadmin;
					
				} 
				
				}
			
				catch (Exception e) {
				e.printStackTrace();
				}
			
				return null;
		}

	@Override
	public BankAdmin admin() {
		// TODO Auto-generated method stub
		return null;
	}



}

