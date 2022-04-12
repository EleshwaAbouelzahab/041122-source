package com.revature.app;

public class Driver {
	
	//instead you put the array in two [] you add three dots.
	public static void main(String[] args) {
		
		MyObject o= new MyObject();
		MyObject p= new MyObject();
		
		o.number =10;
		o.printName();
		
		MyObject.name = "something else";
		
		p.number =11;
		p.printName();
		o.printName(); // These two statements have different individual valuse
		
		
		String[] strings =new String[3];
		strings[0] ="Tom";
		strings[1] ="Jerry";
		strings[2] ="Popeye";
		
		o.testArgs(strings);
		o.testVarArgs("Jack" ,"Jill" ,"John");
	}
}
