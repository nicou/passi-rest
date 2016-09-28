package fi.softala.ttl.service;

import java.util.ArrayList;

import fi.softala.ttl.model.AnswerWorksheetDTO;
import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.Worksheet;

public interface PassiService {
	
	public Student findStudentByUsername(String username);
	
	public ArrayList<Worksheet> getWorksheets(String groupID);
	
	public boolean isAnswerExist(AnswerWorksheetDTO answer);
	
	public boolean isAnswerExist(int worksheetID);
	
	public void saveAnswer(AnswerWorksheetDTO answer);
	
	public boolean deleteAnswer(int worksheetID, String username);
}
