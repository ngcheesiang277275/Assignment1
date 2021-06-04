package assignment1;

import java.util.Scanner;								//1.2 - Predefined class

public class CustomerRegistration {
	
	Scanner input = new Scanner(System.in);
	String cardNum;
	String exp;
	String cvv;
	String cardholder;
	
	public CustomerRegistration() {
		do {
		System.out.print("Card number \t\t: ");
		cardNum = input.next();
			if(cardNum.length()!=16)
				System.out.println("\n***You should have 16 digits for your credit/debit card.\nPlease Try again\n");
		}while(cardNum.length() != 16);
		
		System.out.print("EXP(valid thru)(MM/YY)\t: ");
		exp = input.next();
		
		System.out.print("CVC/CVV\t\t\t: ");
		cvv = input.next();
		
		System.out.print("Cardholder name\t\t: ");
		input.nextLine();
		cardholder = input.nextLine();
	}
	
	public void printCustomerInfo() {
		System.out.printf("%-20s: %s%n%-20s: %s%n%-20s: %s%n%-20s: %s%n", "Card number", cardNum, "EXP(valid thru)",
				exp, "CVC/CVV", cvv, "Cardholder name", cardholder);	
		
	}
}
