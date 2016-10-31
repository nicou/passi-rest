package fi.softala.ttl.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.ttl.model.Answersheet;

@Service("passiService")
@Transactional
public interface PassiService {

	public Answersheet getAnswers(int worksheetID, int groupID, int userID);
	
}
