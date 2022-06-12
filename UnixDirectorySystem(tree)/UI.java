//-----------------------------------------------------
// Title: GUI class
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 03
// Description: This class is for user interface just like demanded in the Q2.
//-----------------------------------------------------

import java.util.Scanner;

public class UI {

	public static void main(String[] args) {

		// --------------------------------------------------------
		// Summary: In this class and main method I created a user interface which does the demanded operations.
		// With this interface users can manipulate the data.
		// --------------------------------------------------------
		
		Scanner scan = new Scanner(System.in);

		int exit = 0;
		// I used a do while loop to create the skeleton of the interface
		do {

			System.out.println("Enter Operation Name");

			String opt = scan.next();

			UnixDirectory ud = new UnixDirectory();

			switch (opt) {

			case "mkdir": {

				System.out.println("How many file would you like to add?");

				int n = scan.nextInt();

				for (int i = 0; i < n; i++) {

					String parentname = scan.next();
					int psize = scan.nextInt();
					String childname = scan.next();
					int csize = scan.nextInt();

					ud.createDirectory(parentname, childname, psize, csize);
				}

				break;
			}
			case "rmdir": {

				String name = scan.next();
				
				ud.removeDirectory(name);

				break;
			}
			case "ls": {

				String name = scan.next();

				ud.listDirectory(name);
				
				break;
			}
			case "sizels": {

				String name = scan.next();

				ud.listDirectorySize(name);
				
				break;
			}
			case "quit": {
				exit = 7;
				break;
			}
			}

		} while (exit != 7);

	}

}
