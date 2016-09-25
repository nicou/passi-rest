package fi.softala.ttl.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.ttl.dao.PassiDAO;
import fi.softala.ttl.model.Student;
import fi.softala.ttl.model.User;
import fi.softala.ttl.model.WorksheetDTO;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Inject
	private PassiDAO dao;

	public PassiDAO getDao() {
		return dao;
	}

	public void setDao(PassiDAO dao) {
		this.dao = dao;
	}
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static {
		users = populateDummyUsers();
	}
	
	public Student findStudentByUsername(String username) {
		Student student = new Student();
		student = dao.getStudent(username);
		return student;
	}
	
	public WorksheetDTO getWorksheetByGroupAndUsername(String groupID, String username) {
		WorksheetDTO ws = new WorksheetDTO();
		ws = dao.getWorksheetByGroupAndUsername(groupID, username);
		return ws;
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername()) != null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "admin", "passw"));
		return users;
	}
}
