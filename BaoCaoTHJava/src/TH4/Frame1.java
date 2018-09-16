package TH4;

import java.awt.*;

@SuppressWarnings("serial")
public class Frame1 extends Frame {

	public static void main(String[] args) {
		Frame1 f= new Frame1();
		 f.setTitle("Hello");
		 f.setBounds(300,200,200,200);
		 f.setLayout(new FlowLayout());
		 f.add(new Button("OK"));
		 f.add(new Button("Cancel"));
		 f.setVisible(true);
	}

}
