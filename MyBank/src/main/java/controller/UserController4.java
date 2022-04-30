package controller;

import app.BankUser;
import dao.UserInfoImpl;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class UserController4 {
	
		UserInfoImpl dao;
		
		public UserController4(Javalin app){

			dao = new UserInfoImpl();
			
			app.get("/usersinfo/{info}", getHandler);
			app.post("/usersinfo", postHandler);
			
		}
		
		
		public Handler getHandler = ctx -> {
			
			String username = ctx.pathParam("username");
			
			BankUser user = dao.get(username);
			
			ctx.json(user);
		};
		
		public Handler postHandler = ctx -> {
			
			BankUser user = ctx.bodyAsClass(BankUser.class);
			
			dao.addUser(user);
			
			ctx.status(201);
		};
		

	}


