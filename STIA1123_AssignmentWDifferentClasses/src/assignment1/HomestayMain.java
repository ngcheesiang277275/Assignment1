package assignment1;

import java.util.Scanner;						//1.2 - Predefined class

public class HomestayMain {						//Main class
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		String companyName = "";
		String homestayName = "";
		double ppn = 0;
		boolean repeatMenu = true;
		
		HomestayRentalSystem rentalSystem = new HomestayRentalSystem("Bona Fide");

		while(repeatMenu) {
			boolean client = true;
			boolean admin = true;
			System.out.println("++++++WELCOME TO "+ companyName.toUpperCase() +" HOMESTAY RENTAL SYSTEM++++++");

			rentalSystem.printCompanyDescription();

			System.out.print("\nLogin with your role\n1. Client.\n2. Admin\nX. Quit\n>>>");
			String menuOption = input.next().toUpperCase();
			
			switch(menuOption) {
			case "1":
				while(client) {
					System.out.println("\nHi our beloved client.\nPlease select one homestay to continue.");
					System.out.print("1. Orchid Suite, Langkawi\t\tRM68.00\n2. Magic Studio, Georgetown\t\tRM98.00\n3. Diamond House, Ipoh\t\t\tRM112.50\nX. Back to Main Menu\n>>>");
					String homestayChoice = input.next().toUpperCase();
					
					switch(homestayChoice) {
						case"1":
							homestayName = "Orchid Suite, Langkawi";
							ppn = 68.0;
							break;
						case"2":
							homestayName = "Magic Studio, Georgetown";
							ppn = 98.0;
							break;
						case"3":
							homestayName = "Diamond House, Ipoh";
							ppn = 112.50;
							break;
						case"X":
							client = false;
							System.out.println();
							break;
						default:
							System.out.println("Invalid choice. Try again.");
					}
					
					if (client) {
						HomestayDescription hms = new HomestayDescription(homestayName, ppn);
						hms.printDescription();
						
						SalesSystem pos = new SalesSystem(homestayName, ppn);
						pos.payment();
						
						System.out.println("\n***Any enquiries:\nCall\t: " + rentalSystem.companyContactNum + "\nEmail\t: " + rentalSystem.companyEmail);
						System.out.print("\nRedirect back to homestay page.\nInput any key to continue\n>>>");
						input.next();
					}
				}
				break;
				
			case "2":
				System.out.println("\nHi admin!\nPlease log in into the system.");
				
				System.out.printf("%-20s: ", "User Name");
				String username = input.next();
				System.out.printf("%-20s: ", "Password");
				String password = input.next();

				if ((username.equals("spongebob") && (password.equals("277275")))) {
					System.out.println("\nADMIN \"" + username + "\" LOG IN SUCCESSFULLY!");

					while (admin) {
						System.out.print(
								"Choose one option to continue\n1. Employee Management\n2. Inventory Management\n3. Finance\n4. Advertisement and Marketing\nX. Back to Main Menu\n>>>");
						String adminChoice = input.next().toUpperCase();

						switch (adminChoice) {
						case "1":
							EmployeeManagement empMngmt = new EmployeeManagement();
							empMngmt.employeeManagementSystem();
							break;
						case "2":
							InventoryManagement invt = new InventoryManagement();
							invt.inventoryManagementSystem();
							break;
						case "3":
							Finance fin = new Finance(12830, 3000);
							fin.financialStatement();
							break;
						case "4":
							AdvertisementAndMarketing ads = new AdvertisementAndMarketing();
							ads.marketingReport();
							ads.advertisementOption();
							break;
						case "X":
							admin = false;
							System.out.println();
							break;
						default:
							System.out.println("Invalid choice. Try again.\n");
						}
					}
				}else {
					System.out.println("Incorrect user name and password. Try again.\n\n");
				}

				break;
			case "X":
				System.out.println("THANK YOU FOR USING "+ companyName.toUpperCase() + " HOMESTAY RENTAL SYSTEM");
				repeatMenu = false;
				break;
			default:
				System.out.println("Invalid input. Please try again.");

			}
		}
	}
}
