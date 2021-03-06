package EasyTranslate;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.net.MalformedURLException;

import com.darkprograms.speech.translator.GoogleTranslate;

public class WindowsNotification extends Thread {
	private String txt = "";
	private String trans = "";
	private String user = "";
	private String lang = "";
	@SuppressWarnings("unused")
	private Speech speech;

	public WindowsNotification(String txt, String user, String lang, boolean voice) {
		this.lang = lang;
		String temp = "";
		if (txt.length() > 25) {
			for (int i = 0; i < 25; i++) {
				temp += txt.charAt(i);
			}
			this.txt = temp + "...";
		} else
			this.txt = txt;
		try {
			if (GoogleTranslate.detectLanguage(txt).equals("vi") == false) {
				if (voice)
					new Speech(txt).start();
				System.out.println(GoogleTranslate.detectLanguage(txt));
				this.trans = (String) GoogleTranslate.translate("vi", txt.replaceAll("\\n", " ").toLowerCase());
			} else {
				this.trans = (String) GoogleTranslate.translate(this.lang, txt);
				if (voice) new Speech(this.trans).start();
				System.out.println(this.trans);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.user = user;
	}

	public void run() {
		try {
			displayTray();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayTray() throws AWTException, MalformedURLException {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit()
				.createImage("C:\\Users\\" + user + "\\Documents\\EasyTranslate\\icon.png");
		TrayIcon trayIcon = new TrayIcon(image);
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("Easy Translate");
		tray.add(trayIcon);
		trayIcon.displayMessage(this.txt, this.trans, MessageType.NONE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tray.remove(trayIcon);
	}
}
