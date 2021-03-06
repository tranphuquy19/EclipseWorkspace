package EasyTranslate;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class GetClipboardText extends Thread {
	private String txt1 = "";
	private JSONConfig config = new JSONConfig();

	public void run() {
		String path_java = config.getUsername();
		System.out.println(path_java);
		boolean trigg;

		while (true) {
			trigg = config.isConfigTrigg();
			if (!trigg) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				config.changed();
				System.out.println(config.getJsonConfig().get("Trigg"));
				continue;
			}
			config.changed();
			boolean voice = (boolean) config.getJsonConfig().get("Voice");
			String temp = "";
			try {
				temp = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (UnsupportedFlavorException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (temp.indexOf("http:") >= 0 || temp.indexOf("https:") >= 0 || temp.indexOf("@gmail.") >= 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			if (txt1.equals(temp) == false) {
				txt1 = temp;
				String os = config.getOS();
				if (os.indexOf("dows") >= 0) {
					System.out.println("run");
					WindowsNotification notif = new WindowsNotification(txt1, path_java, config.getConfigISO6391(),
							voice);
					notif.start();
				} else if (os.indexOf("nux") >= 0) {
					LinuxNotification notif = new LinuxNotification(txt1, path_java, config.getConfigISO6391(), voice);
					notif.start();
				}

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
