/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.model;

import java.io.Serializable;
import java.util.List;

public class Group implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String groupID;
	private String groupName;
	private List<User> groupInstructors;
	
	public Group() {
		super();
		this.groupID = "";
		this.groupName = "";
		this.groupInstructors = null;
	}

	public Group(String groupID, String groupName, List<User> groupInstructors) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.groupInstructors = groupInstructors;
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

	public List<User> getGroupInstructors() {
		return groupInstructors;
	}

	public void setGroupInstructors(List<User> groupInstructors) {
		this.groupInstructors = groupInstructors;
	}

	@Override
	public String toString() {
		return "Group [groupID=" + groupID + ", groupName=" + groupName + ", groupInstructors=" + groupInstructors
				+ "]";
	}
}
