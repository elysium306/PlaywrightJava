package com.primitive.miscelleneous;

public class VariablesInJava {
	
	int x = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VariablesInJava var1 = new VariablesInJava();
		VariablesInJava var2 = new VariablesInJava();
		
		System.out.println("---- Printing x from <main> method ----");
		System.out.println("Value of x: " + var1.x);
		System.out.println("Value of x: " + var2.x);
		
		System.out.println("---- Running <doSomething> and <doSomethingElse> methods for object var1 ----");
		var1.doSomething();
		var1.doSomethingElse();
		
		System.out.println("---- Running <doSomething> and <doSomethingElse> methods for object var2 ----");
		var2.doSomething();
		var2.doSomethingElse();
		
		System.out.println("---- Printing x from <main> method ----");
		System.out.println("Value of x: " + var1.x);
		System.out.println("Value of x: " + var2.x);
	}
	
	public void doSomething() {
		try {
			
			x = 5;
			System.out.println("Value of x: " + x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doSomethingElse() {
		try {
			x = 10;
			System.out.println("Value of x: " + x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
