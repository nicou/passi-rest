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
	private List<Instructor> instructors;
	
	public Group() {
		super();
		this.groupID = "";
		this.groupName = "";
		this.instructors = null;
	}

	public Group(String groupID, String groupName, List<Instructor> instructors) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.instructors = instructors;
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

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
}
