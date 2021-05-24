package com.revature;

public class Reverse_String {
	
	public static void main(String[] args) {
		
		Reverse_String.Rewind("Stuff");
	}
	public static void Rewind(String Normal_string) {
		
		 for(int counter = Normal_string.length() - 1; counter >= 0; counter--) {
			 //use the charAt function to obtain char at a string index
			 
			 System.out.print(Normal_string.charAt(counter));
			 
			 //Use regular print function to avoid adding an additional line between output. 
		 }
	}
}
