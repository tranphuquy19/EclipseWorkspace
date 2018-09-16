package TH3;

import java.util.Stack;

public class ExceptionTest3 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Stack st = new Stack();
		st.push("Hello");
		System.out.println(st.pop());
		System.out.println(st.pop());
	}
}
