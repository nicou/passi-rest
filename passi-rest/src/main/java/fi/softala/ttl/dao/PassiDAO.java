/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.Worksheet;

public interface PassiDAO {
	
	public Student getStudent(String username);
	public Worksheet getWorksheet(String groupID);
}