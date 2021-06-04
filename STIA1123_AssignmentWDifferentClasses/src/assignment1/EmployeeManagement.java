package assignment1;

import java.util.Scanner;								//1.2 - Predefined class

public class EmployeeManagement {						//1.3 - User defined class
	Scanner input = new Scanner(System.in);	
	boolean repeat;
	String[] name = new String[15];
	String[] position = new String[15];
	double[] salary = new double[15];
	String[] tel = new String[15];
	int numOfname;

	public EmployeeManagement() {						//1.4 - 0 argument constructor
		this.repeat = true;
		this.numOfname = 0;
		name[numOfname] = "Leo";
		position[numOfname] = "Manager";
		salary[numOfname] = 6000;
		tel[numOfname++] = "0121134224";
		
		name[numOfname] = "Lisa";
		position[numOfname] = "Assistant";
		salary[numOfname] = 4500;
		tel[numOfname++] = "0165992920";
		
		name[numOfname] = "Sehun";
		position[numOfname] = "Staff";
		salary[numOfname] = 3000;	
		tel[numOfname++] = "0143330099";
		
		name[numOfname] = "Teahyung";
		position[numOfname] = "Staff";
		salary[numOfname] = 3000;	
		tel[numOfname++] = "0117771231";

	}

	public void employeeManagementSystem() {
		while (repeat) {
			System.out.printf("|%-3s|%25s|%10s|%8s|%15s|%n", "No.", "Name", "Position", "Salary", "Contact no");
			int listNum = 1;
			for (int i = 0; i < 10; i++) {
				if (name[i] != null)
					System.out.printf("|%-3s|%25s|%10s|%8.2f|%15s|%n", (listNum++), name[i], position[i], salary[i],tel[i]);
			}

			System.out.print("\nPlease select operation:\n1. Add data\n2. Delete data\n3. Edit data.\n4. Exit\n>>>");
			String option = input.next();
			switch (option) {
			case "1":
				addData();
				break;
			case "2":
				deleteData();
				break;
			case "3":
				editData();
				break;
			case "4":
				repeat = false;
				break;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}
	}

	public void addData() {
		if (numOfname < name.length) {
			System.out.print("Enter new data.\nName\t\t: ");
			input.nextLine();
			String newName = input.nextLine();
			name[numOfname] = newName;
			
			System.out.print("Position\t: ");
			String newPos = input.nextLine();
			position[numOfname] = newPos;		
			
			System.out.print("Salary\t\t: ");
			double newSal = input.nextDouble();
			salary[numOfname] = newSal;
			
			System.out.print("Contact no\t: ");
			String newTel = input.next();
			tel[numOfname++] = newTel;		

		} else
			System.out.println("The list is full.");

	}

	public void deleteData() {
		if (numOfname == 0)
			System.out.println("The list is empty");
		else {
			System.out.print("Enter number of row to delete that data: ");
			int numOfRow = input.nextInt();
			for(int i = numOfRow; i<name.length;i++) {
			name[i - 1] = name[i];
			position[i - 1] = position[i];
			salary[i - 1] = salary[i];
			tel[i - 1] = tel[i];
			}
			numOfname--;
		}
	}

	public void editData() {
		if (numOfname == 0)
			System.out.println("The list is empty");
		else {
			System.out.print("Enter number of row to edit data: ");
			int numOfRow = input.nextInt();
			System.out.print("New name\t:");
			input.nextLine();
			String newName = input.nextLine();
			
			System.out.print("New position\t:");
			String newPos = input.nextLine();
			
			System.out.print("New salary\t:");
			double newSal = input.nextDouble();
			
			System.out.print("New contact no\t:");
			String newTel = input.next();
			
			name[numOfRow - 1] = newName;
			position[numOfRow - 1] = newPos;
			salary[numOfRow - 1] = newSal;	
			tel[numOfRow - 1] = newTel;	
		}
	}
}
