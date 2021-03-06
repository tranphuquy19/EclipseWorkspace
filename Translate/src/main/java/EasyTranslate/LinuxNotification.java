package EasyTranslate;

import java.io.IOException;

import com.darkprograms.speech.translator.GoogleTranslate;

public class LinuxNotification extends Thread {
	private String txt = "";
	private String trans = "";
	private String lang = "";
	@SuppressWarnings("unused")
	private Speech speech;

	public LinuxNotification(String txt, String user, String lang, boolean voice) {
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
				if (voice)
					new Speech(this.trans).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			displayTray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void displayTray() throws IOException {
		Runtime.getRuntime().exec(new String[] { "notify-send", this.txt, this.trans }, null);

	}
}
