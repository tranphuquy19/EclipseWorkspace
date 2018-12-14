package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class App {

	static MeCung meCung;
	static int maps[][];
	static int kichThuoc;
	static String fileContent = "";
	static String filePath = "mecung.txt";
	
	private static void readFile() {
		Reader reader;
		BufferedReader bufferedReader = null;
		try {
			reader = new FileReader(filePath);
			bufferedReader = new BufferedReader(reader);
			String lines;
			while ((lines = bufferedReader.readLine()) != null) {
				fileContent += lines + "\n";
			}
		} catch (FileNotFoundException ex) {
			System.out.println("The file " + filePath + " not found!");
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
	
	private static void getData()
	{
		maps = null;
		String part[] = fileContent.split("\n");
		kichThuoc  = part.length - 1;
		int kt = Integer.parseInt(part[0]);
		System.out.println("Size: "+Integer.toString(kichThuoc)+"; Content File: ");
		for(int i = 1; i<kichThuoc + 1; i++)
		{
			String part2[] = part[i].split(" ");
			maps = new int[kichThuoc][kichThuoc];
			for(int j = 0; j < kichThuoc; j++)
			{
				System.out.print(part2[j]);
				System.out.print(" ");
				maps[i-1][j] = Integer.parseInt(part2[j]);
			}
			System.out.println("");
		}
		meCung = new MeCung(kichThuoc, maps);
	}
	public static void main(String[] args) {
		readFile();
		getData();

	}

}
