package TH4_8;



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
public class MinhHoaCacPhepToan extends JFrame {

	private JPanel contentPane;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MinhHoaCacPhepToan frame = new MinhHoaCacPhepToan();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	private void Tinh(int e) {
		double a = 0, b = 0, kq = 0;
		if (txta.getText().equals("") || txtb.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống");
		} else {
			try {
				a = Double.parseDouble(txta.getText());
				b = Double.parseDouble(txtb.getText());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng");
			}
			switch (e) {
			case 1:
				kq = a + b;
				break;
			case 2:
				kq = a - b;
				break;
			case 3:
				kq = a * b;
				break;
			case 4:
				if (b == 0.0) {
					JOptionPane.showMessageDialog(null, "Lỗi chia cho 0!");
					txtKetQua.setText("Lỗi!!!!!!");
					return;
				} else {
					kq = a / b;
				}
				break;
			}
			txtKetQua.setText(Double.toString(kq));
		}

	}

	public MinhHoaCacPhepToan() {
		setTitle("Minh họa các phép toán");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNhpA = new JLabel("Nhập a:");
		lblNhpA.setBounds(10, 32, 46, 14);
		contentPane.add(lblNhpA);

		JLabel lblNhpB = new JLabel("Nhập b: ");
		lblNhpB.setBounds(10, 57, 46, 14);
		contentPane.add(lblNhpB);

		txta = new JTextField();
		txta.setBounds(86, 29, 202, 20);
		contentPane.add(txta);
		txta.setColumns(10);

		txtb = new JTextField();
		txtb.setBounds(86, 54, 202, 20);
		contentPane.add(txtb);
		txtb.setColumns(10);

		JButton btCong = new JButton("Cộng");
		btCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tinh(1);
			}
		});
		btCong.setBounds(10, 113, 70, 23);
		contentPane.add(btCong);

		JButton btTru = new JButton("Trừ");
		btTru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tinh(2);
			}
		});
		btTru.setBounds(86, 113, 70, 23);
		contentPane.add(btTru);

		JButton btNhan = new JButton("Nhân");
		btNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tinh(3);
			}
		});
		btNhan.setBounds(166, 113, 70, 23);
		contentPane.add(btNhan);

		JButton btChia = new JButton("Chia");
		btChia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tinh(4);
			}
		});
		btChia.setBounds(246, 113, 70, 23);
		contentPane.add(btChia);

		JButton btExit = new JButton("Exit");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btExit.setBounds(62, 147, 89, 23);
		contentPane.add(btExit);

		JButton btReset = new JButton("Reset");
		btReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txta.setText("");
				txtb.setText("");
				txtKetQua.setText("");
			}
		});
		btReset.setBounds(157, 147, 89, 23);
		contentPane.add(btReset);

		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setBounds(10, 82, 46, 14);
		contentPane.add(lblKtQu);

		txtKetQua = new JTextField();
		txtKetQua.setEditable(false);
		txtKetQua.setBounds(86, 79, 202, 20);
		contentPane.add(txtKetQua);
		txtKetQua.setColumns(10);
	}

}
