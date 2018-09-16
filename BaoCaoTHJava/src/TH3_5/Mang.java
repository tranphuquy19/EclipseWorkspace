package TH3_5;
public class Mang {
	public static void main(String[] args) {
		MyInput Nhap = new MyInput();
		try {
			int i, k;
			double[] myarray;
			System.out.println("Nhap vao so phan tu cua mang");
			i = Nhap.nhapInt();
			myarray = new double[i];
			for (int j = 0; j < myarray.length; j++) {
				System.out.println(" Nhap vao gia tri phan tu thu " + j);
				myarray[j] = Nhap.nhapDouble();
			}
			System.out.println(" Hay nhap vao so thu tu phan tu can truy cap");
			k = Nhap.nhapInt();
			System.out.println(" Gia tri cua phan tu can truy cap la:" + myarray[k]);
		} catch (RuntimeException ex) {
			System.out.println(ex);
		} finally {
			System.out.println(" Truy cap phan tu ngoai gioi han");
		}
	}

}
