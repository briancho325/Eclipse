package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SquareEx extends JFrame implements ActionListener{
    public JButton button;
    public int cnt = 0;
    public boolean checkBool;

    public void paint(Graphics g){
        if(checkBool==true){
            g.setColor(Color.black);
            if(cnt == 1){
                g.drawLine(130,130,190,130);
            }
            else if(cnt == 2) {
                g.drawLine(190,130,190,190);
            }
            else if(cnt == 3) {
                g.drawLine(190,190,130,190);
            }
            else if(cnt == 4) {
                g.drawLine(130,190,130,130);
            }

        }
    }
    public void drawSquare(){
        setLayout(new BorderLayout());
        button=new JButton();

        button.setPreferredSize(new Dimension(200,20));
        button.setText("사각형");
        button.addActionListener(this);
        add(button, BorderLayout.NORTH);
        setSize(500,500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        checkBool=true;
        cnt += 1;
        repaint();
    }

    public static void main(String args[]){
        SquareEx s=new SquareEx();
        s.drawSquare();
    }
}