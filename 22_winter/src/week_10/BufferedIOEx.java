package week_10;

import java.io.*;
import java.util.Scanner;

public class BufferedIOEx {

	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("/Users/briancho/test2.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			while ((c = fin.read()) != -1) {
				out.write(c); //버퍼가 꽉 찰 때 문자가 화면에 출력
			}
			
			//파일 데이터가 모두 출력된 상태
			new Scanner(System.in).nextLine();
			out.flush(); //버퍼에 남아있던 문자 모두 출력 <enter>키 기다림
			fin.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
