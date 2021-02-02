package learnjava;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class LearnjavaApplicaton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		
		List<Map<String, String>> students = new ArrayList<Map<String,String>>();
		Map<String, String> gowt = new HashMap<String, String>();
		
		gowt.put("name", "gowtham");
		gowt.put("address", "123 Main Street");
		
		students.add(gowt);
		
		System.out.println(gowt.get("name"));
		System.out.println(students);
		
		InnerClassExample i = new InnerClassExample("test1");
		System.out.println(i.getMyMember1());
		System.out.println(i.useMyInnerClass());
		
		StringExample s = new StringExample();
		s.TestString();
		
		ArrayExample arrayExample = new ArrayExample();
		arrayExample.testArrays();
	}

}
