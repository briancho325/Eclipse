package week_5;

import java.util.Scanner;
import java.util.Arrays;

public class Week5ex {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			/*String num = scan.next();
			String[] i_arr = {num};
			
			Arrays.sort(i_arr);
			for (int num1 =0; num1 < i_arr.length; num1++);
			System.out.print(i_arr[] + " ");*/
			String num = scan.next();
			String[] intArray = {num};
			Arrays.sort(intArray);
			for (String i : intArray) {
				System.out.print(i + " ");
			}
		}
	}
}