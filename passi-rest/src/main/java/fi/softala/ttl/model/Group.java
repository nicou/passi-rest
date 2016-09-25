/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String groupID;
	private String groupName;
	private Instructor instructor;
	
	public Group() {
		super();
		this.groupID = "";
		this.groupName = "";
		this.instructor = null;
	}

	public Group(String groupID, String groupName, Instructor instructor) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.instructor = instructor;
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

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
