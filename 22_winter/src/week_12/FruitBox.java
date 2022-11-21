package week_12;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FruitBox extends JFrame {
	private JCheckBox [] fruits = new JCheckBox [3];
	private String [] names = {"사과", "배", "키위"};
	private JLabel sumLabel;
	
public FruitBox() {
	setTitle("과일 장바구니입니다");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container c = getContentPane();
	c.setLayout(new FlowLayout());
	c.add(new JLabel("사과 100원, 배 500원, 키위 2000원"));
	
	MyItemListener listener = new MyItemListener();
	for(int i=0; i<fruits.length; i++) {
		fruits[i] = new JCheckBox(names[i]);
		fruits[i].setBorderPainted(true);
		c.add(fruits[i]);
		fruits[i].addItemListener(listener);
	}
	sumLabel = new JLabel("현재 0 원 입니다.");
	c.add(sumLabel);
	setSize(250,200);
	setVisible(true);
	}
	class MyItemListener implements ItemListener {
		private int sum = 0; // 가격의 합
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == fruits[0])
					sum += 100;
				else if(e.getItem() == fruits[1])
					sum += 500;
				else
					sum += 2000;
			}
			else {
				if(e.getItem() == fruits[0])
					sum -= 100;
				else if(e.getItem() == fruits[1])
					sum -= 500;
				else
					sum -= 2000;
			}
			sumLabel.setText("현재 "+ sum + "원 입니다.");
		}
	}
	public static void main(String [] args) {
		new FruitBox();
	}
}