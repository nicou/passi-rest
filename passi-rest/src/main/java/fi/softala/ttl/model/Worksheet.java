/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Worksheet implements Serializable {

	private static final long serialVersionUID = 1L;

	private String header;
	private String preface;
	private String planning;
	private ArrayList<Waypoint> waypoints;
	private String instructorComment;
	
	public Worksheet() {
		super();
		header = "";
		preface = "";
		planning = "";
		waypoints = null;
		instructorComment = "";
	}

	public Worksheet(String header, String preface, String planning, ArrayList<Waypoint> waypoints) {
		super();
		this.header = header;
		this.preface = preface;
		this.planning = planning;
		this.waypoints = waypoints;
		this.instructorComment = "";
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getPreface() {
		return preface;
	}

	public void setPreface(String preface) {
		this.preface = preface;
	}

	public String getPlanning() {
		return planning;
	}

	public void setPlanning(String planning) {
		this.planning = planning;
	}

	public ArrayList<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(ArrayList<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}

	public String getInstructorComment() {
		return instructorComment;
	}

	public void setInstructorComment(String instructorComment) {
		this.instructorComment = instructorComment;
	}
}
