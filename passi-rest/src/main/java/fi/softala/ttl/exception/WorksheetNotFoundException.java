package fi.softala.ttl.exception;

public class WorksheetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String groupID;
	
	public WorksheetNotFoundException(String groupID) {
		this.groupID = groupID;
	}
	
	public String getGroupID() {
		return groupID;
	}
}
