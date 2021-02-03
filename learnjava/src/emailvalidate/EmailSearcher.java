package emailvalidate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSearcher {
	
	private static final String[] emails = {
		"gowtham.vuppala@hcl.com",	"gowtham@yahoo.com", "gowtham@google.com", "gowtham@microsoft.com", "gowtham@apple.com"
			, "gowtham@mail.co.uk", "gowtham@gmail.com"
	};
	
	public boolean searchEmail(String emailSearch) {
		for (String email : emails) {
			if (email.equals(emailSearch)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validEmail(String email) {
		EmailValidater emailValidater = new EmailValidater();
		return emailValidater.validEmail(email);
	}
	
	public class EmailValidater{
		final String regex = "\\w+\\.?\\w*\\@\\w+\\.\\w+\\.?\\w*";
		
		public boolean validEmail(String email) {
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(email);
					
			return matcher.find();
		}
		
	}
}
