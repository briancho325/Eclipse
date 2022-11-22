package chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SimpleChatServer {
	public static void main(String[] args) {
		// new ServerFrame().start();
		JFrame jf = new ServerFrame();
		jf.setSize(450, 500);
		jf.setVisible(true);
	}

}// end ServerPro class

/**
 * 
 */
class ServerFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	ServerSocket serverSocket = null;
	Socket socket = null;

	HashMap<String, ObjectOutputStream> clients;

	JLabel info = new JLabel("가동하실 서버의 PORT를 입력하세요.");
	JLabel port = new JLabel("PORT");
	JTextField portField = new JTextField(3);
	JButton con = new JButton("서버시작 하기");
	JButton disCon = new JButton("서버종료 하기");
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList<DefaultListModel<String>> list = new JList(dlm);
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();

	{
		top.setSize(450, 200);
		top.setLayout(new FlowLayout());
		top.add(info);
		top.add(port);
		top.add(portField);
		top.add(con);
		bottom.add(disCon);
		bottom.setSize(450, 200);
		con.addActionListener(this);
		disCon.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public ServerFrame() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients);// 동기화 처리
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH , top);
		this.add(BorderLayout.CENTER, new JScrollPane(list));
		this.add(BorderLayout.SOUTH , bottom);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == con) {
			int portNum = Integer.parseInt(portField.getText());
			start(portNum);
		} else if (obj == disCon) {
			System.exit(0);
		}

	}

	public void start(int port) {
		try {
			serverSocket = new ServerSocket(port);
			dlm.addElement("서버가 시작되었습니다.");
			Thread t1 = new StartThread();
			t1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // start()

	// 클라이언트가 데이터를 입력하면 모든 클라이언트에게 데이터 전달
	void sendToAll(ChatMsg msg) {
		Iterator<String> it = clients.keySet().iterator();
		while (it.hasNext()) {
			try {
				ObjectOutputStream out = (ObjectOutputStream) clients.get(it.next());
				out.writeObject(msg);
				out.flush();
			} catch (IOException e) {
			}
		} // while
	} // sendToAll

	// ServerReceiver thread 호출하는 클래스
	class StartThread extends Thread {
		public void run() {
			while (true) {
				try {
					//클라이언트 소켓이 접속될 때까지 블럭된다. accept 메소드는 블럭되는 메소드
					socket = serverSocket.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				dlm.addElement("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		}
	}

	class ServerReceiver extends Thread {
		Socket socket;
		ObjectInputStream in;
		ObjectOutputStream out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
		}

		// 쓰레드는 클라이언트가 추가될 때 마다 생긴다
		public void run() {
			System.out.println(Thread.currentThread());
			String name = "";
			try {
//				byte[] byLen = new byte[4];
//				in.readFully(byLen);
//				int nLen = Integer.parseInt(new String(byLen));
//				byte[] byData = new byte[nLen];
//				in.readFully(byData);
				
				Object oMsg = in.readObject();
				if(oMsg instanceof ChatMsg) {
					ChatMsg msg = (ChatMsg)oMsg;
					name = msg.getName();
					sendToAll(msg);
//					sendToAll(makeSendData(("#" + name + "접속").getBytes("UTF-8")));
					clients.put(msg.getName(), out);
					dlm.addElement("현재 서버접속자 수는 " + clients.size() + "입니다.");
				}else {
					System.out.println("처리할 수 없는 메시지 타입입니다.["+oMsg.getClass().getSimpleName()+"]");
				}

				
				while (in != null) {
					oMsg = in.readObject();
					if(oMsg instanceof ChatMsg) {
						ChatMsg msg = (ChatMsg)oMsg;
						sendToAll(msg);
					}else {
						System.out.println("처리할 수 없는 메시지 타입입니다.["+oMsg.getClass().getSimpleName()+"]");
					}
//					byLen = new byte[4];
//					in.readFully(byLen);
//					nLen = Integer.parseInt(new String(byLen));
//					byData = new byte[nLen];
//					in.readFully(byData);
//					byte[] byTotal = new byte[byLen.length+byData.length];
//					System.arraycopy(byLen, 0, byTotal, 0, byLen.length);
//					System.arraycopy(byData, 0, byTotal, byLen.length, byData.length);
//					sendToAll(byTotal);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sendToAll(new ChatMsg(ChatMsg.PROT_LOGOUT, name, "님이 나가셨습니다."));
				clients.remove(name);
				dlm.addElement("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				dlm.addElement("현재 서버접속자 수는 " + clients.size() + "입니다.");
			}
		}
	}
}
