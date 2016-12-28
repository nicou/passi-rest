/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;
import java.util.List;

public class Worksheet implements Serializable {

	private static final long serialVersionUID = 1L;

	private int worksheetID;
	private String worksheetHeader;
	private String worksheetPreface;
	private String worksheetPlanning;
	private List<Waypoint> worksheetWaypoints;
	private boolean worksheetCompleted;

	public Worksheet() {
		super();
		this.worksheetID = 0;
		this.worksheetHeader = "";
		this.worksheetPreface = "";
		this.worksheetPlanning = "";
		this.worksheetWaypoints = null;
		this.worksheetCompleted = false;
	}

	public Worksheet(int worksheetID, String worksheetHeader, String worksheetPreface, String worksheetPlanning,
			List<Waypoint> worksheetWaypoints, boolean worksheetCompleted) {
		super();
		this.worksheetID = worksheetID;
		this.worksheetHeader = worksheetHeader;
		this.worksheetPreface = worksheetPreface;
		this.worksheetPlanning = worksheetPlanning;
		this.worksheetWaypoints = worksheetWaypoints;
		this.worksheetCompleted = worksheetCompleted;
	}

	public int getWorksheetID() {
		return worksheetID;
	}

	public void setWorksheetID(int worksheetID) {
		this.worksheetID = worksheetID;
	}

	public String getWorksheetHeader() {
		return worksheetHeader;
	}

	public void setWorksheetHeader(String worksheetHeader) {
		this.worksheetHeader = worksheetHeader;
	}

	public String getWorksheetPreface() {
		return worksheetPreface;
	}

	public void setWorksheetPreface(String worksheetPreface) {
		this.worksheetPreface = worksheetPreface;
	}

	public String getWorksheetPlanning() {
		return worksheetPlanning;
	}

	public void setWorksheetPlanning(String worksheetPlanning) {
		this.worksheetPlanning = worksheetPlanning;
	}

	public List<Waypoint> getWorksheetWaypoints() {
		return worksheetWaypoints;
	}

	public void setWorksheetWaypoints(List<Waypoint> worksheetWaypoints) {
		this.worksheetWaypoints = worksheetWaypoints;
	}

	public boolean isWorksheetCompleted() {
		return worksheetCompleted;
	}

	public void setWorksheetCompleted(boolean worksheetCompleted) {
		this.worksheetCompleted = worksheetCompleted;
	}

}
