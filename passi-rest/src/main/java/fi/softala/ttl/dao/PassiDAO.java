/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import fi.softala.ttl.model.Student;

public interface PassiDAO {
	
	public Student getStudent(String username);
}