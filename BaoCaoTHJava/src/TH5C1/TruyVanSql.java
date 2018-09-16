package TH5C1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.Font;

@SuppressWarnings("serial")
public class TruyVanSql extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private ButtonGroup bg = new ButtonGroup();
	private JTable table;
	private JButton btSearch, btExit, btnReset;
	private JRadioButton rbtMaSo, rbtHoTen, rbtNgaySinh, rbtDiaChi;
	private TableDataObject tb1;
	private DefaultTableModel tbm = new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã số", "Họ tên", "Địa chỉ", "Ngày sinh", "Giới tính" });
	private ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TruyVanSql frame = new TruyVanSql();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadTable() {

		rs = tb1.toResultset("SELECT * FROM dbo.dataSV");
		// tbm.addColumn(new Object[] { "Mã số", "Họ tên", "Địa chỉ", "Ngày sinh", "Giới
		// tính" });
		tbm.addRow(new Object[] { "1", "1", "1", "1", "1" });
		try {
			while (rs.next()) {
				tbm.addRow(new Object[] { rs.getString("maso"), rs.getString("hoten"), rs.getString("diachi"),
						rs.getDate("ngaysinh").toString(), rs.getString("gioitinh") });
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */

	public TruyVanSql() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNhpNiDung = new JLabel("Nhập nội dung:");
		lblNhpNiDung.setBounds(10, 11, 90, 14);
		contentPane.add(lblNhpNiDung);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(95, 8, 251, 20);
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btSearch = new JButton("Tìm kiếm");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
			}
		});
		btSearch.setBounds(363, 7, 89, 23);
		contentPane.add(btSearch);

		btExit = new JButton("Exit");
		btExit.setBounds(553, 7, 89, 23);
		contentPane.add(btExit);

		btnReset = new JButton("Reset");
		btnReset.setBounds(462, 7, 89, 23);
		contentPane.add(btnReset);

		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo:");
		lblTmKimTheo.setBounds(10, 36, 90, 14);
		contentPane.add(lblTmKimTheo);

		rbtMaSo = new JRadioButton("Mã số");
		bg.add(rbtMaSo);
		rbtMaSo.setBounds(95, 32, 74, 23);
		contentPane.add(rbtMaSo);

		rbtHoTen = new JRadioButton("Họ tên");
		bg.add(rbtHoTen);
		rbtHoTen.setBounds(183, 32, 64, 23);
		contentPane.add(rbtHoTen);

		rbtNgaySinh = new JRadioButton("Ngày sinh");
		bg.add(rbtNgaySinh);
		rbtNgaySinh.setBounds(262, 32, 84, 23);
		contentPane.add(rbtNgaySinh);

		rbtDiaChi = new JRadioButton("Địa chỉ");
		bg.add(rbtDiaChi);
		rbtDiaChi.setBounds(360, 32, 109, 23);
		contentPane.add(rbtDiaChi);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		table.setBounds(10, 69, 622, 181);
		contentPane.add(table);
		tb1 = new TableDataObject("DSSinhVien");
		tbm = (DefaultTableModel) table.getModel();
		table.setModel(tbm);
	}
}
