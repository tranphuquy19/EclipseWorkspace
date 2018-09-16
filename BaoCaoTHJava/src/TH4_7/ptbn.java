package TH4_7;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ptbn extends JFrame {

	private JPanel contentPane;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtKetQua;

	public static void main(String[] args) {
		ptbn frame = new ptbn();
		frame.setVisible(true);
	}

	public ptbn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNhpA = new JLabel("Nhập a");
		lblNhpA.setBounds(10, 22, 46, 14);
		contentPane.add(lblNhpA);

		JLabel lblNhpB = new JLabel("Nhập b");
		lblNhpB.setBounds(10, 47, 46, 14);
		contentPane.add(lblNhpB);

		txta = new JTextField();
		txta.setBounds(66, 19, 166, 20);
		contentPane.add(txta);
		txta.setColumns(10);

		txtb = new JTextField();
		txtb.setBounds(66, 44, 166, 20);
		contentPane.add(txtb);
		txtb.setColumns(10);

		JButton btnTnh = new JButton("Tính");
		btnTnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tinh();
			}
		});
		btnTnh.setBounds(25, 98, 58, 23);
		contentPane.add(btnTnh);

		JButton btReset = new JButton("Reset");
		btReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txta.setText("");
				txtb.setText("");
				txtKetQua.setText("");
			}
		});
		btReset.setBounds(93, 98, 77, 23);
		contentPane.add(btReset);

		JButton btThoat = new JButton("Thoát");
		btThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btThoat.setBounds(180, 98, 70, 23);
		contentPane.add(btThoat);

		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setBounds(10, 73, 46, 14);
		contentPane.add(lblKtQu);

		txtKetQua = new JTextField();
		txtKetQua.setBounds(66, 67, 166, 20);
		contentPane.add(txtKetQua);
		txtKetQua.setColumns(10);
		txtKetQua.setEditable(false);
		this.getRootPane().setDefaultButton(btnTnh);
		this.setTitle("Giải phương trình bậc nhất A.x + B = 0");
	}

	private void Tinh() {
		if (txta.getText().equals("") || txtb.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống", "Lỗi", ERROR);
		}
		try {
			double a = 0 - Double.parseDouble(txtb.getText()) / Integer.parseInt(txta.getText());
			txtKetQua.setText(Double.toString(a));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng", "Lỗi", ERROR);
		}
	}
}
