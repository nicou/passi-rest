/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String groupID;
	private String groupName;
	private String instructorID;
	
	public Group() {
		super();
		this.groupID = "";
		this.groupName = "";
		this.instructorID = "";
	}

	public Group(String groupID, String groupName, String instructorID) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.instructorID = instructorID;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}

	@Override
	public String toString() {
		return "Group [groupID=" + groupID + ", groupName=" + groupName + ", instructorID=" + instructorID + "]";
	}	
}
