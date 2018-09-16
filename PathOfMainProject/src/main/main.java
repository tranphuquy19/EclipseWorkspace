package main;

public class main {

	public static void main(String[] args) {
		//Nhớ trích xuất dưới dạng jar runnable
		new Fmain().setVisible(true);
		String path = System.clearProperty("user.name").toString();
		String path_java = path.replace('\\', '/');
		System.out.println("user is:"+path_java);
	}

}
