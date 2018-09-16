package TH3;

public class ExceptionTest2 {
	static String thisYear = "2.011";

	public static void main(String[] args) {
		try {
			System.out.println("Next year :" + (Integer.parseInt(thisYear) + 1));
		} catch (Exception e) {
		}
		System.out.println("Hello");
	}
}
