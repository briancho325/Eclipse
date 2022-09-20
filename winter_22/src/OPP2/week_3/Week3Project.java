package week3;

import java.util.Scanner;
public class Week3Project {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		//var c = Integer.toBinaryString(a);
		//var d = Integer.toBinaryString(b);
		System.out.println(a + "+" + b + "=" + (a+b));
		System.out.println(a + "-" + b + "=" + (a-b));
		System.out.println(a + "*" + b + "=" + a*b);
		System.out.println(a + "/" + b + "=" + a/b);
		System.out.println(a + "%" + b + "=" + a%b);		

	}

}
