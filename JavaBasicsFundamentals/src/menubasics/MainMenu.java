package menubasics;

import java.util.Scanner;



public class MainMenu {
	
	static String[] guests = new String[10];
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		insertTempNames();


do {
	displayGuests();
	
	displayMenu();
	
	int option = getOption();
	
	
	if (option == 1) {
	
		addGuest();
		
	}
	else if (option == 2) { //replace guests
		insertGuest();
	}
	
	else if (option == 3) { //rename guests
		renameGuest();
	}
	
	else if (option == 4) {  // add guests
		
		removeGuest();
		
	}
	else if (option == 5) { // delete guests
		System.out.println("Exiting...");
		break; // breaking out of the loop.
		
}
	
	} while (true);// taking the loop back to the menu.

	}


static void displayGuests() {
	System.out.println("_______________________________\n- Guest -\n");

	boolean isEmpty = true; // setting the list if empty
	for (int i = 0; i < guests.length; i++) { // total number of guests in the loop
		if (guests[i] != null) {
			System.out.println((i + 1) + ". " + guests[i]);
			isEmpty = false;
		}
	}
	if (isEmpty) {
		System.out.println("Guest list is empty."); //Prints “Guest list is empty” if empty
	}
}

static void displayMenu() {
	System.out.println("_______________________________\n- Menu -\n");
	System.out.println("1 - Add guest");
	System.out.println("2 - Insert Guest");
	System.out.println("3 - Rename Guest");
	System.out.println("4 - Remove Guest");
	System.out.println("5 - Exit");
}

static int getOption() {
	
	System.out.print("Option:  ");
	int option = scanner.nextInt();
	scanner.nextLine();//not allow spaces in names \n
	System.out.println();
	return option;

}
static void addGuest() {
	for (int i = 0; i < guests.length; i++) { //check number of guests  before  adding to the array.
		if (guests[i] == null){
			System.out.print("Name: ");
			guests[i] = scanner.nextLine();   // Store name. and wait for the promote line
			break;
		}
	}
	
}

static void insertGuest() {
	System.out.println("Number: ");
	int num = scanner.nextInt();
	scanner.nextLine();
	
	if (num >= 1 && num <= 10 && guests[num - 1] != null) { // allows n
	System.out.println("Name: ");
	String name =  scanner.nextLine();
	
	for (int i = guests.length - 1; i > num - 1; i--) {
		guests[i] = guests[i - 1]; // changes index position of names when inserted 
	}
	
	guests[num - 1] = name;
	
	}
	else {
		System.out.print("\n Error: There is no guest with that number. ");
	}
	
}

static void renameGuest() {
	System.out.println("Number: ");
	int num = scanner.nextInt();
	scanner.nextLine();
	if (num >= 1 && num <= 10 && guests[num - 1] != null) { // allows n
	System.out.println("Name: ");
	String name =  scanner.nextLine();
	
	guests[num - 1] = name;
	
	}
	else {
		System.out.print("\n Error: There is no guest with that number. ");
	}
	
	
}
static void removeGuest() {
	
	System.out.println("Number: ");
	int num = scanner.nextInt();
	
	if (num >= 1 && num <= 10 && guests[num - 1] != null) { // allows numbers to chose between 1 and 10.
		guests[num - 1] =  null; //remove one guest less
//	for (int i = 0; i < guests.length; i++) { //check number of guests  before  deleting from the array.
//		if (guests[i] != null && guests[i].equals(name)) { 
//			guests[i] = null; // if match is found it is removed
//		break;
//		}
//	}
	
//names removed and all subsequent elements are shifted up to fill the gap.
	
String[] temp = new String[guests.length];
int count= 0;
for (int i = 0; i < guests.length; i++) {
	
	if (guests[i] != null) {
		temp[count] = guests[i];
		count++;
		
		}
	}
	guests = temp;
	
}
	else {
		System.out.print("\n Error: There is no guest with that number. ");
	}
	
}

static void insertTempNames() {
	
	guests[0]= "John Doe";
	guests[1]= "Peter Joel";
	guests[2]= "Fabian Kip";
	guests[3]= "Frank Johnson";
	guests[3]= "New Jersey";
	
}

}


