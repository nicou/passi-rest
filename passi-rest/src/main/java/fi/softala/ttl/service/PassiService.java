package fi.softala.ttl.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.ttl.model.Answersheet;
import fi.softala.ttl.model.AuthUser;
import fi.softala.ttl.model.Category;
import fi.softala.ttl.model.User;

@Service("passiService")
@Transactional
public interface PassiService {
	
	public List<AuthUser> getAuthUsers();
	
	public boolean addUser(AuthUser user);
	
	public User findUser(String username);
	
	public User findUser(String username, String email);
	
	public List<Category> getWorksheets(int groupID, String username);

	public Answersheet getAnswers(int worksheetID, int groupID, int userID);
	
	public boolean saveAnswer(Answersheet answersheet);
	
	public boolean deleteAnswer(int worksheetID, int userID);
	
	public boolean isAnswerExist(int worksheetID, int userID);
	
	public boolean isGroupExist(String key);
	
	public boolean joinUserIntoGroup(String key, int userID);
	
	public Map<Integer, Integer> feedbackCompleteMap(int groupID, int userID);
	
	public Map<String, Long> getProgress(String username);
	
	public boolean isCorrectUser(int userID, String username);
	
}
