package fi.softala.ttl.exception;

public class EmptyAnswerContentException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int worksheetID;
	private int groupID;
	private int userID;
	
	public EmptyAnswerContentException(int worksheetID, int groupID, int userID) {
		this.worksheetID = worksheetID;
		this.groupID = groupID;
		this.userID = userID;		
	}
	
	public int getWorksheetID() {
		return worksheetID;
	}
	
	public int getGroupID() {
		return groupID;
	}
	
	public int getUserID() {
		return userID;
	}
}
