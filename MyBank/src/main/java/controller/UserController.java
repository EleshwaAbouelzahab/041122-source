package controller;

import app.BankUser;
import dao.UserDAOImpl;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import models.UserModel;



public class UserController {

	UserDAOImpl dao;
	
	public UserController(Javalin app){

		dao = new UserDAOImpl();
		
		app.get("/users/{username}", getHandler);
		app.post("/users", postHandler);
		
	}
	
	
	public Handler getHandler = ctx -> {
		
		String username = ctx.pathParam("username");
		
		UserModel user = dao.get(username);
		
		ctx.json(user);
	};
	
	
	public Handler postHandler = ctx -> {
		
		UserModel user = ctx.bodyAsClass(UserModel.class);
		BankUser.username = user.username;
		BankUser.email = user.email;
		BankUser.password=user.password;
		dao.addUser();
		
		ctx.status(201);
	};
	

}
