package com.revature;

public class Reverse_String {
	
	public static void main(String[] args) {
		
		System.out.println(Reverse_String.Reverse("Example"));
	}
	public static String Reverse(String Normal_string) {
		
		String Reverse = new String();
		
		for (int counter = Normal_string.length() - 1; counter >= 0; counter--) {
			
			Reverse += Normal_string.charAt(counter);
		}
		return Reverse;
	}
}
