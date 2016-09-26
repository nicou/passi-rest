package fi.softala.ttl.exception;

public class WorksheetsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String groupID;
	
	public WorksheetsNotFoundException(String groupID) {
		this.groupID = groupID;
	}
	
	public String getGroupID() {
		return groupID;
	}
}
