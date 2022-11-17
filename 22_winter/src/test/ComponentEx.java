package test;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComponentEx extends JFrame {
	private static final long serialVersionUID = 1L;

	public ComponentEx() {
		setTitle("컴포넌트 예제"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout 배치관리자 달기
		add(new JLabel("Hello World")); // 레이블
		add(new JButton("클릭")); // 버튼
		add(new JTextField(20)); // 텍스트필드

		setSize(300, 150); // 프레임 크기 300 x 150
		setVisible(true); // 화면에 프레임 출력
	}

	public static void main(String[] args) {
		new ComponentEx();
	}
}
