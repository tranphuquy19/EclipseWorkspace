package defaultConfig;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EasyTranslateConfig{

	public JFrame frmEasyTranslateConfig;
	private JTextField txtTime;
	private JSONConfig config;
	private JCheckBox checkStartup;
	private JCheckBox checkHistory;
	private JCheckBox checkVoice;
	private int langIndex;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public EasyTranslateConfig() {
		config = new JSONConfig();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		
		frmEasyTranslateConfig = new JFrame();
		frmEasyTranslateConfig.getContentPane().setBackground(new Color(255, 255, 255));
		frmEasyTranslateConfig.setTitle("Easy Translate Config");
		frmEasyTranslateConfig.setBounds(100, 100, 447, 234);
		frmEasyTranslateConfig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEasyTranslateConfig.getContentPane().setLayout(null);
		
		JLabel lblChuynTingVit = new JLabel("Chuyển Tiếng Việt sang:");
		lblChuynTingVit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChuynTingVit.setIcon(null);
		lblChuynTingVit.setForeground(new Color(153, 50, 204));
		lblChuynTingVit.setBounds(10, 40, 166, 19);
		frmEasyTranslateConfig.getContentPane().add(lblChuynTingVit);
		
		JComboBox cbLang = new JComboBox();
		cbLang.setBounds(198, 39, 199, 20);
		cbLang.setModel(new DefaultComboBoxModel(config.getVNto().toArray()));
		langIndex = 0;
		for(int i = 0; i<config.getJsonISO6391().size(); i++)
		{
			String temp = (String) config.getJsonISO6391().get(i);
			String temp2 = (String) config.getConfigISO6391();
			if(temp2.equals(temp)) break;
			else langIndex++;
		}
		cbLang.setSelectedIndex(langIndex);
		frmEasyTranslateConfig.getContentPane().add(cbLang);
		
		JLabel lblCuHnhEasy = new JLabel("Cấu hình Easy Translate");
		lblCuHnhEasy.setForeground(new Color(153, 50, 204));
		lblCuHnhEasy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCuHnhEasy.setBounds(10, 11, 183, 14);
		frmEasyTranslateConfig.getContentPane().add(lblCuHnhEasy);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 27, 414, 2);
		frmEasyTranslateConfig.getContentPane().add(separator);
		
		JLabel lblThiGianHin = new JLabel("Thời gian hiển thị:");
		lblThiGianHin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblThiGianHin.setForeground(new Color(153, 50, 204));
		lblThiGianHin.setBounds(10, 70, 109, 17);
		frmEasyTranslateConfig.getContentPane().add(lblThiGianHin);
		
		txtTime = new JTextField();
		txtTime.setBounds(198, 67, 199, 20);
		txtTime.setText(Integer.toString(Integer.parseInt((config.getJsonConfig().get("Countdown").toString()))));
		frmEasyTranslateConfig.getContentPane().add(txtTime);
		txtTime.setColumns(10);
		
		JLabel lblMaximumIss = new JLabel("Maximum is 7s (default), 0 to Stop");
		lblMaximumIss.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblMaximumIss.setBounds(231, 90, 166, 14);
		frmEasyTranslateConfig.getContentPane().add(lblMaximumIss);
		
		JLabel txtHistory = new JLabel("  (mở lịch sử dịch)");
		txtHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtHistory.setForeground(new Color(255, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtHistory.setForeground(new Color(0, 0, 255));
			}
		});
		txtHistory.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtHistory.setForeground(new Color(0, 0, 255));
		txtHistory.setBounds(122, 143, 117, 14);
		frmEasyTranslateConfig.getContentPane().add(txtHistory);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(148, 0, 211));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				config.setConfigStartup(checkStartup.isSelected());
				config.setConfigHistory(checkHistory.isSelected());
				config.setConfigVoice(checkVoice.isSelected());
				langIndex = cbLang.getSelectedIndex();
				int timeCountdown = Integer.parseInt(txtTime.getText());
				if(timeCountdown >= 7) timeCountdown = 7;
				config.setConfigISO6391((String)config.getJsonISO6391().get(langIndex));
				config.setConfigCountdown(timeCountdown);
				if(timeCountdown == 0) {
					config.setConfigTrigg(false);
				}else config.setConfigTrigg(true);
				config.updateJSON();
			}
		});
		btnOk.setBounds(308, 161, 89, 23);
		frmEasyTranslateConfig.getContentPane().add(btnOk);
		
		checkStartup = new JCheckBox("Khởi động cùng Windows");
		checkStartup.setEnabled(false);
		checkStartup.setBackground(new Color(255, 255, 255));
		checkStartup.setForeground(new Color(153, 50, 204));
		checkStartup.setBounds(10, 112, 192, 23);
		checkStartup.setSelected((boolean)config.getJsonConfig().get("Startup"));
		frmEasyTranslateConfig.getContentPane().add(checkStartup);
		
		checkHistory = new JCheckBox("Lưu lịch sử dịch");
		checkHistory.setBackground(new Color(255, 255, 255));
		checkHistory.setForeground(new Color(153, 50, 204));
		checkHistory.setBounds(10, 139, 117, 23);
		checkHistory.setSelected((boolean)config.getJsonConfig().get("History"));
		frmEasyTranslateConfig.getContentPane().add(checkHistory);
		
		checkVoice = new JCheckBox("Chị Google");
		checkVoice.setBackground(new Color(255, 255, 255));
		checkVoice.setForeground(new Color(153, 50, 204));
		checkVoice.setBounds(10, 165, 97, 23);
		checkVoice.setSelected((boolean)config.getJsonConfig().get("Voice"));
		frmEasyTranslateConfig.getContentPane().add(checkVoice);
	}
}
