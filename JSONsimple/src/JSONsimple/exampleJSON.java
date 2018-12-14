package JSONsimple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class exampleJSON {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject root = new JSONObject();
		SinhVien sv1 = new SinhVien("Trần Phú Canh", "16TCLC3", 20);
		SinhVien sv2 = new SinhVien("Trần Phú Thanh", "16TCLC5", 50);
		SinhVien sv3 = new SinhVien("", "16TCLC5", 19);
		JSONArray sv = new JSONArray();
		sv.add(sv1.put());
		sv.add(sv2.put());
		sv.add(sv3.put());
		root.put("Sinh vien", sv);
		//System.out.println(root.toJSONString());
		
		//Ghi vào file
		File js = new File("logJSONType\\sinhvien.json");
		try (PrintWriter writer = new PrintWriter(js);){
			writer.write(root.toJSONString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Đọc từ file
		try {
			Scanner input = new Scanner(js);
			StringBuilder jsonString = new StringBuilder();
			while(input.hasNextLine())
			{
				jsonString.append(input.nextLine());
			}
			input.close();
			JSONParser parser = new JSONParser();
			JSONObject rootIn = (JSONObject) parser.parse(jsonString.toString());
			JSONArray svIn = (JSONArray) rootIn.get("Sinh vien");
			for(int i =0; i<svIn.size();i++)
			{
				JSONObject tungSV = (JSONObject) svIn.get(i);
				String nameSV= (String) tungSV.get("name");
				String lop = (String) tungSV.get("classes");
				long age = (long) tungSV.get("age");
				System.out.println("Tổng số sinh viên"+ svIn.size());
				System.out.println("Tên: "+nameSV+"; Lớp:"+lop+"; Tuổi: "+age);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
