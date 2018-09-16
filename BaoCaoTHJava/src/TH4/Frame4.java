package TH4;

import java.awt.*;

@SuppressWarnings("serial")
class Frame4 extends Frame {
	public static void main(String args[]) {
		Frame4 f = new Frame4();
		f.setTitle("Hello");
		f.setBounds(300, 200, 200, 200);
		f.setLayout(new FlowLayout());

		Choice ch = new Choice();
		ch.addItem("Sport");
		ch.addItem("Music");
		ch.addItem("Travel");
		f.add(ch);
		List list = new List(3, false);
		list.add("Sport");
		list.add("Music");
		list.add("Travel");
		list.add("Game");
		list.add("Telen");
		f.add(list);
		f.setVisible(true);
	}
}