package TH_4;

public class JavaExample02 {

	public static void main(String[] args) {
		Box obj1 = new Box();
		Box obj2 = new Box(3, 4, 5);
		Box obj3 = new Box(3);
		Box obj4 = new Box(obj2);
		System.out.println(">> The tich 1 = " + obj1.volumeBox());
		System.out.println(">> The tich 2 = " + obj2.volumeBox());
		System.out.println(">> The tich 3 = " + obj3.volumeBox());
		System.out.println(">> The tich 4 = " + obj4.volumeBox());

	}

}
