package test;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Sample1 extends JFrame {

	private static final long serialVersionUID = 1L;
	//생성자
    public Sample1() {
    	this.setSize(300, 200); //크기 설정
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setTitle("프레임 작성예시");
        
        setLayout(new FlowLayout()); //배치 관리자 설정
        JButton button = new JButton("버튼");
        
        //컴포넌트 생성 및 추가
        this.add(button);
        this.setVisible(true);
        this.setResizable(false);
    }
    public static void main(String[] args) {
        new Sample1();
    }
}
