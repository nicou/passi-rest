package fi.softala.ttl.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.ttl.dao.PassiDAO;
import fi.softala.ttl.model.Answersheet;

@Service("passiService")
@Transactional
public class PassiServiceImpl implements PassiService {

	@Inject
	private PassiDAO dao;

	public PassiDAO getDao() {
		return dao;
	}

	public void setDao(PassiDAO dao) {
		this.dao = dao;
	}

	@Override
	public Answersheet getAnswers(int worksheetID, int groupID, int userID) {
		return dao.getAnswer(worksheetID, groupID, userID);
	}
	
}
