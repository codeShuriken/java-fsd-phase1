package emailvalidate;

import java.util.Scanner;

public class EmailValidateApplication {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your email id: ");
		String email = scanner.nextLine();
		
		EmailSearcher emailSearcher = new EmailSearcher();
		
		while (email != null && !email.equals("Exit")) {
			if (emailSearcher.validEmail(email)) {
				if (emailSearcher.searchEmail(email)) {
					System.out.println("Email Match FOUND!");
				}else {
					System.out.println("Email Match NOT FOUND!");
				}
			}else {
				System.out.println("Please enter a VALID email!");
			}
			System.out.println("Enter your email id:(Or type \"Exit\" to exit) ");
			email = scanner.nextLine();
		}
		
		System.out.println("Exited!!!!");
		scanner.close();	
	}
}
