package controller;


import app.Transactions;
import dao.TransactionsDAOImpl;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import models.TransactionModel;

public class UserController3 {

	TransactionsDAOImpl dao;
	
	public UserController3(Javalin app){

		dao = new TransactionsDAOImpl();
		
		app.get("/trans/{username}", putHandler);
		app.post("/trans", postHandler);
		app.put("/trans", putHandler);

		
	}
	
public Handler getHandler= ctx -> {
		
		//get the path's username
		String username =ctx.pathParam("username");
		
		//get the user based on the username
		TransactionModel user = dao.newTransaction(username);
		
		
		ctx.json(user);
	};
	
		public Handler postHandler = ctx -> {
		
	
			Transactions user = ctx.bodyAsClass(Transactions.class);
		
		dao.updateTransaction(user);
		
		
		ctx.status(201);
		
	};
	
	public Handler putHandler = ctx -> {
		
		Transactions user = ctx.bodyAsClass(Transactions.class);
		
		dao.updateTransaction(user);
		
		ctx.status(201);
	};
	

}
