package TH4;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class Menudemo1 extends Frame implements MouseListener {
	Menudemo1 p = new Menudemo1("menu demo");

	Menudemo1(String title) {
		super(title);
		setBounds(300, 200, 200, 200);
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		Menu f = new Menu("Option");
		f.add(new MenuItem("Copy"));
		f.add(new MenuItem("Cut"));
		f.add(new MenuItem("Paste"));
		f.addSeparator();
		add(p);
		addMouseListener(this);
	}

	public void mouseEntered(MouseEvent m) {
	}

	public void mouseExited(MouseEvent m) {
	}

	

	public void mouseReleased(MouseEvent m) {
	}

	public void mousePressed(MouseEvent m) {
	}

	public static void main(String args[]) {
		Menudemo1 f = new Menudemo1("List Demo");
		f.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
