package TH4;

import java.awt.*;

@SuppressWarnings("serial")
class Frame3 extends Frame {
	public static void main(String args[]) {
		Frame3 f = new Frame3();
		f.setTitle("Hello");
		f.setBounds(300, 200, 200, 200);
		f.setLayout(new FlowLayout());

		f.add(new Checkbox("Sport"));
		f.add(new Checkbox("Music"));
		f.add(new Checkbox("Travel"));
		CheckboxGroup cg = new CheckboxGroup();
		f.add(new Checkbox("Male", cg, false));
		f.add(new Checkbox("Female", cg, true));
		f.setVisible(true);
	}
}
