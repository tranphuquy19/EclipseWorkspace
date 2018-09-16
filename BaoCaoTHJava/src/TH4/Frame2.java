package TH4;

import java.awt.*;

@SuppressWarnings("serial")
public class Frame2 extends Frame {
	public static void main(String args[]) {
		Frame2 f = new Frame2();
		f.setTitle("Hello");
		f.setBounds(300, 200, 200, 200);
		f.setLayout(new FlowLayout());
		f.add(new Label("Enter your name"));
		f.add(new TextField("Your name here"));
		f.add(new TextArea(5, 30));
		f.setVisible(true);
	}
}
