/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;

public class AnswerWaypointDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int answerWaypointID;
	private int worksheetID; // => Worksheet
	private int selectedOptionID; // => AnswerOption
	private String imageURL;
	private String instructorComment;

	public AnswerWaypointDTO() {
		super();
		this.answerWaypointID = 0;
		this.worksheetID = 0;
		this.selectedOptionID = 0;
		this.imageURL = "";
		this.instructorComment = "";
	}

	public AnswerWaypointDTO(int answerWaypointID, int worksheetID, int selectedOptionID, String imageURL,
			String instructorComment) {
		super();
		this.answerWaypointID = answerWaypointID;
		this.worksheetID = worksheetID;
		this.selectedOptionID = selectedOptionID;
		this.imageURL = imageURL;
		this.instructorComment = instructorComment;
	}

	public int getAnswerWaypointID() {
		return answerWaypointID;
	}

	public void setAnswerWaypointID(int answerWaypointID) {
		this.answerWaypointID = answerWaypointID;
	}

	public int getWorksheetID() {
		return worksheetID;
	}

	public void setWorksheetID(int worksheetID) {
		this.worksheetID = worksheetID;
	}

	public int getSelectedOptionID() {
		return selectedOptionID;
	}

	public void setSelectedOptionID(int selectedOptionID) {
		this.selectedOptionID = selectedOptionID;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getInstructorComment() {
		return instructorComment;
	}

	public void setInstructorComment(String instructorComment) {
		this.instructorComment = instructorComment;
	}
}
