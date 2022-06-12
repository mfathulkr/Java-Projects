//-----------------------------------------------------
// Title: GUI class
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 03
// Description: This class is for user interface just like demanded in the Q1.
//-----------------------------------------------------

import java.util.Scanner;

public class GUI {

	public static void main(String[] args) {
		// --------------------------------------------------------
		// Summary: Basically, I created a most simple console interface in order to
		// manipulate the data in the player database which we created.
		// While doing this, I used switch-case in a do while loop and just to prevent
		// to confusion, I added user referral informations before get the input.
		// --------------------------------------------------------
		Scanner scan = new Scanner(System.in);

		int exit = 0;

		do {

			System.out.println("Enter Operation Number");

			int opt = scan.nextInt();

			boolean b = (opt < 1 && opt > 7);

			while (b == true) {
				System.out.println("Wrong Number \nEnter Operation Number");
				opt = scan.nextInt();
			}

			PlayerDatabase db = new PlayerDatabase();

			switch (opt) {

			case 1: {

				System.out.println("How many player would you like to add?");

				int n = scan.nextInt();

				for (int i = 0; i < n; i++) {
					
					String name = scan.next();
					
					String surname = scan.next();
					
					int fee = scan.nextInt();

					db.addPlayer(name, surname, fee);
				}

				break;
			}
			case 2: {

				System.out.println("How many player would you like to remove?");

				int nrem = scan.nextInt();

				for (int i = 0; i < nrem; i++) {
					String name = scan.next();
					String surname = scan.next();
					System.out.println();

					db.removePlayer(name, surname);
				}

				break;
			}
			case 3: {

				System.out.println("Please enter the name you want to search.");

				String name = scan.next();
				String surname = scan.next();
				System.out.println();

				db.searchByName(name, surname);

				break;
			}
			case 4: {

				System.out.println("Please enter the range.");

				int min = scan.nextInt();
				int max = scan.nextInt();

				db.searchByRange(min, max);

				break;
			}
			case 5: {

				db.printAllPlayers();

				break;
			}
			case 6: {

				System.out.println("Please enter the k");

				int k = scan.nextInt();

				db.findKSmallest(k);

				break;
			}
			case 7: {
				exit = 7;
				break;
			}
			}

		} while (exit != 7);

	}

}
