package TH4_11;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 330);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 384, 21);
		contentPane.add(menuBar);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Consolas", Font.PLAIN, 17));
		textField.setText("0.0");
		textField.setBounds(10, 32, 364, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnC = new JButton("C");
		btnC.setForeground(Color.RED);
		btnC.setBounds(285, 72, 89, 30);
		contentPane.add(btnC);

		JButton btnCe = new JButton("CE");
		btnCe.setForeground(Color.RED);
		btnCe.setBounds(183, 72, 89, 30);
		contentPane.add(btnCe);

		JButton btnBackspace = new JButton("Backspace");
		btnBackspace.setForeground(Color.RED);
		btnBackspace.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnBackspace.setBounds(84, 72, 89, 30);
		contentPane.add(btnBackspace);

		JButton btnSqrt = new JButton("sqrt");
		btnSqrt.setForeground(Color.BLUE);
		btnSqrt.setFont(new Font("Arial", Font.PLAIN, 10));
		btnSqrt.setHorizontalAlignment(SwingConstants.LEADING);
		btnSqrt.setBounds(324, 113, 50, 30);
		contentPane.add(btnSqrt);

		JButton button_1 = new JButton("/");
		button_1.setForeground(Color.RED);
		button_1.setBounds(264, 113, 50, 30);
		contentPane.add(button_1);

		JButton button_2 = new JButton("9");
		button_2.setForeground(Color.BLUE);
		button_2.setBounds(204, 113, 50, 30);
		contentPane.add(button_2);

		JButton button_3 = new JButton("8");
		button_3.setForeground(Color.BLUE);
		button_3.setBounds(144, 113, 50, 30);
		contentPane.add(button_3);

		JButton button_4 = new JButton("7");
		button_4.setForeground(Color.BLUE);
		button_4.setBounds(84, 113, 50, 30);
		contentPane.add(button_4);

		JButton button_5 = new JButton("%");
		button_5.setForeground(Color.BLUE);
		button_5.setBounds(324, 154, 50, 30);
		contentPane.add(button_5);

		JButton button_6 = new JButton("*");
		button_6.setForeground(Color.RED);
		button_6.setBounds(264, 154, 50, 30);
		contentPane.add(button_6);

		JButton button_7 = new JButton("6");
		button_7.setForeground(Color.BLUE);
		button_7.setBounds(204, 154, 50, 30);
		contentPane.add(button_7);

		JButton button_8 = new JButton("5");
		button_8.setForeground(Color.BLUE);
		button_8.setBounds(144, 154, 50, 30);
		contentPane.add(button_8);

		JButton button_9 = new JButton("4");
		button_9.setForeground(Color.BLUE);
		button_9.setBounds(84, 154, 50, 30);
		contentPane.add(button_9);

		JButton btnx = new JButton("1/x");
		btnx.setForeground(Color.BLUE);
		btnx.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnx.setBounds(324, 195, 50, 30);
		contentPane.add(btnx);

		JButton button_11 = new JButton("-");
		button_11.setForeground(Color.RED);
		button_11.setBounds(264, 195, 50, 30);
		contentPane.add(button_11);

		JButton button_12 = new JButton("3");
		button_12.setForeground(Color.BLUE);
		button_12.setBounds(204, 195, 50, 30);
		contentPane.add(button_12);

		JButton button_13 = new JButton("2");
		button_13.setForeground(Color.BLUE);
		button_13.setBounds(144, 195, 50, 30);
		contentPane.add(button_13);

		JButton button_14 = new JButton("1");
		button_14.setForeground(Color.BLUE);
		button_14.setBounds(84, 195, 50, 30);
		contentPane.add(button_14);

		JButton button_15 = new JButton("=");
		button_15.setForeground(Color.RED);
		button_15.setBounds(324, 236, 50, 30);
		contentPane.add(button_15);

		JButton button_16 = new JButton("+");
		button_16.setForeground(Color.RED);
		button_16.setBounds(264, 236, 50, 30);
		contentPane.add(button_16);

		JButton button_17 = new JButton(".");
		button_17.setForeground(Color.BLUE);
		button_17.setBounds(204, 236, 50, 30);
		contentPane.add(button_17);

		JButton button_18 = new JButton("+/-");
		button_18.setForeground(Color.BLUE);
		button_18.setBounds(144, 236, 50, 30);
		contentPane.add(button_18);

		JButton button_19 = new JButton("0");
		button_19.setForeground(Color.BLUE);
		button_19.setBounds(84, 236, 50, 30);
		contentPane.add(button_19);

		JButton btnNewButton = new JButton("MC");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(10, 113, 64, 30);
		contentPane.add(btnNewButton);

		JButton btnMr = new JButton("MR");
		btnMr.setForeground(Color.RED);
		btnMr.setBounds(10, 154, 64, 30);
		contentPane.add(btnMr);

		JButton btnMs = new JButton("MS");
		btnMs.setForeground(Color.RED);
		btnMs.setBounds(10, 195, 64, 30);
		contentPane.add(btnMs);

		JButton btnM = new JButton("M+");
		btnM.setForeground(Color.RED);
		btnM.setBounds(10, 236, 64, 30);
		contentPane.add(btnM);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(10, 72, 54, 30);
		contentPane.add(lblNewLabel);
	}
}
