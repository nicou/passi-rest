/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import java.util.List;

import fi.softala.ttl.model.Answersheet;
import fi.softala.ttl.model.User;
import fi.softala.ttl.model.Worksheet;

public interface PassiDAO {
	
	public User findUser(String username);
	
	public List<Worksheet> getWorksheets(int groupID);
	
	public boolean isAnswerExist(int worksheetID, int userID);
	
	public boolean saveAnswer(Answersheet answersheet);
	
	public boolean deleteAnswer(int worksheetID, int userID);
	
	public Answersheet getAnswer(int worksheetID, int groupID, int userID);
	
}