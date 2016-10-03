package fi.softala.ttl.exception;

public class WorksheetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int groupID;
	
	public WorksheetNotFoundException(int groupID) {
		this.groupID = groupID;
	}
	
	public int getGroupID() {
		return groupID;
	}
}
