package winter_22;

import java.util.Scanner;
public class Week3Project {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		//var c = Integer.toBinaryString(a);
		//var d = Integer.toBinaryString(b);
		System.out.println(a + "+" + b + "=" + (a+b));
		System.out.println(a + "-" + b + "=" + (a-b));
		System.out.println(a + "*" + b + "=" + a*b);
		System.out.println(a + "/" + b + "=" + a/b);
		System.out.println(a + "%" + b + "=" + a%b);		

	}

}
