package TH4_10;


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
public class Fibonacy extends JFrame {

	private JPanel contentPane;
	private JTextField txtN;
	private JTextField txtKQ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Fibonacy frame = new Fibonacy();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	private boolean isSquare(int n)
	{
	    int s = (int) Math.sqrt(n);
	    return s*s == n;
	}
	 
	private boolean isFibonacci(int n)
	{
	    int m = 5*n*n;
	    return isSquare(m-4) || isSquare(m+4);
	}
	public Fibonacy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhpN = new JLabel("Nhập N:");
		lblNhpN.setBounds(10, 38, 46, 14);
		contentPane.add(lblNhpN);
		
		txtN = new JTextField();
		txtN.setBounds(58, 35, 122, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		JLabel lblKtQu = new JLabel("Kết quả:");
		lblKtQu.setBounds(10, 63, 46, 14);
		contentPane.add(lblKtQu);
		
		txtKQ = new JTextField();
		txtKQ.setEditable(false);
		txtKQ.setBounds(58, 63, 122, 20);
		contentPane.add(txtKQ);
		txtKQ.setColumns(10);
		
		JButton btKiemTra = new JButton("Kiểm tra");
		btKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n;
				try {
					n = Integer.parseInt(txtN.getText());
					if(isFibonacci(n))
					{
						txtKQ.setText("YES!");
					}
					else
					{
						txtKQ.setText("NO!");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Không được để trống");
				}
				
			}
		});
		btKiemTra.setBounds(10, 105, 89, 23);
		contentPane.add(btKiemTra);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtN.setText("");
				txtKQ.setText("");
			}
		});
		btnReset.setBounds(119, 105, 89, 23);
		contentPane.add(btnReset);
	}
}
