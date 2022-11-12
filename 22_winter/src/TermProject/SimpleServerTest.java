package TermProject;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * server 로직
 * @author 
 */
public class SimpleServerTest {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(9998);	//해당 포트로 서버를 띄운다.
			Socket cs = ss.accept();		//클라이언트 소켓을 기다림
			InputStream is = cs.getInputStream();	//클라이언트 소켓에서 인풋스트림을 얻는다.
			DataInputStream dis = new DataInputStream(is);
			byte[] lenByte = new byte[4];	//길이부 데이터를 읽는다.
			
			dis.readFully(lenByte);			//길이부 데이터를 읽는다.
			int size = Integer.parseInt(new String(lenByte));	//byte[]에서 숫자형 길이데이터로 변환한다.
			
			byte[] dataByte = new byte[size];
			dis.readFully(dataByte);		//데이터를 읽는다.
			
			byte[] totByte = new byte[lenByte.length + dataByte.length];
			System.arraycopy(lenByte, 0, totByte, 0, lenByte.length);
			System.arraycopy(dataByte, 0, totByte, lenByte.length, dataByte.length);	//총데이터를 구한다.(길이부와 데이터를 합한다.)
			
			System.out.println("server recv:"+new String(totByte));	//총 데이터를 출력한다.
			cs.getOutputStream().write(totByte);		//데이터를 모든 클라이언트에 write한다.
			cs.getOutputStream().flush();				//송신 버퍼의 잔여 데이터를 모두 쓴다.
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
