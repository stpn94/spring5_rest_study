package spring5_rest_study.exception;

@SuppressWarnings("serial")
public class DuplicateEmployeeException extends RuntimeException {
	public DuplicateEmployeeException(String message) {
		super(message);
	}

}
