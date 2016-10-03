package fi.softala.ttl.service;

import java.util.List;

import fi.softala.ttl.model.WorksheetAnswer;
import fi.softala.ttl.model.User;
import fi.softala.ttl.model.Worksheet;

public interface PassiService {
	
	public User findUser(String username);
	
	public List<Worksheet> getWorksheets(int groupID);
	
	public boolean isAnswerExist(WorksheetAnswer answer);
	
	public boolean isAnswerExist(int worksheetID);
	
	public void saveAnswer(WorksheetAnswer answer);
	
	public boolean deleteAnswer(int worksheetID, String username);
}
