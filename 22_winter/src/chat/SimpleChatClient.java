package chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

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
	JTextField ipField   = new JTextField(13);
	JTextField portField = new JTextField(5);
	JTextField idField   = new JTextField(5);
	JButton btnCon       = new JButton("접속요청");
	JButton btnFile      = new JButton("파일");
	JButton btnEmoticon  = new JButton("이모티콘");
	JButton btnDisCon    = new JButton("접속종료");
	DefaultListModel dlm = new DefaultListModel<>();
	JList<DefaultListModel<String>> list = new JList(dlm);
	JTextField msgField = new JTextField(20);
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	String uid = "";

	// 소켓의 생성
	Socket socket;
	public static ObjectOutputStream out;

	{
		top.setSize(550, 200);
		top.setLayout(new FlowLayout());
		top.add(new JLabel("Ip"));
		top.add(ipField);
		top.add(new JLabel("Port"));
		top.add(portField);
		top.add(new JLabel("ID"));
		top.add(idField);
		top.add(btnCon);
		bottom.add(btnFile);
		bottom.add(btnEmoticon);
		bottom.add(msgField);
		bottom.add(btnDisCon);
		bottom.setSize(550, 200);
		
		btnFile.addActionListener(this);
		btnEmoticon.addActionListener(this);
		btnCon.addActionListener(this);
		btnDisCon.addActionListener(this);
		msgField.addKeyListener(this);
		
		list.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public ClientFrame() {
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH , top);
		this.add(BorderLayout.CENTER, new JScrollPane(list));
		this.add(BorderLayout.SOUTH , bottom);
	}

	//키이벤트 시작-----------------------------------------------
	@Override
	public void keyPressed(KeyEvent ke) {
		//엔터를 누르면 서버로 데이터를 송신(write & flush)한다.
		if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				ChatMsg msg = new ChatMsg(ChatMsg.PROT_MESSAGE, uid, msgField.getText());
				out.writeObject(msg);
				out.flush();
				
//				String strData = "[" + uid + "]" + msgField.getText();
//				String strLen = String.format("%04d", strData.getBytes("UTF-8").length);
//				out.write((strLen+strData).getBytes("UTF-8"));
//				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			msgField.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent ke) {
	}
	@Override
	public void keyTyped(KeyEvent ke) {
	}
	//키이벤트 끝-----------------------------------------------
	
	//버튼 이벤트 시작-------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnCon) {
			String uip = ipField.getText();
			int uport = Integer.parseInt(portField.getText());
			uid = idField.getText();
			init(uid, uip, uport);
		} else if (obj == btnDisCon) {
			System.exit(0);
		} else if(obj == btnFile) {
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.setDialogTitle("Multiple file and directory selection:");
			//다중 선택 가능
			jfc.setMultiSelectionEnabled(true);
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	
			//파일필터 추가
			FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and GIF and JPG images", "png", "gif", "jpg");
			jfc.addChoosableFileFilter(filter);
			FileNameExtensionFilter pdf = new FileNameExtensionFilter("Pdf file(.pdf)", "pdf");
			jfc.addChoosableFileFilter(pdf);

			int returnValue = jfc.showOpenDialog(this);	//열기 모드
			//선택 버튼 클릭인지 여부 판단
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File[] files = jfc.getSelectedFiles();
				System.out.println("\n- - - - - - - - - - -\n");
				System.out.println("Files Found\n");
				Arrays.asList(files).forEach(x -> {
					if (x.isFile()) {
						try {
							ChatMsg msg = new ChatMsg(ChatMsg.PROT_FILE, uid, "파일 전송");
//							msg.setFile(serialize(x));
							msg.setFile(x);
							ClientFrame.out.writeObject(msg);
							ClientFrame.out.flush();
							System.out.println(x.getAbsolutePath());							
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				});
			}
		} else if(obj == btnEmoticon) {
			JDialog emoticonDlg = new JDialog(this);
			emoticonDlg.setSize(400, 320);
			emoticonDlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			emoticonDlg.setLayout(new BorderLayout());
			emoticonDlg.setTitle("이모티콘 선택");
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3,4));
			
			File imgDir = new File("emoji");
			File[] imgFiles = imgDir.listFiles(new FilenameFilter() { 
                @Override 
                public boolean accept(File dir, String name) { 
                     return name.endsWith("png"); // || name.endsWith("jpg") || name.endsWith("gif"); 
                }
			});
			
			for(int i=0; i<imgFiles.length ;i++) {
				ImageIcon icon = new ImageIcon(imgFiles[i].getAbsolutePath());
				JLabel lbl = new JLabel(icon);
				lbl.setSize(20,20);
				lbl.addMouseListener(new MouseListener() {
					@Override
					public void mouseReleased(MouseEvent e) {
						ImageIcon icon= (ImageIcon) lbl.getIcon();
						try {
							ChatMsg msg = new ChatMsg(ChatMsg.PROT_IMAGE, uid, "이미지 전송");
//							msg.setImage(serialize(icon));
							msg.setImage(icon);
							ClientFrame.out.writeObject(msg);
							ClientFrame.out.flush();
							emoticonDlg.dispose();
//							System.out.println(x.getAbsolutePath());
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
					@Override
					public void mousePressed(MouseEvent e) {}
					@Override
					public void mouseExited(MouseEvent e) {}
					@Override
					public void mouseEntered(MouseEvent e) {}
					@Override
					public void mouseClicked(MouseEvent e) {}
				});
				panel.add(lbl);
			}
			emoticonDlg.add(panel, BorderLayout.CENTER);
			emoticonDlg.setResizable(false);
			emoticonDlg.setVisible(true);
		}
	}
	//버튼 이벤트 끝-------------------------------------------

	public void init(String uid, String uip, int uport) {
		try {
			String serverIp = uip;
			// 소켓을 생성하여 연결을 요청한다.
			socket = new Socket(serverIp, uport);
			out = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("서버에 연결되었습니다.");
			
			// 접속자 이름전송
			ChatMsg msg = new ChatMsg(ChatMsg.PROT_LOGIN, uid, " 님이 접속 하였습니다.");
			out.writeObject(msg);
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
		ObjectInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
			}
		}

		public void run() {
			int nRow = 0;
			while (in != null) {
				try {
					Object oMsg = in.readObject();
					if(oMsg instanceof ChatMsg) {
						ChatMsg msg = (ChatMsg)oMsg;
						String strMsg = null;
						switch(msg.getProtocol()) {
							case ChatMsg.PROT_LOGIN:
							case ChatMsg.PROT_MESSAGE:
							case ChatMsg.PROT_LOGOUT:
								strMsg = "["+msg.getName()+"]["+msg.getMessage()+"]";
								System.out.println(strMsg);
								dlm.add(nRow++, strMsg);
								break;
							case ChatMsg.PROT_IMAGE:
								strMsg = "["+msg.getName()+"] 님이 이미지아이콘을 보내셨습니다.";
								System.out.println(strMsg);
								dlm.add(nRow++, strMsg);
								dlm.add(nRow++, msg.getImage());
								break;
							case ChatMsg.PROT_FILE:
								strMsg = "["+msg.getName()+"] 님이 파일을 보내셨습니다. ["+msg.getMessage()+"]";
								System.out.println(strMsg);
								dlm.add(nRow++, strMsg);
								dlm.add(nRow++, msg.getFile());
								break;
						}
					} else {
						dlm.addElement("처리할 수 없는 메시지가 도착했습니다. 메시지타입:"+oMsg.getClass().getSimpleName());
					}
				} catch (Exception e) {
				}
			}
		} // run
	}// end class ClientReceiver
	
    public static byte[] serialize(Object obj){
        try(ByteArrayOutputStream b = new ByteArrayOutputStream()){
            try(ObjectOutputStream o = new ObjectOutputStream(b)){
                o.writeObject(obj);
            }catch(IOException e){
            }
            return b.toByteArray();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }

    /**
     * deserialize bytes to message
     * 
     * @param bytes message in bytes
     * @return message instance
     */
    public static Object deserialize(byte[] bytes){
        try(ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        	ObjectInputStream o = new ObjectInputStream(b)){
        	return o.readObject();
        }catch(Exception e){
        	e.printStackTrace();
        }
        return null;
    }
}