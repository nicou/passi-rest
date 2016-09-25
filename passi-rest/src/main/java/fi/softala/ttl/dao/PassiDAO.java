/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.WorksheetDTO;

public interface PassiDAO {
	
	public Student getStudent(String username);
	public WorksheetDTO getWorksheetByGroupAndUsername(String groupID, String username);
}