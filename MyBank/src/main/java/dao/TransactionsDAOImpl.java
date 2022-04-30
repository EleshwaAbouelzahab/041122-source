package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.Application;
import app.Transactions;
import models.TransactionModel;

public class TransactionsDAOImpl implements TransactionsDAO {

	public TransactionModel newTransaction() {
		Connection connection = ConnectionManager.getConnection();
		
		try {
	String query = "INSERT into transactions (transactionid, username, type, amount, date, time, status) "
			+ "values (?, ?, ?, ?, ?, ?, ?)" ;
	
	PreparedStatement statement = connection.prepareStatement(query);
	
	statement.setInt(1, Transactions.transactionid);
	statement.setString(2, Transactions.username);
	statement.setInt(3, Transactions.type);
	statement.setInt(4, Transactions.amount);
	statement.setString(5, Transactions.date);
	statement.setInt(6, Transactions.time);
	statement.setString(7, Transactions.status);

	

	statement.execute();
} catch(SQLException e) {
	e.printStackTrace();
}
		return null;
}


//	public int updateTransaction(int transactionid) {
//		
//		Connection connection = ConnectionManager.getConnection();
//		
//		try {
//			
//			PreparedStatement statement = connection.prepareStatement
//					("SELECT * FROM transactions WHERE username = ?");
//			
//
//			statement.setInt(1, transactionid);
//			
//			ResultSet rs = statement.executeQuery();
//			
//			if (rs.next()) {
//
//				Transactions n = new Transactions();
//				n.transactionid= rs.getInt("applicationid"); 
//				n.status= rs.getString("status"); 
//				n.amount = rs.getInt("balance");
//				n.date = rs.getString("date");
//				n.type = rs.getInt("type");
//				n.username = rs.getString("username");				
//				n.time = rs.getInt("time");
//
//
//				
//				return transactionid;
//				
//				
//			}
//		
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		
//			return transactionid;
//	}
//

	public Transactions updateTransaction(String username) {
		Connection connection = ConnectionManager.getConnection();

        try {
        	PreparedStatement statement = connection.prepareStatement
        			("update transactions (transactionid, username, type, amount, date, time, status) "
        					+ "values (?, ?, ?, ?, ?, ?, ?)");
			
        	statement.setInt(1, Transactions.transactionid);
        	statement.setString(2, Transactions.username);
        	statement.setInt(3, Transactions.type);
        	statement.setInt(4, Transactions.amount);
        	statement.setString(5, Transactions.date);
        	statement.setInt(6, Transactions.time);
        	statement.setString(7, Transactions.status);
             
  
        } catch (SQLException e) {
            e.printStackTrace();
                 }
         
	return null;
}

	


	



	

	@Override
	public TransactionModel updateTransaction() {
		// TODO Auto-generated method stub
		return null;
	}


	public void updateTransaction(Transactions user) {
		// TODO Auto-generated method stub
		
	}


	public TransactionModel newTransaction(String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
