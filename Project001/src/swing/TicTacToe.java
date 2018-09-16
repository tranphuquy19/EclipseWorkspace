package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame implements MouseListener {

	int so = 3;
	int s = 60;
	int of = 50;
	JButton bnewgame;
	JButton bquit;
	int check[][] = { { -4, -4, -4 }, { -4, -4, -4 }, { -4, -4, -4 } };

	public TicTacToe() {
		this.getContentPane().setLayout(null);
		setTitle("Caro Game");
		setSize(so * s + 2 * of, so * +2 * of);
		bnewgame = new JButton("New Game");
		bquit = new JButton("Quit");
		bnewgame.setBounds(30, s * so + of, 100, 30);
		bquit.setBounds(so * s + 2 * of - 150, s * so + of, 100, 30);
		bnewgame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		bquit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				disable();

			}
		});
		this.getContentPane().add(bnewgame);
		this.getContentPane().add(bquit);

		addMouseListener(this);

		setVisible(true);

	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		for (int i = 0; i <= so; i++) {
			g.setColor(Color.BLACK);
			g.drawLine(i * s + of, 0 + of, i * s + of, s * so + of);
			g.drawLine(of + 0, i * s + of, s * so + of, i * s + of);
		}

		String st;
		g.setFont(new Font("arial", Font.BOLD, s));
		for (int i = 0; i < dd.size(); i++) {
			int x = dd.get(i).x;
			int y = dd.get(i).y;
			if (i % 2 == 0) {
				st = "X";
				g.setColor(Color.RED);
			} else {
				st = "O";
				g.setColor(Color.BLUE);
			}
			g.drawString(st, s * x + of + s / 4 - s / 8, y * s + of + 3 * s / 4 + s / 8);

		}

	}

	public static void main(String[] args) {
		new TicTacToe();
	}

	private boolean checkCheo() {
		int t, p;
		t = check[0][0] + check[1][1] + check[2][2];
		p = check[0][2] + check[1][1] + check[2][0];
		System.out.println("cheo: t=" + t + "p=" + p);
		if (t == 3 || t == 0 || p == 3 || p == 0) {
			return true;
		}
		return false;
	}

	private boolean checkDraw() {
		int t = -100;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				t += check[i][j];
				System.out.println("LoopDraw=" + t +"..."+check[i][j]);
			}
		}
		System.out.println("Draw=" + t);
		if (t == -95)
			return true;
		else
			return false;
	}

	private boolean checkDoc() {
		int t;
		for (int i = 0; i < 3; i++) {
			t = check[0][i] + check[1][i] + check[2][i];
			System.out.println("Doc: t= " + t);
			if (t == 3 || t == 0)
				return true;
		}
		return false;
	}

	private boolean checkNgang() {
		int t;
		for (int i = 0; i < 3; i++) {
			t = check[i][0] + check[i][1] + check[i][2];
			System.out.println("Ngang: t=" + t);
			if (t == 3 || t == 0)
				return true;
		}
		return false;
	}

	private void ResetGame() {
		z = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				check[i][j] = -4;
			}
		}
		dd.clear();
		this.repaint();
	}

	private void checkwin(int x, int y, int u) {
		check[y][x] = u;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%d\t", check[i][j]);
			}
			System.out.println();
		}
		System.out.println(u);
		String u2 = "";
		switch (u) {
		case 1:
			u2 = "X";
			break;
		case 0:
			u2 = "O";
			break;
		}
		if (checkNgang() || checkDoc() || checkCheo()) {

			JOptionPane.showMessageDialog(null, u2 + " WIN!");
			ResetGame();
		}
	}

	ArrayList<Point> dd = new ArrayList<Point>();
	Point ex;
	int z = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int xi = (x - of) / s;
		int yi = (y - of) / s;
		if (x < of || x > s * so + of)
			return;
		if (y < of || y > s * so + of)
			return;
		ex = new Point(xi, yi);
		if (dd.contains(ex))
			return;
		else {
			z += 1;
			System.out.println("z=" + z);
			dd.add(new Point(xi, yi));
			this.repaint();
			checkwin(xi, yi, z % 2);
			if (checkDraw()) {
				JOptionPane.showMessageDialog(null, "Draw!");
				ResetGame();
			}
		}

		

		// System.out.println(xi + "," + yi);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
