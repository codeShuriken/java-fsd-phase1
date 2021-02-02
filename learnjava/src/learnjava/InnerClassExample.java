package learnjava;

public class InnerClassExample {
	
	public InnerClassExample(String member1) {
		this.myMember1 = member1;
	}
	private String myMember1;
	
	public String getMyMember1() {
		return myMember1;
	}
	
	public String useMyInnerClass() {
		MyInnerClass m = new MyInnerClass("test2");
		String innerClassMyMember2 = m.getMyMember2();
		return innerClassMyMember2;
	}
	
	private class MyInnerClass{
		public MyInnerClass(String myMember2) {
			this.myMember2 = myMember2;
		}
		private String myMember2;
		
		public String getMyMember2() {
			return myMember2;
		}
		
		public String getMyMember1() {
			return myMember1;
		}
		
	}
	

}
