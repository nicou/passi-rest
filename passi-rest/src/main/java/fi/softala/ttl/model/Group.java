/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int groupID;
	private String groupName;
	private int instructorID;
	
	public Group() {
		super();
		this.groupID = 0;
		this.groupName = "";
		this.instructorID = 0;
	}

	public Group(int groupID, String groupName, int instructorID) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.instructorID = instructorID;
	}

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}	
}
