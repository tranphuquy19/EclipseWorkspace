package argsExample;

public class ArgsExample {

	public static void main(String[] args) {
		for(int i = 0; i<10; i++) {
			try {
				if(args[i] != null) System.out.println(args[i]);
			}catch(Exception io)
			{
				System.out.println("null");
			}
		}
	}

}
