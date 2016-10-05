/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;
import java.util.List;

public class Waypoint implements Serializable {

	private static final long serialVersionUID = 1L;

	private int     waypointID;
	private String  waypointTask;
	private boolean waypointPhotoEnabled;
	
	private List<Option> waypointOptions;
	
	public Waypoint() {
		super();
		this.waypointID = 0;
		this.waypointTask = "";
		this.waypointPhotoEnabled = false;
		this.waypointOptions = null;
	}

	public Waypoint(int waypointID, String waypointTask, List<Option> waypointOptions) {
		super();
		this.waypointID = waypointID;
		this.waypointTask = waypointTask;
		this.waypointOptions = waypointOptions;
	}

	public int getWaypointID() {
		return waypointID;
	}

	public void setWaypointID(int waypointID) {
		this.waypointID = waypointID;
	}

	public String getWaypointTask() {
		return waypointTask;
	}

	public void setWaypointTask(String waypointTask) {
		this.waypointTask = waypointTask;
	}

	public boolean getWaypointPhotoEnabled() {
		return waypointPhotoEnabled;
	}
	
	public void setWaypointPhotoEnabled(boolean waypointPhotoEnabled) {
		this.waypointPhotoEnabled = waypointPhotoEnabled;
	}
	
	public List<Option> getWaypointOptions() {
		return waypointOptions;
	}

	public void setWaypointOptions(List<Option> waypointOptions) {
		this.waypointOptions = waypointOptions;
	}
}
