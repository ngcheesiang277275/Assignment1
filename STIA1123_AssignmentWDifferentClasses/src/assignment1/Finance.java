package assignment1;

import java.util.Scanner;							//1.2 - Predefined class

public class Finance {								//1.3 - User defined class
	Scanner input = new Scanner(System.in);
	double totalRevenue;
	double totalExpense;
	double totalNetProfit;
	double totalSponsorship;
	boolean repeat;
	
	public Finance(double a, double b) {			//1.4 - 2 arguments constructor
		this.totalRevenue = a;
		this.totalExpense = b;
		this.totalSponsorship = 5000;
		this.repeat = true;
	}
	
	public double calculateNetProfit() {
		return this.totalRevenue - this.totalExpense + this.totalSponsorship;
	}
	
	public void financialStatement() {
		while(repeat) {
			System.out.println("\n---------FINANCIAL STATEMENT----------");
			System.out.printf("%-20s: RM%.2f%n", "Total Revenue", this.totalRevenue);
			System.out.printf("%-20s: RM%.2f%n", "Total Expense", this.totalExpense);
			System.out.printf("%-20s: RM%.2f%n", "Total Sponsorship", this.totalSponsorship);
			System.out.printf("%-20s: RM%.2f%n%n", "Total Net Profit", calculateNetProfit());
			System.out.print("E. Edit\nX. Back\n>>>");
			String option = input.next().toUpperCase();
			
			switch(option) {
			case"E":
				edit();
				break;
			case"X":
				System.out.println("Back to admin menu.\n");
				repeat = false;
				break;
			default:
				System.out.println("Invalid input. Try again.");
			}
			
		}
	}	
	
	public void edit() {
		System.out.printf("%-20s: RM", "Total Revenue");
		this.totalRevenue = input.nextDouble();
		System.out.printf("%-20s: RM", "Total Expense");
		this.totalExpense = input.nextDouble();
		System.out.printf("%-20s: RM", "Total Sponsorship");
		this.totalSponsorship = input.nextDouble();
	}
}
