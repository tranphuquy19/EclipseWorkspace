package TH3_6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DocFile {
	public static void main(String[] args) {
		BufferedReader infile = null;
		String filename = "";
		String inLine;
		try {
			System.out.println(" Hay nhap vao ten FILE can doc noi dung ");
			filename = MyInput.nhapXau();
			infile = new BufferedReader(new FileReader(filename));
			inLine = infile.readLine();
			boolean firstLine = true;
			while (inLine != null) {
				if (firstLine) {
					firstLine = false;
					System.out.print(inLine);
				} else {
					System.out.print("\n" + inLine);
				}
				inLine = infile.readLine();
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex + "\n" + " File " + filename + " not found ");
		} catch (IOException ex) {
			System.out.println(ex);
		} finally {
			try {
				if (infile != null)
					infile.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
