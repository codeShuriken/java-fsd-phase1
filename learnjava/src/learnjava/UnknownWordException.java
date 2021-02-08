package learnjava;

public class UnknownWordException extends RuntimeException {
	public UnknownWordException(String word) {
		// TODO Auto-generated constructor stub
		super("Word not found " + word);
	}
}
