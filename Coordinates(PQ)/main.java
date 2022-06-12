//-----------------------------------------------------
// Title: Main class (task1)
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 04
// Description: This class has the interface for the user and all the needed algorithms to give the correct output.
//-----------------------------------------------------
import java.util.Scanner;
import java.util.*;

public class main {
	// this method finds smallest distance and returns its index number in its array list.
	public static int findIndex(ArrayList<Double> arr) {
		
        double min = arr.get(0);
        
        int index = 0;
        
        int n = arr.size();
		
        for (int i = 1; i < n; i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
                index = i;
            }
        }
        
        return index;
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int points;

		System.out.println("How many point are there?");

		points = sc.nextInt();

		ArrayList<coordinates> crd = new ArrayList<>();

		System.out.println();
		
		// in this for loop we take points from the user and we check if the given coordinates are already exist or not.
		for (int i = 0; i < points; i++) {

			int xp = sc.nextInt();
			int yp = sc.nextInt();

			System.out.println();

			boolean already_exist = false;

			for (int j = 0; j < crd.size(); j++) {

				if (crd.get(j).x == xp && crd.get(j).y == yp) {
					already_exist = true;
				}

			}

			if (already_exist) {
				continue;
			} else {
				coordinates c = new coordinates(xp, yp);
				crd.add(c);
			}

		}
		//we create an array list for distances
		ArrayList<Double> distance = new ArrayList<>();
		
		//we fill it up
		for(int i = 0; i < points; i++) {
			
			distance.add(crd.get(i).distance);
			
		}
		
		int howx;

		System.out.println("How many closest ?");

		howx = sc.nextInt();

		//in this loop we find the smallest as much as asked and print them
		for(int i = 0; i <howx; i++) {
			
			int index;
			
			index = findIndex(distance);
			if(i == 0)System.out.print("[");
			if(howx - i == 1) {
				System.out.print("[" + crd.get(index).x + "," + crd.get(index).y + "]]");
			}else {
				System.out.print("[" + crd.get(index).x + "," + crd.get(index).y + "],");
			}
			
			crd.remove(index);

		}
		
		
		
	}

}
