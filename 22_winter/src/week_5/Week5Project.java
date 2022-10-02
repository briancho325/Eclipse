package week_5;

import java.util.Scanner;

public class Week5Project {

	public static void main(String[] args) {
		int num[] = new int[5];
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("java Test3 ");
		
		for (int i = 0; i < num.length; i++) {
			num[i] = scanner.nextInt();
		}
		
		for (int i =0; i < num.length; i++) {
			
			for (int j = i+1; j< num.length; j++) {
				
				if (num[i] > num[j]) {
					
					int temp = num[j];
					num[j] = num[i];
					num[i] = temp;
					
				}else { 
					
					break;
				}
			}
		}
		System.out.print("sort 결과 : ");
		for (int sort : num) {
			System.out.print(sort + " ");
		}
	}

}
