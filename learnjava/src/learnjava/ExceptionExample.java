package learnjava;

import java.util.ArrayList;
import java.util.List;

public class ExceptionExample {
	String correctString = "3";
	String incorrectString = "abc";
	
	String textToTanslate = "Helo There!";
	String properText = "Hello There!";
	public void HandleException() {
		
		List<String> myArray = new ArrayList<>();
		
		try {
			int i = Integer.parseInt(correctString);
			int j = Integer.parseInt(incorrectString);
		}catch(NumberFormatException e){
			System.err.println("Wrong Format");
			System.err.println(e.getMessage());
			//System.err.println(e.getCause());
			//System.exit(1);
		}finally {
			System.out.println("Done with Exeption handling!");
		}
	}
	
	public String UnknownWord() {
		if (!textToTanslate.equals(properText)) {
			throw new UnknownWordException(textToTanslate);
		}
		return textToTanslate;
	}
	
}
