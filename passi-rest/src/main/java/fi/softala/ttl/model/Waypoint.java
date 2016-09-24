/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Waypoint implements Serializable {

	private static final long serialVersionUID = 1L;

	private int waypointID;
	private String assignment;
	private ArrayList<AnswerOption> answerOptions; 
	private String instructorComment;
	
	public Waypoint() {
		super();
		this.waypointID = 0;
		this.assignment = "";
		this.answerOptions = null;
		this.instructorComment = "";
	}

	public Waypoint(int waypointID, String assignment, ArrayList<AnswerOption> answerOptions) {
		super();
		this.waypointID = waypointID;
		this.assignment = assignment;
		this.answerOptions = answerOptions;
		this.instructorComment = "";
	}

	public int getWaypointID() {
		return waypointID;
	}

	public void setWaypointID(int waypointID) {
		this.waypointID = waypointID;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public ArrayList<AnswerOption> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(ArrayList<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public String getInstructorComment() {
		return instructorComment;
	}

	public void setInstructorComment(String instructorComment) {
		this.instructorComment = instructorComment;
	}
}
