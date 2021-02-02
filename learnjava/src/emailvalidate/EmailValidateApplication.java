package emailvalidate;

import java.util.Scanner;

public class EmailValidateApplication {
	
	private static final String emails[] = {};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your email id: ");
		String email = scanner.nextLine();
		
		EmailSearcher emailSearcher = new EmailSearcher();
		
		while (email != null && !email.equals("Exit")) {
			if (emailSearcher.validateEmail(email)) {
				if (emailSearcher.searchEmail(email)) {
					System.out.println("Email is present in the array!");
				}else {
					System.out.println("Email is NOT present in the array!");
				}
			}else {
				System.out.println("Please enter a valid email!");
			}
			System.out.println("Enter your email id:(Or type \"Exit\" to exit) ");
			email = scanner.nextLine();
		}
		
		System.out.println("Exited!!!!");
		scanner.close();	
	}
}
