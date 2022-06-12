//-----------------------------------------------------
// Title: SortingAlgorithmTester class
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 02 -Task 2
// Description: This class is about testing and measuring the execution times of sorting algorithms which are given in task2.
//-----------------------------------------------------
import java.util.Random;
import sorts.*;
import util.*;

public class SortingAlgorithmTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ascArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 54};
		int[] descArray = { 89, 65, 31, 9, 8, 7, 6, 4, 2, 1 };
		int[] randArray = new int[10];

		int minValueOfRandom = 0;
		int maxValueOfRandom = 100;

		long sort1AAv = 0, sort1DAv = 0, sort1RAv = 0;
		long sort2AAv = 0, sort2DAv = 0, sort2RAv = 0;
		long sort3AAv = 0, sort3DAv = 0, sort3RAv = 0;
		long sort4AAv = 0, sort4DAv = 0, sort4RAv = 0;
		long sort5AAv = 0, sort5DAv = 0, sort5RAv = 0;
		
		int[] tempAsc, tempDesc;

		tempAsc = ascArray;
		tempDesc = descArray;

		// to measure 50 times
		
		for (int j = 50; j > 0; j--) {

			for (int i = 0; i < randArray.length; i++) {
				Random r = new Random();

				int randomNum = r.nextInt((maxValueOfRandom - minValueOfRandom) + 1) + minValueOfRandom;

				randArray[i] = randomNum;
			}

			

			long start1A = System.nanoTime();
			SortingAlgorithms.sort1(ascArray, 1543191750L);
			long stop1A = System.nanoTime();
			long exe1A = stop1A - start1A;
			sort1AAv += exe1A;

			long start1D = System.nanoTime();
			SortingAlgorithms.sort1(descArray, 1543191750L);
			long stop1D = System.nanoTime();
			long exe1D = stop1D - start1D;
			sort1DAv += exe1D;

			long start1R = System.nanoTime();
			SortingAlgorithms.sort1(randArray, 1543191750L);
			long stop1R = System.nanoTime();
			long exe1R = stop1R - start1R;
			sort1RAv += exe1R;
			
			ascArray = tempAsc;
			descArray = tempDesc;


			long start2A = System.nanoTime();
			SortingAlgorithms.sort2(ascArray, 1543191750L);
			long stop2A = System.nanoTime();
			long exe2A = stop2A - start2A;
			sort2AAv += exe2A;

			long start2D = System.nanoTime();
			SortingAlgorithms.sort2(descArray, 1543191750L);
			long stop2D = System.nanoTime();
			long exe2D = stop2D - start2D;
			sort2DAv += exe2D;

			long start2R = System.nanoTime();
			SortingAlgorithms.sort2(randArray, 1543191750L);
			long stop2R = System.nanoTime();
			long exe2R = stop2R - start2R;
			sort2RAv += exe2R;

			ascArray = tempAsc;
			descArray = tempDesc;


			long start3A = System.nanoTime();
			SortingAlgorithms.sort3(ascArray, 1543191750L);
			long stop3A = System.nanoTime();
			long exe3A = stop3A - start3A;
			sort3AAv += exe3A;

			long start3D = System.nanoTime();
			SortingAlgorithms.sort3(descArray, 1543191750L);
			long stop3D = System.nanoTime();
			long exe3D = stop3D - start3D;
			sort3DAv += exe3D;

			long start3R = System.nanoTime();
			SortingAlgorithms.sort3(randArray, 1543191750L);
			long stop3R = System.nanoTime();
			long exe3R = stop3R - start3R;
			sort3RAv += exe3R;

			ascArray = tempAsc;
			descArray = tempDesc;


			long start4A = System.nanoTime();
			SortingAlgorithms.sort4(ascArray, 1543191750L);
			long stop4A = System.nanoTime();
			long exe4A = stop4A - start4A;
			sort4AAv += exe4A;

			long start4D = System.nanoTime();
			SortingAlgorithms.sort4(descArray, 1543191750L);
			long stop4D = System.nanoTime();
			long exe4D = stop4D - start4D;
			sort4DAv += exe4D;

			long start4R = System.nanoTime();
			SortingAlgorithms.sort4(randArray, 1543191750L);
			long stop4R = System.nanoTime();
			long exe4R = stop4R - start4R;
			sort4RAv += exe4R;

			ascArray = tempAsc;
			descArray = tempDesc;

			long start5A = System.nanoTime();
			SortingAlgorithms.sort5(ascArray, 1543191750L);
			long stop5A = System.nanoTime();
			long exe5A = stop5A - start5A;
			sort5AAv += exe5A;

			long start5D = System.nanoTime();
			SortingAlgorithms.sort5(descArray, 1543191750L);
			long stop5D = System.nanoTime();
			long exe5D = stop5D - start5D;
			sort5DAv += exe5D;

			long start5R = System.nanoTime();
			SortingAlgorithms.sort5(randArray, 1543191750L);
			long stop5R = System.nanoTime();
			long exe5R = stop5R - start5R;

			sort5RAv += exe5R;

		}
		sort1AAv = sort1AAv /50;
		sort1DAv = sort1DAv /50;
		sort1RAv = sort1RAv /50;
		sort2AAv = sort2AAv /50;
		sort2DAv = sort2DAv /50;
		sort2RAv = sort2RAv /50;
		sort3AAv = sort3AAv /50;
		sort3DAv = sort3DAv /50;
		sort3RAv = sort3RAv /50;
		sort4AAv = sort4AAv /50;
		sort4DAv = sort4DAv /50;
		sort4RAv = sort4RAv /50;
		sort5AAv = sort5AAv /50;
		sort5DAv = sort5DAv /50;
		sort5RAv = sort5RAv /50;
		
		System.out.println();
		
		System.out.println("sort1 Ascending Average: " + sort1AAv);
		System.out.println("sort1 Descending Average: " + sort1DAv);
		System.out.println("sort1 Random Average: " + sort1RAv);
		
		System.out.println();
		
		System.out.println("sort2 Ascending Average: " + sort2AAv);
		System.out.println("sort2 Descending Average: " + sort2DAv);
		System.out.println("sort2 Random Average: " + sort2RAv);
		
		System.out.println();
		
		System.out.println("sort3 Ascending Average: " + sort3AAv);
		System.out.println("sort3 Descending Average: " + sort3DAv);
		System.out.println("sort3 Random Average: " + sort3RAv);
		
		System.out.println();
		
		System.out.println("sort4 Ascending Average: " + sort4AAv);
		System.out.println("sort4 Descending Average: " + sort4DAv);
		System.out.println("sort4 Random Average: " + sort4RAv);
		
		System.out.println();
		
		System.out.println("sort5 Ascending Average: " + sort5AAv);
		System.out.println("sort5 Descending Average: " + sort5DAv);
		System.out.println("sort5 Random Average: " + sort5RAv);
		
	}
}
