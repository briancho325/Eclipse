package TermProject;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * client 로직
 * @author 
 */
public class SimpleClientTest {
	public static void main(String[] args) {
		Socket cs = null;
		try {
			cs = new Socket("localhost", 9998);
			cs.getOutputStream().write("0004TEST".getBytes());
			cs.getOutputStream().flush();
			
			InputStream is = cs.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			byte[] lenByte = new byte[4];
			dis.readFully(lenByte);
			int size = Integer.parseInt(new String(lenByte));
			
			byte[] dataByte = new byte[size];
			dis.readFully(dataByte);
			
			byte[] totByte = new byte[lenByte.length + dataByte.length];
			System.arraycopy(lenByte, 0, totByte, 0, lenByte.length);
			System.arraycopy(dataByte, 0, totByte, lenByte.length, dataByte.length);
			
			System.out.println("client recv:"+new String(totByte));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
