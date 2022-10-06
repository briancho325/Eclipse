package week_5;

import java.util.Scanner;
import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Java test3");
		
		double a = 0;
		
		while (scan.hasNextDouble()) {
			double temp = scan.nextDouble();
			a = temp;
			double[] arr = {a};
			Arrays.sort(arr);
		}
		
		
		
		
		System.out.print("sort 결과 : ");
	//			System.out.print(Arrays.toString(arr) + " ");
		
		System.out.print("\n");
		

	}

}
