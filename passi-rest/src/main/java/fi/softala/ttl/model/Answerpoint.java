/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;

public class Answerpoint implements Serializable {

	private static final long serialVersionUID = 1L;

	private int answerpointID;
	private String answerText;
	private String instructorComment;
	private int instructorRating;
	private String imageURL;
	private int answersheetID;
	private int waypointID;
	private int optionID; // Selected option
	private String optionText;
	
	public Answerpoint() {
		super();
		this.answerpointID = 0;
		this.answerText = "";
		this.instructorComment = "";
		this.instructorRating = 0;
		this.imageURL = "";
		this.answersheetID = 0;
		this.waypointID = 0;
		this.optionID = 0;
		this.optionText = "";
	}

	public Answerpoint(int answerpointID, String answerText, String instructorComment, int instructorRating, String imageURL, int answersheetID,
			int waypointID, int optionID, String optionText) {
		super();
		this.answerpointID = answerpointID;
		this.answerText = answerText;
		this.instructorComment = instructorComment;
		this.instructorRating = instructorRating;
		this.imageURL = imageURL;
		this.answersheetID = answersheetID;
		this.waypointID = waypointID;
		this.optionID = optionID;
		this.optionText = "";
	}

	public int getAnswerpointID() {
		return answerpointID;
	}

	public void setAnswerpointID(int answerpointID) {
		this.answerpointID = answerpointID;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public String getInstructorComment() {
		return instructorComment;
	}

	public void setInstructorComment(String instructorComment) {
		this.instructorComment = instructorComment;
	}
	
	public int getInstructorRating() {
		return instructorRating;
	}

	public void setInstructorRating(int instructorRating) {
		this.instructorRating = instructorRating;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getAnswersheetID() {
		return answersheetID;
	}

	public void setAnswersheetID(int answersheetID) {
		this.answersheetID = answersheetID;
	}

	public int getWaypointID() {
		return waypointID;
	}

	public void setWaypointID(int waypointID) {
		this.waypointID = waypointID;
	}

	public int getOptionID() {
		return optionID;
	}

	public void setOptionID(int optionID) {
		this.optionID = optionID;
	}
	
	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
}
