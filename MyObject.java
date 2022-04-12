package com.revature.app;

public class MyObject {
	
	//static fields belong to the class and not any instance. 
	//so any change to a static field is reflected by all instances of the class
	//This is the CLASS scope
	static String name ="My Object";
	
	//Any non-static fields will carry data only for each individual instance.
	//this is known a memeber field and is in the INSTANCE scope, as each instance.
	public int number= 0;
	
	public void printName() {
		System.out.println(name + ": " + number);
	}
	
	public void growNumber() {
	
		// ANy variable declared at the top level of a method
		//are in a METHOD scope- 
		//they belong to each unique invocation of the method
		int multiplier =2;
		
		if(multiplier > 1) {
			
			//This variable is in BLOCK scope and cannot be used outside of this if block
			int y = multiplier *2;
			
			number +=y;
		}

		
	}
	public void testVarArgs(String...args) {
		
		for(String s : args) {
			System.out.println(s);
		}
	}
	
public void testArgs(String[] args) {
		
		for(String s : args) {
			System.out.println(s);
		}
	}
	
}
