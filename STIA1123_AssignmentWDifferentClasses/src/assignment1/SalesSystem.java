package assignment1;

import java.util.Scanner;								//1.2 - Predefined class

public class SalesSystem {								//1.3 - User defined class
	Scanner input = new Scanner(System.in);
	String name;
	double pricePerNight;
	double originalPrice;
	double totalPrice;
	String checkInDate;
	int nightToStay;
	String cardNum;
	String exp;
	String cvv;
	String cardholder;
	
	public SalesSystem(String n, double ppn) {			//1.4 - 2 argument constructor
		this.name = n;
		this.pricePerNight = ppn;
	}
	
	public float discountRate() {
		return 0.9f;
	}
	
	public double calculateTotalPrice() {
		System.out.println("------10% DISCOUNT FOR 3 NIGHTS AND ABOVE------");
		System.out.print("Date (DD/MM/YY) to stay in\t: ");
		this.checkInDate = input.next();
		System.out.print("Nights to stay\t\t\t: ");
		this.nightToStay = input.nextInt();
		this.originalPrice = this.nightToStay * this.pricePerNight;
		
		if(nightToStay < 3)
			return this.originalPrice;
		else
			return this.originalPrice * discountRate();
	}
	
	public void payment() {
		System.out.println("\n\n--------BOOKING--------");
		boolean askAgain = true;
		this.totalPrice = calculateTotalPrice();
		
		System.out.println("\n\n--------PAYMENT--------");
		System.out.printf("%-20s: RM%.2f%n", "Price per night", this.pricePerNight);
		System.out.printf("%-20s: RM%.2f%n", "Original Price", this.originalPrice);
		System.out.printf("%-20s: -RM%.2f%n", "Discount", (this.originalPrice - this.totalPrice));
		System.out.printf("%-20s: RM%.2f%n%n", "Total price", this.totalPrice);

		System.out.println(
				"Payment can be done via credit/debit cards.\nPlease enter your card information.\n");
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

		System.out.printf("%n%s%n%-20s: %s%n%-20s: %s%n%-20s: %d%n%-20s: %.2f%n%-20s: %.2f%n",
				"---------REVIEW---------", "Homestay", this.name, "Check-in date", this.checkInDate,
				"Night(s) to stay", this.nightToStay, "Original price", this.originalPrice, "Total price",
				this.totalPrice);

		System.out.printf("%-20s: %s%n%-20s: %s%n%-20s: %s%n%-20s: %s%n", "Card number", cardNum, "EXP(valid thru)",
				exp, "CVC/CVV", cvv, "Cardholder name", cardholder);

		while (askAgain) {
			System.out.print("Y - Confirm the booking\nX - Cancel the booking\n>>>");
			String confirm = input.next().toUpperCase();
			switch (confirm) {
			case "Y":
				System.out.println("\nALL DONE! \nThe booking will be proccessed.\nTransaction will be confirmed within 3 days.");
				askAgain = false;
				break;
			case "X":
				System.out.println("\nBooking is cancelled.");
				askAgain = false;
				break;
			default:
				System.out.println("\nInvalid choice. Please try again.");
			}
		}
	}// end of payment()
}
