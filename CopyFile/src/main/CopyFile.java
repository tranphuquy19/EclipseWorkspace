package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class CopyFile {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir").replace("\\", "/");
		String name = System.getProperty("user.name");
		String chucmung = "";
		System.out.println(path);
//		try {
//			File dir = new File("C:/Users/"+name+"/Documents/Call My Cat");
//			dir.mkdirs();
//			chucmung += "Đã tạo "+ "C:/Users/"+name+"/Documents/Call My Cat";
//			
//			copyFile(path+"/final.jar", "C:/Users/"+name+"/Documents/Call My Cat/final.jar");
//			//copyFile(path+"/final.jar", "C:/Users/"+name+"/Desktop/final.jar");
		
//			chucmung += "\nĐã copy "+ "C:/Users/"+name+"/Documents/Call My Cat/final.jar";
//			
//			copyFile(path+"/Call My Cat.bat", "C:/Users/"+name+
//					"/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup/Call My Cat.bat");
//			chucmung += "\nĐã copy "+ "C:/Users/"+name+
//					"/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup/Call My Cat.bat";
//			
//			copyFile(path+"/cat.ico", "C:/Users/"+name+"/Documents/Call My Cat/cat.ico");
//			chucmung += "\nĐã copy "+ "C:/Users/"+name+"/Documents/Call My Cat/cat.ico";
//			
//			copyFile(path+"/Call My Cat.lnk", "C:/Users/"+name+"/Desktop/Call My Cat.lnk");
//			chucmung += "\nĐã copy "+ "C:/Users/"+name+"/Desktop/Call My Cat.lnk";
//		}catch(Exception ex)
//		{
//			//new CopyThanhCong(chucmung).setVisible(true);
//			ex.printStackTrace();
//		}
//		//new CopyThanhCong(chucmung).setVisible(true);
//
		
		try {
			File dir = new File("C:/Users/"+name+"/Documents/CallMyCat");
			dir.mkdirs();
			File f1 = new File(path+"/final.jar"); File f11 = new File("C:/Users/"+name+"/Documents/CallMyCat/final.jar");
			
			//File f2 = new File(path+"/Call My Cat.bat"); File f22 = new File("C:/Users/"+name+
			//		"/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup/Call My Cat.bat");
			
			File f3 = new File(path+"/cat.ico"); File f33 = new File("C:/Users/"+name+"/Documents/CallMyCat/cat.ico");
			
			File f4 = new File(path+"/Call My Cat.lnk"); File f44 = new File("C:/Users/"+name+"/Desktop/Call My Cat.lnk");
			File f6 = new File(path+"/Call My Cat.lnk");
			File f66 = new File("C:/Users/"+name+"/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup/Call My Cat.lnk");
			
			//File f5 = new File(path+"/CallMyCat.bat"); File f55 = new File("C:/Users/"+name+"/Documents/CallMyCat/CallMyCat.bat");
			copyFileUsingJava7Files(f1, f11);
			//copyFileUsingJava7Files(f2, f22);
			copyFileUsingJava7Files(f3, f33);
			copyFileUsingJava7Files(f4, f44);
			copyFileUsingJava7Files(f6, f66);
			//copyFileUsingJava7Files(f5, f55);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
		
	private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
	    Files.copy(source.toPath(), dest.toPath());
	}
//	 public static boolean copyFile(String source, String dest) throws FileNotFoundException, IOException {
////       file nguồn
//       File sourceFile = new File(source);
////       file đích
//       File destFile = new File(dest);
////       kiem tra file nguồn có tồn tại không
//       if (sourceFile.exists()) {
////          luồng đọc file
//         FileInputStream fis = new FileInputStream(sourceFile);
////          luồng ghi file
//           FileOutputStream fos = new FileOutputStream(destFile);
//           byte[] arr = new byte[1024];
//           while ((fis.read(arr)) != -1) {
//               fos.write(arr);
//               fos.flush();
//           }
//           fis.close();
//           fos.close();
//           System.out.println("copy thành công");
//           return true;
//       } else {
//           System.out.println("file nguồn không tồn tại");
//           new CopyFalse().setVisible(true);
//           return false;
//       }
//   }

}
