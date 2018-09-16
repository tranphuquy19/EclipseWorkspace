package cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cmdClass {

	public static void main(String[] args) throws IOException {
		Process p = Runtime.getRuntime().exec("cmd /c shutdown -s -t 00");
		String s;
		System.out.println(p.getOutputStream());
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((s = stdInput.readLine()) != null)
		{
			System.out.println(s);
		}
	}

}
