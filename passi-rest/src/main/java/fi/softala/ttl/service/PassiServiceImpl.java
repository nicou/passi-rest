package fi.softala.ttl.service;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.ttl.dao.PassiDAO;
import fi.softala.ttl.model.AnswerWorksheetDTO;
import fi.softala.ttl.model.Member;
import fi.softala.ttl.model.Worksheet;

@Service("passiService")
@Transactional
public class PassiServiceImpl implements PassiService{
	
	@Inject
	private PassiDAO dao;

	public PassiDAO getDao() {
		return dao;
	}

	public void setDao(PassiDAO dao) {
		this.dao = dao;
	}
	
	public Member findStudentByUsername(String username) {
		Member member = new Member();
		member = dao.getStudent(username);
		return member;
	}
	
	public ArrayList<Worksheet> getWorksheets(String groupID) {
		ArrayList<Worksheet> worksheets = dao.getWorksheets(groupID);
		return worksheets;
	}
	
	public boolean isAnswerExist(AnswerWorksheetDTO answer) {
		return dao.isAnswerExist(answer.getWorksheetID());
	}
	
	public boolean isAnswerExist(int worksheetID) {
		return dao.isAnswerExist(worksheetID);
	}
	
	public void saveAnswer(AnswerWorksheetDTO answer) {
		dao.saveAnswer(answer);
	}
	
	public boolean deleteAnswer(int worksheetID, String username) {
		if (dao.deleteAnswer(worksheetID, username)) {
			return true;
		}
		return false;
	}
}
