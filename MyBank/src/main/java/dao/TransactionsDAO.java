package dao;


import models.TransactionModel;

public interface TransactionsDAO {
	
	public TransactionModel newTransaction();
	public TransactionModel updateTransaction();
}
