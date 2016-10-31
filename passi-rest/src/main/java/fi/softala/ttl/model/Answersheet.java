/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Answersheet implements Serializable {

	private static final long serialVersionUID = 1L;

	private int answersheetID;
	private String planning;
	private String instructorComment;
	private Timestamp timestamp;
	private int worksheetID;
	private int groupID;
	private int userID;
	private ArrayList<Answerpoint> answerpoints;

	public Answersheet() {
		super();
		this.answersheetID = 0;
		this.planning = "";
		this.instructorComment = "";
		this.timestamp = null;
		this.worksheetID = 0;
		this.groupID = 0;
		this.userID = 0;
		this.answerpoints = null;
	}

	public Answersheet(int answersheetID, String planning, String instructorComment, Timestamp timestamp,
			int worksheetID, int groupID, int userID, ArrayList<Answerpoint> answerpoints) {
		super();
		this.answersheetID = answersheetID;
		this.planning = planning;
		this.instructorComment = instructorComment;
		this.timestamp = timestamp;
		this.worksheetID = worksheetID;
		this.groupID = groupID;
		this.userID = userID;
		this.answerpoints = answerpoints;
	}

	public int getAnswersheetID() {
		return answersheetID;
	}

	public void setAnswersheetID(int answersheetID) {
		this.answersheetID = answersheetID;
	}

	public String getPlanning() {
		return planning;
	}

	public void setPlanning(String planning) {
		this.planning = planning;
	}

	public String getInstructorComment() {
		return instructorComment;
	}

	public void setInstructorComment(String instructorComment) {
		this.instructorComment = instructorComment;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getWorksheetID() {
		return worksheetID;
	}

	public void setWorksheetID(int worksheetID) {
		this.worksheetID = worksheetID;
	}
	
	public int getGroupID() {
		return groupID;
	}
	
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public ArrayList<Answerpoint> getAnswerpoints() {
		return answerpoints;
	}

	public void setAnswerpoints(ArrayList<Answerpoint> answerpoints) {
		this.answerpoints = answerpoints;
	}
}
