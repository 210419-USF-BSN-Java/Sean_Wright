package com.revature;

public class Assign_1 {
	
	public static void main(String[] args) {
		
		Assign_1.PrintNumberInWord(-6);
	}
	public static  void PrintNumberInWord (int number){
		
	String answer = new String();
	
	answer = "Other";
		
	if(number == 0) {
		answer = "Zero";
	}
	if(number == 1) {
		answer = "One";
	}
	if(number == 2) {
		answer  = "Two";
	}
	if(number == 3) {
		answer = "Three";
	}
	if(number == 4) {
		answer = "Four";
	}
	if(number == 5) {
		answer = "Five";
	}
	if(number == 6) {
		answer = "Six";
	}
	if(number == 7) {
		answer = "Seven";
	}
	if(number == 8) {
		answer = "Eight";
	}
	if(number == 9) {
		answer = "Nine";
	}
	
	System.out.println(answer);
	
	}
}
