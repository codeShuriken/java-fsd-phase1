package learnjava;

public class StringExample {
	private String myName = "ZGowtham";
	public void TestString() {
		System.out.println(myName);
		
		StringBuilder sb = new StringBuilder();
		StringBuffer sf = new StringBuffer();
		
		sb.append(myName);
		sf.append(myName);
		
		System.out.println(sb.toString());
		
		for (int i = 0; i < 10; ++i) {
			sb.append(i);
			System.out.println(sb.toString());
		}
	}
}
