package assignment1;

public class HomestayDescription {							//1.3 - User defined class

	String name;
	double pricePerNight;
	String facilities;
	int maxGuest;
	int numOfBed;

	public HomestayDescription(String n, double ppn) {		//1.4 - 2 argument constructor
		this.name = n;
		this.pricePerNight = ppn;
		this.facilities = "TV, Wifi, stove and ari-conditioner";
		this.maxGuest = 4;
		this.numOfBed = 4;
	}

	public void printDescription() {
		System.out.println("\n\n--------HOMESTAY DESCRIPTION--------");
		System.out.printf("%-20s: %s%n", "Homestay name", this.name);
		System.out.printf("%-20s: RM%.2f%n", "Price per Night", this.pricePerNight);
		System.out.printf("%-20s: %s%n", "Facilities", this.facilities);
		System.out.printf("%-20s: %d%n", "Max number of guest", this.maxGuest);
		System.out.printf("%-20s: %d%n%n", "Number of beds", this.numOfBed);
	}

}
