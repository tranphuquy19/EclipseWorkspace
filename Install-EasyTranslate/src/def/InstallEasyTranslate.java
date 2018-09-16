package def;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class InstallEasyTranslate {

	private static String InstallPath = "";
	private static String DesktopPath = "";

	private static String shortcutPath = "/Easy Translate.lnk";

	static File srcFolder;
	static File tagFolder;

	private static JSONConfig configPath = new JSONConfig();

	public static void init() {
		InstallPath = configPath.getInstallPath();
		configPath.getHistoryPath();
		configPath.getStartupPath();
		DesktopPath = configPath.getDesktopPath();
		srcFolder = new File(configPath.getCurrentFolder());
		tagFolder = new File(InstallPath);

	}

	private static void copyFolder(File sourceFolder, File targetFolder) throws IOException {
		if (sourceFolder.isDirectory()) {
			if (!targetFolder.exists()) {
				targetFolder.mkdir();
			}
			String files[] = sourceFolder.list();
			for (String file : files) {
				File srcFile = new File(sourceFolder, file);
				File tarFile = new File(targetFolder, file);
				copyFolder(srcFile, tarFile);
			}
		} else {
			Files.copy(sourceFolder.toPath(), targetFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
	}
	private static void copyShortcutToDesktop() {
		File s1 = new File(configPath.getCurrentFolder()+shortcutPath);
		File s2 = new File(DesktopPath+shortcutPath);
		try {
			Files.copy(s1.toPath(), s2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception ex) {
			System.out.println("Copy shortcut to Desktop error!");
		}
	}
	public static void main(String[] args) {
		init();
		try {
			copyFolder(srcFolder, tagFolder);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		copyShortcutToDesktop();
	}
}
