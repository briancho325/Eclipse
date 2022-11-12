package TermProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SimpleChatClient {
	public static void main(String[] args) {
		JFrame jf = new ClientFrame();
		jf.setSize(550, 500);
		jf.setVisible(true);
	}
}

class ClientFrame extends JFrame implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel ip = new JLabel("Ip");
	JTextField ipField = new JTextField(13);
	JLabel port = new JLabel("Port");
	JTextField portField = new JTextField(5);
	JLabel id = new JLabel("ID");
	JTextField idField = new JTextField(5);
	JButton con = new JButton("접속요청");
	JButton disCon = new JButton("접속종료");
	DefaultListModel dlm = new DefaultListModel();
	JList list = new JList(dlm);
	JTextField uMsg = new JTextField(20);
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	String uid = "";

	// 소켓의 생성
	Socket socket;
	DataOutputStream out;

	{
		top.setSize(550, 200);
		top.setLayout(new FlowLayout());
		top.add(ip);
		top.add(ipField);
		top.add(port);
		top.add(portField);
		top.add(id);
		top.add(idField);
		top.add(con);
		bottom.add(disCon);
		bottom.add(uMsg);
		bottom.setSize(550, 200);
		con.addActionListener(this);
		disCon.addActionListener(this);
		uMsg.addKeyListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public ClientFrame() {
		this.setLayout(new BorderLayout());
		this.add("North", top);
		this.add("Center", new JScrollPane(list));
		this.add("South", bottom);
	}

	//키이벤트 시작-----------------------------------------------
	@Override
	public void keyPressed(KeyEvent e) {
		//엔터를 누르면 서버로 데이터를 송신(write & flush)한다.
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				String strData = "[" + uid + "]" + uMsg.getText();
				String strLen = String.format("%04d", strData.getBytes("UTF-8").length);
				out.write((strLen+strData).getBytes("UTF-8"));
				out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			uMsg.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	//키이벤트 끝-----------------------------------------------
	
	//버튼 이벤트 시작-------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == con) {
			String uip = ipField.getText();
			int uport = Integer.parseInt(portField.getText());
			uid = idField.getText();
			init(uid, uip, uport);
		} else if (obj == disCon) {
			System.exit(0);
		}
	}
	//버튼 이벤트 끝-------------------------------------------

	public void init(String uid, String uip, int uport) {
		try {
			String serverIp = uip;
			// 소켓을 생성하여 연결을 요청한다.
			socket = new Socket(serverIp, uport);
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("서버에 연결되었습니다.");
			// 접속자 이름전송
			out.write((String.format("%04d", uid.getBytes().length)+uid).getBytes("UTF-8"));
			out.flush();
			
			//클라이언트 소켓을 처리할 쓰레드를 생성 및 기동한다.
			Thread receiver = new Thread(new ClientReceiver(socket));
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
		}
	}

	//클라이언트 소켓을 처리할 쓰레드 생성
	class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
			}
		}

		public void run() {
			while (in != null) {
				try {
					byte[] byLen = new byte[4];
					in.readFully(byLen);	//서버로부터 데이터 길이부(4)가 수신될 때까지 블럭된다.
					int nLen = Integer.parseInt(new String(byLen));
					byte[] byData = new byte[nLen];
					in.readFully(byData);	//길이만큼 데이터를 수신할 때까지 블럭된다.
//					String strRe = new String(byData, "UTF-8");
					String strRe = new String(byData);
					System.out.println(strRe);
					dlm.addElement(strRe);
				} catch (IOException e) {
				}
			}
		} // run
	}// end class ClientReceiver
}