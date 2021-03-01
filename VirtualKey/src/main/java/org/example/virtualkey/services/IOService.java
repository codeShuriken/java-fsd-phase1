package org.example.virtualkey.services;

import java.util.Scanner;

public class IOService {
	private static final Scanner input = new Scanner(System.in);
	
	public static String getInputString(){
        return input.nextLine();
    }
    
    public static int getOption(){
    	String in = null;
        int returnOption = 0;
        try {
        	in  = getInputString();
            returnOption = Integer.parseInt(in);
        }
        catch (NumberFormatException ex) {
        	//System.out.println("Please enter a proper option!\n");
        }
        return returnOption;
    }
}
