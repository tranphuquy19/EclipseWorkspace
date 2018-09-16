package TH4_9;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SoNguyenTo extends JFrame {

	private JPanel contentPane;
	private JTextField txtN;
	private JTextArea txtKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SoNguyenTo frame = new SoNguyenTo();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public static boolean isPrimeNumber(int n) {
		if (n < 2) {
			return false;
		}
		int squareRoot = (int) Math.sqrt(n);
		for (int i = 2; i <= squareRoot; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public SoNguyenTo() {
		setTitle("Tìm số nguyên tố nhỏ <= N");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNhpSNguyn = new JLabel("Nhập số nguyên tố n cho trước:");
		lblNhpSNguyn.setBounds(10, 33, 286, 14);
		contentPane.add(lblNhpSNguyn);

		txtN = new JTextField();
		txtN.setBounds(35, 51, 261, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);

		JLabel lblKtQu = new JLabel("Kết quả:");
		lblKtQu.setBounds(10, 82, 46, 14);
		contentPane.add(lblKtQu);

		txtKetQua = new JTextArea();
		txtKetQua.setLineWrap(true);
		txtKetQua.setBounds(35, 107, 261, 108);
		contentPane.add(txtKetQua);

		JButton btTim = new JButton("Tìm");
		btTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tim();
			}
		});
		btTim.setBounds(35, 227, 70, 23);
		contentPane.add(btTim);

		JButton btReset = new JButton("Reset");
		btReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtN.setText("");
				txtKetQua.setText("");
			}
		});
		btReset.setBounds(115, 227, 70, 23);
		contentPane.add(btReset);

		JButton btExit = new JButton("Exit");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btExit.setBounds(195, 227, 70, 23);
		contentPane.add(btExit);
	}

	public void Tim() {
		int nnt;
		String kqq = "";
		StringBuffer str = new StringBuffer();
		if (txtN.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Không được để trống");
		} else {
			try {
				nnt = Integer.parseInt(txtN.getText());
				if (nnt < 2) {
					JOptionPane.showMessageDialog(null, "Không có SNT, nhập giá trị >=2 để tìm");
					return;
				} else if (nnt >= 2) {
					str.append(Integer.toString(2) + " ");
				}
				for (int i = 3; i < nnt; i += 2) {
					if (isPrimeNumber(i)) {
						str.append(Integer.toString(i) + " ");
					}
					kqq = str.toString();
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng");
			}
		}
		txtKetQua.setText(kqq);
	}

}
