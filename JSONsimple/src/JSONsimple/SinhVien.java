package JSONsimple;

import org.json.simple.JSONObject;

public class SinhVien {
	private String name, clases;
	int age;
	public SinhVien(String name, String clases, int age)
	{
		this.name= name;
		this.clases= clases;
		this.age=age;
	}
	@SuppressWarnings("unchecked")
	public JSONObject put()
	{
		JSONObject obj = new JSONObject();
		obj.put("name", this.name);
		obj.put("classes", this.clases);
		obj.put("age", this.age);
		return obj;
	}
}
