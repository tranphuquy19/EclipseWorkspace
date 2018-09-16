package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sql extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sql frame = new sql();
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
	public sql() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhpThngTin = new JLabel("Nhập thông tin:");
		lblNhpThngTin.setBounds(22, 26, 105, 14);
		contentPane.add(lblNhpThngTin);
		
		textField = new JTextField();
		textField.setBounds(143, 23, 270, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSql = new JLabel("SQL:");
		lblSql.setBounds(22, 57, 46, 14);
		contentPane.add(lblSql);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 54, 270, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(22, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(218, 227, 89, 23);
		contentPane.add(btnReset);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(428, 227, 89, 23);
		contentPane.add(btnCancel);
	}
}
