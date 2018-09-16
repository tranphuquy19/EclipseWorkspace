package defaultConfig;

import java.awt.EventQueue;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EasyTranslateConfig window = new EasyTranslateConfig();
					window.frmEasyTranslateConfig.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
