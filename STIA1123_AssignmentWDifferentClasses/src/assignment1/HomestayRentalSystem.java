package assignment1;

import java.util.Scanner;								//1.2 - Predefined class

public class HomestayRentalSystem {						//1.3 - User defined class
	
	Scanner input = new Scanner(System.in);
	String companyName;
	String companyContactNum;
	String companyAddress;
	String companyEmail;
	
	public HomestayRentalSystem(String compName) {				//1.4 - 1 argument constructor
		this.companyName = compName;
		this.companyContactNum = "05-847-0809 or 016-831-7755";
		this.companyAddress = "333, Raintree Street, 34000 Taiping, Perak";
		this.companyEmail = compName.replaceAll("\\s","").toLowerCase() + "rentalsys@gmail.com";
	}
	
	public void printCompanyDescription() {
		System.out.println("\n-------------ABOUT US-------------");
		System.out.printf("%-20s: %s%n", "Company name", this.companyName);
		System.out.printf("%-20s: %s%n", "Contact number", this.companyContactNum);
		System.out.printf("%-20s: %s%n", "Office address", this.companyAddress);
		System.out.printf("%-20s: %s%n", "Email", this.companyEmail);
	}
}
