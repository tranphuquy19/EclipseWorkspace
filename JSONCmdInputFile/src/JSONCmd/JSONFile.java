package JSONCmd;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONFile {

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		Scanner sc = new Scanner(System.in);
		String cmd = "";
		String MoTa = "";
		while (true) {
			JSONObject jsonObject2 = new JSONObject();
			System.out.println("Cmd: ");
			cmd = sc.nextLine();
			if("Quit".equals(cmd)) break;
			System.out.println("Mo ta: ");
			MoTa = sc.nextLine();
			jsonObject2.put("CMD", cmd);
			jsonObject2.put("Mo Ta", MoTa);
			jsonArray.add(jsonObject2);
		}
		jsonObject.put("List Cmd", jsonArray);
		System.out.println(jsonObject.toJSONString());

	}

}
