/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import java.util.List;
import java.util.Map;

import fi.softala.ttl.model.Answersheet;
import fi.softala.ttl.model.AuthUser;
import fi.softala.ttl.model.Category;
import fi.softala.ttl.model.User;

public interface PassiDAO {
	
	public User findUser(String username);
	
	public boolean addUser(AuthUser user);
	
	public List<Category> getWorksheets(int groupID);
	
	public boolean isAnswerExist(int worksheetID, int userID);
	
	public boolean saveAnswer(Answersheet answersheet);
	
	public boolean deleteAnswer(int worksheetID, int userID);
	
	public Answersheet getAnswer(int worksheetID, int groupID, int userID);
	
	public List<AuthUser> getAuthUsers();
	
	public boolean isGroupExist(String key);
	
	public boolean joinUserIntoGroup(String key, int UserID);
	
	public Map<Integer, Integer> feedbackCompleteMap(int groupID, int userID);
	
}