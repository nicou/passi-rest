package fi.softala.ttl.exception;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	public StudentNotFoundException(String username) {
		this.username = username;
	}
	
	public String getStudentUsername() {
		return username;
	}
}
