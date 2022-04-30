package controller;


import app.Application;
import dao.ApplicationIdDAOImpl;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import models.ApplicationIdModel;

public class ApplicationController {

	ApplicationIdDAOImpl dao;
	
	public ApplicationController(Javalin app){

		dao = new ApplicationIdDAOImpl();
		
		app.get("/apps{ username }", getHandler);
		app.post("/apps", postHandler);
		app.put("/apps", putHandler);

		
	}
	
	public Handler getHandler= ctx -> {
		
		//get the path's username
		String username =ctx.pathParam("username");
		
		//get the user based on the username
		ApplicationIdModel user = dao.getapplication(username);
		
		
		ctx.json(user);
	};
	
		public Handler postHandler = ctx -> {
		
	
		ApplicationIdModel user = ctx.bodyAsClass(ApplicationIdModel.class);
		
		dao.updateapplication(user);
		
		
		ctx.status(201);
		
	};
	
	public Handler putHandler = ctx -> {
		
		ApplicationIdModel user = ctx.bodyAsClass(ApplicationIdModel.class);
		
		dao.updateapplication(user);
		
		ctx.status(201);
	};
	

}
