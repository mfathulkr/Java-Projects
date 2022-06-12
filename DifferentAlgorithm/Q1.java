//-----------------------------------------------------
// Title: Q1 class
// Author: Mehmet Fatih Ülker
// ID: 15431917506
// Section: 01
// Assignment: 02
// Description: This class is about the algorithm which is mentioned in task1.
//-----------------------------------------------------
public class Q1 {

	public static void differentSort(int[] arr)
	// --------------------------------------------------------
	// Summary: This algorithms is so similar to bubble sort algorithm
	// in the fundamental logic but there are small differences. Algorithm
	// starts from the left and it keeps swapping the larger element with
	// the small element so that larger one remains on the right side.
	// When it comes to the end of the array, it does the same by moving
	// from the end of the array to the beginning. Each forward and backward
	// process works in a loop, and at the beginning of these loops there are
	// checkpoints to check the successful completion of the process.
	// --------------------------------------------------------
	{

		boolean dealt;

		do {
			dealt = false;

			for (int i = 0; i <= arr.length - 2; i++) {
				if (arr[i] > arr[i + 1]) {
					deal(arr, i, i + 1);
					dealt = true;
				}

			}

			if (dealt == false) {

				break;
			}

			dealt = false;

			for (int i = arr.length - 2; i > 0; i--) {
				if (arr[i] > arr[i + 1]) {

					deal(arr, i, i + 1);
					dealt = true;
				}

			}

		} while (dealt);

	}

	public static void deal(int[] arr, int i, int j)
	// --------------------------------------------------------
	// Summary: This method is for swap the indexes of the elements
	// --------------------------------------------------------
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] array = { 15, 98, 12, 1, 651, 51, 351, 531, 31, 35135, 132, 1321, 115, 1, 1, 4, 11, 78, 66, 1, 1 };
		int[] array2 = { 51, 64, 15, 34, 1, 6, 35, 4, 1, 4, 1, 35, 21638, 349, 31, 68, 41, 5, 2, 42, 96, 1351, 68, 54,
				1 };

		System.out.println("Unsorted:");

		// printing operation for unsorted

		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i]);
				break;
			}
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		for (int i = 0; i < array2.length; i++) {
			if (i == array2.length - 1) {
				System.out.println(array2[i]);
				break;
			}
			System.out.print(array2[i] + ", ");
		}

		// static method calls are here

		differentSort(array);
		differentSort(array2);
		System.out.println();

		System.out.println("Sorted:");

		// printing operation for sorted

		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i]);
				break;
			}
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		for (int i = 0; i < array2.length; i++) {
			if (i == array2.length - 1) {
				System.out.println(array2[i]);
				break;
			}
			System.out.print(array2[i] + ", ");
		}
	}

}
