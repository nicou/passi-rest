package fi.softala.ttl.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.ttl.dao.PassiDAO;
import fi.softala.ttl.model.Answersheet;
import fi.softala.ttl.model.AuthUser;
import fi.softala.ttl.model.Category;
import fi.softala.ttl.model.User;

/**
 * @author Mika Ropponen | mika.ropponen@gmail.com
 * 
 * The main service responsible for the data persistence and transaction
 * rollbacks. Class level annotation @Transactional ensures that possible
 * unannotated methods use the default values of transaction.
 * 
 * Default propagation = Propagation.REQUIRED used for transactions - no need
 * for higher level.
 */
@Service("passiService")
@Transactional(rollbackFor = Exception.class)
public class PassiServiceImpl implements PassiService {

	@Inject
	private PassiDAO dao;

	public PassiDAO getDao() {
		return dao;
	}

	public void setDao(PassiDAO dao) {
		this.dao = dao;
	}

	/**
	 * Users (username, BCrypt encoded password) for authentication purposes.
	 * 
	 * return List<AuthUser>
	 */
	@Override
	@Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
	public List<AuthUser> getAuthUsers() {
		return dao.getAuthUsers();
	}

	/**
	 * Lower isolation is used for findUser(). findUser() is not used for
	 * authentication.
	 * 
	 * @param username
	 * @return User
	 */
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public User findUser(String username) {
		return dao.findUser(username);
	}

	/**
	 * Get worksheets of a group sorted in categories
	 * 
	 * @param groupID
	 * @return List<Category> including worksheets, waypoints, options
	 */
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public List<Category> getWorksheets(int groupID) {
		return dao.getWorksheets(groupID);
	}

	/**
	 * Get answers of a worksheet with instructor feedback
	 * 
	 * @param worksheetID
	 * @param groupID
	 * @param userID
	 * @return Answersheet answers for one worksheet
	 */
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public Answersheet getAnswers(int worksheetID, int groupID, int userID) {
		return dao.getAnswer(worksheetID, groupID, userID);
	}

	/**
	 * Return boolean, if the user has answered to a worksheet or not
	 * 
	 * @param worksheetID
	 * @param userID
	 * @return boolean
	 */
	@Override
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
	public boolean isAnswerExist(int worksheetID, int userID) {
		return dao.isAnswerExist(worksheetID, userID);
	}

	/**
	 * Save answers of one worksheet. Exceptions and rollback handled locally in
	 * PassiDAOImpl.saveAnswer() method.
	 * 
	 * @param answersheet
	 * @return boolean (success or not)
	 */
	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
	public boolean saveAnswer(Answersheet answersheet) {
		return dao.saveAnswer(answersheet);
	}

	/**
	 * Delete answers of one worksheet. Exceptions and rollback handled locally
	 * in PassiDAOImpl.saveAnswer() method.
	 * 
	 * @param worksheetID
	 * @param userID
	 * @return boolean (success or not)
	 */
	@Override
	@Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
	public boolean deleteAnswer(int worksheetID, int userID) {
		return dao.deleteAnswer(worksheetID, userID);
	}

}
