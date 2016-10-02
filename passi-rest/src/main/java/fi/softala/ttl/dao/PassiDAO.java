/**
 * @author Mika Ropponen
 */
package fi.softala.ttl.dao;

import java.util.ArrayList;

import fi.softala.ttl.model.AnswerWorksheetDTO;
import fi.softala.ttl.model.Member;
import fi.softala.ttl.model.Worksheet;

public interface PassiDAO {
	
	public Member getStudent(String username);
	
	public ArrayList<Worksheet> getWorksheets(String groupID);
	
	public boolean isAnswerExist(int worksheetID);
	
	public void saveAnswer(AnswerWorksheetDTO answer);
	
	public boolean deleteAnswer(int worksheetID, String username);
}