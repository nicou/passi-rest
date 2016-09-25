package fi.softala.ttl.exception;

public class WorksheetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String groupID;
	private String username;
	
	public WorksheetNotFoundException(String groupID, String username) {
		this.groupID = groupID;
		this.username = username;
	}
	
	public String getGroupID() {
		return groupID;
	}
	
	public String getUsername() {
		return username;
	}
}
