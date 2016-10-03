/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;
import java.util.List;

public class Worksheet implements Serializable {

	private static final long serialVersionUID = 1L;

	private int    worksheetID;
	private String header;
	private String preface;
	private String planning;
	
	private List<Waypoint> waypoints;
	
	public Worksheet() {
		super();
		worksheetID = 0;
		header = "";
		preface = "";
		planning = "";
		waypoints = null;
	}

	public Worksheet(int worksheetID, String header, String preface, String planning, List<Waypoint> waypoints) {
		super();
		this.worksheetID = worksheetID;
		this.header = header;
		this.preface = preface;
		this.planning = planning;
		this.waypoints = waypoints;
	}

	public int getWorksheetID() {
		return worksheetID;
	}

	public void setWorksheetID(int worksheetID) {
		this.worksheetID = worksheetID;
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

	public List<Waypoint> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<Waypoint> waypoints) {
		this.waypoints = waypoints;
	}
}
