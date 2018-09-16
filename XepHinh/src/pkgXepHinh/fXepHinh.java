package pkgXepHinh;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fXepHinh extends JFrame {

	private int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	private Random r = new Random();
	private int array[] = { 0, 0, 0, 0, 0, 0, 0, 0 };
	private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	private String arraybt[][] = { { "0", "0", "0" }, { "0", "0", "0" }, { "0", "0", "0" } };
	private String[][] StepArray = { { "0", "0", "0" }, { "0", "0", "0" }, { "0", "0", "0" } };

	private static boolean kt(int a[], int temp) {
		for (int i = 0; i < 8; i++) {
			if (a[i] == temp)
				return true;
		}
		return false;
	}

	private void Win() {
		System.out.println("Check");
		String check = "";
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				check += StepArray[i][j];
			}
		}
		if("12345678*".equals(check)) {
			JOptionPane.showMessageDialog(null, "You Win");
			setBtValue();
			setTxtButton();
		}
	}

	private static int kt(int a[]) {
		int count = 0;
		int fist;
		int sub = 0, sub2 = 0, sub3 = 0;
		for (int i = 0; i < 8; i++) {
			sub3 += a[i];
		}
		if (sub3 == 0)
			return 1;
		while (count < 8) {
			fist = a[count];
			sub2 = 0;
			for (int i = count + 1; i < 8; i++) {
				if (a[i] < fist) {
					sub2++;
				}
			}
			sub += sub2;
			count++;
		}
		return sub;
	}

	private void setBtValue() {
		for (int z = 0; z < 8; z++) {
			array[z] = 0;
		}
		while (kt(array) % 2 != 0) {
			for (int i = 0; i < 8; i++) {
				array[i] = 0;
			}
			int temp = 0, rand = 0;
			int count = 0;
			while (kt(array, 0)) {
				rand = r.nextInt(8);
				temp = a[rand];
				if (kt(array, temp) == false) {
					array[count] = temp;
					count++;
				}
			}
		}
	}

	private void setTxtButton() {
		arraybt[0][0] = Integer.toString(array[0]);
		bt1.setText(arraybt[0][0]);
		arraybt[0][1] = Integer.toString(array[1]);
		bt2.setText(arraybt[0][1]);
		arraybt[0][2] = Integer.toString(array[2]);
		bt3.setText(arraybt[0][2]);
		arraybt[1][0] = Integer.toString(array[3]);
		bt4.setText(arraybt[1][0]);
		arraybt[1][1] = Integer.toString(array[4]);
		bt5.setText(arraybt[1][1]);
		arraybt[1][2] = Integer.toString(array[5]);
		bt6.setText(arraybt[1][2]);
		arraybt[2][0] = Integer.toString(array[6]);
		bt7.setText(arraybt[2][0]);
		arraybt[2][1] = Integer.toString(array[7]);
		bt8.setText(arraybt[2][1]);
		arraybt[2][2] = "*";
		bt9.setText(arraybt[2][2]);
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fXepHinh frame = new fXepHinh();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fXepHinh() {
		setTitle("Xếp hình");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setBtValue();
		bt1 = new JButton(Integer.toString(array[0]));
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetStepArray();
				if (StepArray[1][0] == "*") {
					bt4.setText(bt1.getText());
					bt1.setText("*");
				} else if (StepArray[0][1] == "*") {
					bt2.setText(bt1.getText());
					bt1.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt1.setBounds(10, 11, 49, 40);
		contentPane.add(bt1);

		bt2 = new JButton(Integer.toString(array[1]));
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetStepArray();
				if (StepArray[0][0] == "*") {
					bt1.setText(bt2.getText());
					bt2.setText("*");
				} else if (StepArray[0][2] == "*") {
					bt3.setText(bt2.getText());
					bt2.setText("*");
				} else if (StepArray[1][1] == "*") {
					bt5.setText(bt2.getText());
					bt2.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt2.setBounds(69, 11, 49, 40);
		contentPane.add(bt2);

		bt3 = new JButton(Integer.toString(array[2]));
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetStepArray();
				if (StepArray[0][1] == "*") {
					bt2.setText(bt3.getText());
					bt3.setText("*");
				} else if (StepArray[1][2] == "*") {
					bt6.setText(bt3.getText());
					bt3.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt3.setBounds(128, 11, 49, 40);
		contentPane.add(bt3);

		bt4 = new JButton(Integer.toString(array[3]));
		bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (StepArray[0][0] == "*") {
					bt1.setText(bt4.getText());
					bt4.setText("*");
				} else if (StepArray[1][1] == "*") {
					bt5.setText(bt4.getText());
					bt4.setText("*");
				} else if (StepArray[2][0] == "*") {
					bt7.setText(bt4.getText());
					bt4.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt4.setBounds(10, 62, 49, 40);
		contentPane.add(bt4);

		bt5 = new JButton(Integer.toString(array[4]));
		bt5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (StepArray[0][1] == "*") {
					bt2.setText(bt5.getText());
					bt5.setText("*");
				} else if (StepArray[1][0] == "*") {
					bt4.setText(bt5.getText());
					bt5.setText("*");
				} else if (StepArray[1][2] == "*") {
					bt6.setText(bt5.getText());
					bt5.setText("*");
				} else if (StepArray[2][1] == "*") {
					bt8.setText(bt5.getText());
					bt5.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt5.setBounds(69, 62, 49, 40);
		contentPane.add(bt5);

		bt6 = new JButton(Integer.toString(array[5]));
		bt6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetStepArray();
				if (StepArray[0][2] == "*") {
					bt3.setText(bt6.getText());
					bt6.setText("*");
				} else if (StepArray[1][1] == "*") {
					bt5.setText(bt6.getText());
					bt6.setText("*");
				} else if (StepArray[2][2] == "*") {
					bt9.setText(bt6.getText());
					bt6.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt6.setBounds(128, 62, 49, 40);
		contentPane.add(bt6);

		bt7 = new JButton(Integer.toString(array[6]));
		bt7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetStepArray();
				if (StepArray[1][0] == "*") {
					bt4.setText(bt7.getText());
					bt7.setText("*");
				} else if (StepArray[2][1] == "*") {
					bt8.setText(bt7.getText());
					bt7.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt7.setBounds(10, 113, 49, 40);
		contentPane.add(bt7);

		bt8 = new JButton(Integer.toString(array[7]));
		bt8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetStepArray();
				if (StepArray[2][0] == "*") {
					bt7.setText(bt8.getText());
					bt8.setText("*");
				} else if (StepArray[1][1] == "*") {
					bt5.setText(bt8.getText());
					bt8.setText("*");
				} else if (StepArray[2][2] == "*") {
					bt9.setText(bt8.getText());
					bt8.setText("*");
				}
				SetStepArray();
				Win();
			}
		});
		bt8.setBounds(69, 113, 49, 40);
		contentPane.add(bt8);

		bt9 = new JButton("*");
		bt9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetStepArray();
				if (StepArray[1][2] == "*") {
					bt6.setText(bt9.getText());
					bt9.setText("*");
				} else if (StepArray[2][1] == "*") {
					bt8.setText(bt9.getText());
					bt9.setText("*");
				}
				SetStepArray();
				Win();

			}
		});
		bt9.setBounds(128, 113, 49, 40);
		contentPane.add(bt9);

		JButton btnReplay = new JButton("Re-play");
		btnReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTxtButton();
			}
		});
		btnReplay.setBounds(224, 11, 102, 23);
		contentPane.add(btnReplay);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBtValue();
				setTxtButton();
			}
		});
		btnNewGame.setBounds(224, 45, 102, 23);
		contentPane.add(btnNewGame);
	}

	private void SetStepArray() {
		StepArray[0][0] = bt1.getText();
		StepArray[0][1] = bt2.getText();
		StepArray[0][2] = bt3.getText();
		StepArray[1][0] = bt4.getText();
		StepArray[1][1] = bt5.getText();
		StepArray[1][2] = bt6.getText();
		StepArray[2][0] = bt7.getText();
		StepArray[2][1] = bt8.getText();
		StepArray[2][2] = bt9.getText();
	}
}
