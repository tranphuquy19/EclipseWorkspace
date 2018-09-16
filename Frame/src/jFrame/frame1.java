package jFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class frame1 extends JFrame {

	public static void main(String[] args) {
		JFrame f1 = new JFrame();
		f1.setLayout(null);
		f1.setSize(500, 500);
		JButton bt1 = new JButton("aaa");
		
		bt1.setBounds(0, 0,100,50);
		f1.add(bt1);
		JTextField bt2=new JTextField();
		bt2.setBounds(bt1.getX(),bt1.getY()+50, 100, 50);
		f1.add(bt2);
		f1.setVisible(true);

	}

}
