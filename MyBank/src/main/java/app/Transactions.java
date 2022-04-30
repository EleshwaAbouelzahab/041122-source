package app;

import dao.TransactionsDAO;
import models.TransactionModel;

public class Transactions implements TransactionsDAO {

	public static int balance;
	public static int transactionid;
	public static int type;
	public static int amount;
	public static int time;
	public static String date;
	public static String status;
	public static String username;
	
	
	@Override
	public TransactionModel newTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TransactionModel updateTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

}
