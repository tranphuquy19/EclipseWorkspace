package txtEditor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class TextEditor {
	private String filePath = "";
	private String fileContent = "";

	public TextEditor(String filePath) {
		this.filePath = filePath;
		readFile();
	}

	private void readFile() {
		Reader reader;
		BufferedReader bufferedReader = null;
		try {
			reader = new FileReader(this.filePath);
			bufferedReader = new BufferedReader(reader);
			String lines;
			while ((lines = bufferedReader.readLine()) != null) {
				this.fileContent += lines + "\n";
			}
		} catch (FileNotFoundException ex) {
			System.out.println("The file " + this.filePath + " not found!");
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading file!");
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println("Problem occurs when closing file !");
					e.printStackTrace();
				}
			}
		}
	}

	public String toString() {
		return fileContent;
	}

	public void addBottom(String string) {
		
	}
}
