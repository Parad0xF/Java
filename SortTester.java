import java.util.Scanner;

public class SortTester {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter a space separated list of numbers to sort or type QUIT to exit:");
		String numbers = keyboard.nextLine();
		while (!numbers.equalsIgnoreCase("quit")) {
			int[] array = makeArray(numbers);

			array = makeArray(numbers);
			System.out.println("Sorted array using Selection Sort algorithm:");
			Sort.selectionSort(array);
			println(array);

			System.out.println("Please enter a space separated list of numbers to sort or type QUIT to exit:");
			numbers = keyboard.nextLine();
		}
		
		keyboard.close();
	}

	public static int[] makeArray(String str) {
		if (!str.trim().isEmpty()) {
			String[] strings = str.trim().split("[ ]+");
			int[] result = new int[strings.length];
			for (int i = 0; i < result.length; i++)
				result[i] = Integer.parseInt(strings[i]);
			return result;
		}
		else {
			return new int[0];
		}
	}

	public static boolean equals(int[] array1, int[] array2) {
		boolean equal = true;
		if (array1.length != array2.length)
			equal = false;
		int i = 0;
		while (equal && i < array1.length) {
			equal = (array1[i] == array2[i]);
		}
		return equal;
	}

	public static void println(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1)
				System.out.println(array[i]);
			else
				System.out.print(array[i] + " ");
		}
	}
}
